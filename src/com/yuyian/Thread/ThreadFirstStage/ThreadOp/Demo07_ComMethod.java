package com.yuyian.Thread.ThreadFirstStage.ThreadOp;
//getId()
//getName()
//getState()
//getPriority()

//isDaemon()=> 是否后台线程
//后台线程:线程没有运行完,进程可以结束(线程不能够阻止进程结束)
    //无论有多少个后台线程执行,都无法阻止进程结束
//前台线程:线程没有运行完,进程就不会结束(线程能后阻止进程结束)
//EG:main线程和自己创建的线程 isDaemon=>false 可通过setDaemon(true)将自己的线程改为后台线程
//剩下的就是后台线程(守护线程) isDaemon=>true
    //如果有多个前台线程,就得所有的前台线程都结束后进程才能结束

//isAlive()=> 是否存活
//isInterrupted()=> 是否被中断

//Thread.sleep()
//本质是把一个线程变成阻塞状态 此时该线程就不参加cpu的调度
//直到时间结束,线程状态才恢复成就绪状态(!= 立即执行),等待调度
//实际开发,慎用sleep

public class Demo07_ComMethod {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for(int i = 0; i < 3; i++){
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
        System.out.println("是否存活:"+ t.isAlive());
        Thread.sleep(4000);
        System.out.println("是否存活:"+ t.isAlive());

    }
}
