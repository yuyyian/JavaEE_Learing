package com.yuyian.Thread.ThreadAdvanced.JUC;
//ReentrantLock => 可重入锁
//其是一个比较传统的锁,再synchronized还不成熟的时候,这个锁就是进行多线陈编程加锁的主要方案

//ReentrantLock Vs synchronized
//1.ReentrantLock是java实现的,synchronized是关键字,由jvm内部实现
//2.ReentrantLock需要手动释放,synchronized是自动释放
//3.synchronized在申请锁失败的情况下,会死等;而ReentrantLock可以通过tryLock()的方式等待一段时间就放弃
//4.synchronized是非公平锁,而ReentrantLock默认是非公平锁,但可以通过构造方法传入一个true来开启公平模式
//5.ReentrantLock可以搭配Condition类来实现等待-唤醒,可以更精确的唤醒某个指定的线程

import java.util.concurrent.locks.ReentrantLock;

public class Demo03_ReentrantLock {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock Locker = new ReentrantLock();
        Thread t1 = new Thread(()->{
            for(int i=0;i<50000;i++){
//                Locker.lock();
//                count++;
//                Locker.unlock();
//                //这种写法有可能执行不到unlock
                try{
                    Locker.lock();
                    count++;
                } finally{
                    Locker.unlock();
                }
                //这种写法是更推荐的

            }
        });
        Thread t2 = new Thread(()->{
            for(int i=0;i<50000;i++){
                Locker.lock();
                count++;
                Locker.unlock();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
