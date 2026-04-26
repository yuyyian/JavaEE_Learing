package com.yuyian.ThreadFirstStage.ThreadOrder;
import java.util.Scanner;
//wait:
//1.是当前执行的代码进行等待,并释放当前锁
//2.满足一定条件被唤醒,重新尝试获取这个锁
//分为两个阻塞:waiting(等待notify),blocked(重新获取锁有可能遇到锁竞争)
//也可设定等待的时间上限(超时时间) wait(1000)

public class Demo01_2 {
    private static Object locker = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            System.out.println("t1 wait之前");
            synchronized (locker) {
                try {
                    locker.wait(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("t1 wait之后");
        });

        Thread t2 = new Thread(() ->{
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入任意内容唤醒t1");
            sc.nextLine();
            synchronized (locker) {
                locker.notify();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
