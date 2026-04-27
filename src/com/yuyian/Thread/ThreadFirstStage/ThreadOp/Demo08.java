package com.yuyian.Thread.ThreadFirstStage.ThreadOp;

public class Demo08 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("hello thread");
        });
        t.start();//一个线程只能start一次 否则会抛出IllegalThreadStateException
        //线程进行start后,就是就绪或者阻塞状态
        //对于该状态下的线程是不能再次start的
        System.out.println("hello main");
        //大部分情况是hello main先打印
        //当start之后,
        //main线程和t线程,两个执行流是并发执行的关系,也有可能是hello thread
    }
}
