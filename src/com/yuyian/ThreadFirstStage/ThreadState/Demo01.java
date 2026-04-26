package com.yuyian.ThreadFirstStage.ThreadState;
//线程的几种状态:
    //new =>Thread对象创建了,但还没start
    //runnable(就绪状态) =>可随时在cpu执行,不触发阻塞
//下面三个都是阻塞状态
    //blocked       =>由于"加锁"产生的阻塞
    //waiting       =>无超时时间的阻塞:join无参版本
    //time_waiting  =>无超时时间的阻塞:join有参版本 sleep()
    //terminated =>线程执行完毕 Thread还没被销毁

public class Demo01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while(true){
                try {
                    Thread.sleep(1000);//time_waiting
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        System.out.println(t.getState());
        System.out.println(t.isAlive());
        t.start();
        System.out.println(t.getState());
        System.out.println(t.isAlive());
        t.join();
        System.out.println(t.getState());
        System.out.println(t.isAlive());
    }
}
