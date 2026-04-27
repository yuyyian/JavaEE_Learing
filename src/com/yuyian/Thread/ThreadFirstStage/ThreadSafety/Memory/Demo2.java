package com.yuyian.Thread.ThreadFirstStage.ThreadSafety.Memory;
//注意
//volatile解决的是内存可见性问题而不是原子性问题

public class Demo2 {
    private static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            for(int i=0;i<5000;i++){
                count++;
            }
        });
        Thread t2 = new Thread(() ->{
            for(int i=0;i<5000;i++){
                count++;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
