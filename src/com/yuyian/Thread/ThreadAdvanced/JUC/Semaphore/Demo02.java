package com.yuyian.Thread.ThreadAdvanced.JUC.Semaphore;
import java.util.concurrent.Semaphore;
//通过信号量来实现线程安全
//编写线程安全代码的时候:
//1.加锁[最主要]
//2.CAS/原子类
//3.信号量

public class Demo02 {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);

        Thread t1 = new Thread(() ->{
            for(int i=0;i<5000;i++){
                try {
                    //P操作就相当于加锁了
                    semaphore.acquire();
                    count++;
                    semaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        Thread t2 = new Thread(() ->{
            for(int i=0;i<5000;i++){
                try {
                    semaphore.acquire();
                    count++;
                    semaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
