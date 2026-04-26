package com.yuyian.ThreadFirstStage.ThreadOrder;
//notify:
//如果有多个线程都在进行wait(同一个对象上的wait)
//此时进行notify是随机唤醒其中的一个线程(概率并不均等)

//注意:
//如果不加锁直接notify是没有副作用的
import java.util.Scanner;

public class Demo02 {
    private static Object locker = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            synchronized (locker) {
                System.out.println("t1 wait之前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t1 wait之后");
            }
        });
        Thread t2 = new Thread(() ->{
            synchronized (locker) {
                System.out.println("t2 wait之前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t2 wait之后");
            }
        });
        Thread t3 = new Thread(() ->{
            synchronized (locker) {
                System.out.println("t3 wait之前");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("t3 wait之后");
            }
        });
        Thread t4 = new Thread(() ->{
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入任意内容唤醒t1");
            sc.nextLine();
            synchronized (locker) {
                //locker.notify();
                locker.notifyAll();//此时唤醒等待序列的所有线程
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();

    }
}
