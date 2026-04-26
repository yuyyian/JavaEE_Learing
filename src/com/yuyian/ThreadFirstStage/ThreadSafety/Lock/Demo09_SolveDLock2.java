package com.yuyian.ThreadFirstStage.ThreadSafety.Lock;
//打破等待循环
public class Demo09_SolveDLock2 {
    public static void main(String[] args) throws InterruptedException {
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(()->{
            synchronized (locker1){
                System.out.println("t1拿到了locker1");
                //此处的sleep是为了线程各自拿到锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (locker2){
                    System.out.println("t1拿到了locker2");
                }
            }

        });
        Thread t2 = new Thread(()->{
            synchronized (locker1){
                System.out.println("t2拿到了locker1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (locker2){
                    System.out.println("t2拿到了locker2");
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
