package com.yuyian.Thread.ThreadFirstStage.ThreadOp;
//第一种写法:继承Thread
//描述任务的时候,任务代码是写道Thread子类中的
//即任务内容和Thread类的耦合程度比较高


public class Demo01_Thread {

    static class MyThread1 extends Thread{
        public void run(){
            while(true){
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                    //run方法不能用throws 否则就无法构成重写
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.start();
        //t1.run(); 这个方法仍然在主线程中执行的:需要执行完才能执行后面的内容

        while(true){
            System.out.println("hello main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
