package com.yuyian.Thread.ThreadAdvanced.JUC;
//CountDownLatch
//等待最后一个线程结束
//适用场景:开发中,会涉及到吧一个大的任务,拆成多个子任务,通过多线程并发的方式来分别进行
//因此要等到所有线程的任务都要执行完,才可以进入下一个阶段

import java.util.concurrent.CountDownLatch;

public class Demo04_CountDownLatch {
    public static void main(String[] args) {
        //构造方法传入的参数,就是"任务的个数"
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for(int i = 0; i < 10; i++) {
            int id = i;
            Thread thread = new Thread(() -> {
                //假设线程进行一定的工作,此处就通过sleep来模拟
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程" + id + "执行完毕");
                //相当于运动员到达终点
                countDownLatch.countDown();
            });
            thread.start();
        }

        //主线程通过await方法,等到所有任务都countDown()
        try {
            //a可以理解成all ,就是等待所有任务都结束
            //await阻塞,直到countDownLatch调用countDown的次数,和初始化值相同
            countDownLatch.await();
            System.out.println("所有任务都执行完毕");
        } catch (InterruptedException e) {}
    }

}
