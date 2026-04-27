package com.yuyian.Thread.ThreadFirstStage.ThreadSafety.Lock;

public class Demo05_Synchronized3 {
    public static void main(String[] args) {
        Object locker = new Object();
        synchronized (locker){
            synchronized (locker){
                synchronized (locker){
                    System.out.println("hello,no deadlock!");
                }//执行到这里不能释放锁
                //否则,外面三把锁对应的{}就失效了
                //此时这里面的逻辑(doSomething())不再线程安全了
                //doSomething()
            }
            //doSomething()
        }//到这里才能真正释放锁

    }
}
