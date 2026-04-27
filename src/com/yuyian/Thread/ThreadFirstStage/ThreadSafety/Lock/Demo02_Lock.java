package com.yuyian.Thread.ThreadFirstStage.ThreadSafety.Lock;
//为解决Demo01的问题 我们无法从原因1\2入手
//只能通过修改操作,使其变为原子的来解决
//具体方法:加锁!(把一段代码打包成一个整体) =>实现原子性
//关键字:synchronized + 代码块
public class Demo02_Lock {
    public static int count;
    private static Object locker = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for(int i=0;i< 100;i++){
                //括号里面填写锁对象,且任何对象都可以是锁对象
                //打包成一个原子(并不是把多个指令变成一条指令)
                //加锁会影响到其他的加锁线程,而且是加同一个锁的线程
                //当两个线程竞争同一把锁才会产生阻塞
                synchronized (locker){
                    count++;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i=0;i< 100;i++){
                synchronized (locker){
                    //等待t1 unlock后才会加锁执行任务逻辑
                    count++;
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("count:"+count);
    }
}
