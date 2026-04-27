package com.yuyian.Thread.ThreadFirstStage.ThreadOp;

public class Deme10_isInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            //currentTread方法,是在后续t.start后执行的
            //并且是在t线程中执行的,返回的结果自然就是t的引用
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("hello thread");
                try{
                    Thread.sleep(1000);
                    //注意:
                    //如果t线程正好在sleep
                    //此时在main中调用interrupt()就会把sleep提前唤醒;触发InterruptedException
                    //同时重置isInterrupted 标志位
                } catch (InterruptedException e) {
                    e.printStackTrace();//打印异常调用栈
                    //中止之前可以善后:doSomeThing()
                    break;//触发异常就终止
                }
            }
        });
        t.start();
        Thread.sleep(2000);
        //main线程中去终止
        t.interrupt(); //
    }
}
