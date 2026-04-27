package com.yuyian.Thread.ThreadFirstStage.ThreadCase.Timer_IMPORTANT;


//自己实现的定时器
//定时器要能够同时管理多个任务
//要有一定的数据结构来组织任务
// Arraylist => 添加顺序和执行顺序无关,需要遍历才能找到等待时间最小的任务.时间开销比较大 不太合适
// 优先级队列(堆) =>无论如何插入,都是按照时间先后去排序的,每次只需要取堆顶元素即可(小根堆)


import java.util.PriorityQueue;
//由于会将这个类放到优先级队列中,所以我们要制定一个比较规则
class MyTimerTask implements Comparable<MyTimerTask>{
    private Runnable task;
    //为了和当前时间对比,确认这个任务是否要执行,所以保存一个时间戳是更方便的
    private long time;
    public MyTimerTask(Runnable task,long delay){
        this.task=task;
        //把delay转换成执行任务的绝对时间戳
        this.time = System.currentTimeMillis()+delay;
    }
    @Override
    public int compareTo(MyTimerTask o) {
        //实现小堆的效果
        return (int)(this.time - o.time);
    }

    public Runnable getTask(){
        return task;
    }
    public long getTime(){
        return time;
    }
}

class MyTimer{
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    private Object locker = new Object();
    //
    public MyTimer(){
        //创建一个线程:检测任务是否到时间了,同时执行到时间的任务
        Thread thread = new Thread(()->{
            //循环从队列中取出元素,判断时间是否到达:
            //如果到达,就执行任务,并且出队列
            //如果没到达时间,就等待(忙等<只消耗cpu资源>,进而引发线程饿死)
                //因此不能单纯的continue,而是要wait/notify
            while(true){
                synchronized (locker){
                    while(queue.isEmpty()){
                        try {
                            locker.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    MyTimerTask task = queue.peek();
                    //记录当前时刻时间戳
                    long currentTime = System.currentTimeMillis();
                    if(task.getTime() > currentTime){
                        try {
                            locker.wait(task.getTime()-currentTime);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        //此时的wait需要两种兼顾两种情况:
                        //1.随时有时间短的新任务,随时准备唤醒
                        //2.如果没有新任务,等到一定时间就自然唤醒
                    }else{
                        //时间到了
                        task.getTask().run();
                        queue.poll();
                    }
                }
            }
        });
        thread.start();
    }

    public void schedule(Runnable r,long delay){//TimerTask是Runnable的实现类
        synchronized(locker){
            queue.add(new MyTimerTask(r,delay));
            locker.notify();
        }
    }
}


public class Demo02_MyTimer_IMPORTANT {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new  Runnable(){
            @Override
            public void run(){
                System.out.println("定时任务3000");
            }
        },3000);
        myTimer.schedule(() ->{
                System.out.println("定时任务2000");
            },2000);
        myTimer.schedule(new  Runnable(){
            @Override
            public void run(){
                System.out.println("定时任务1000");
            }
        },1000);
    }
}
