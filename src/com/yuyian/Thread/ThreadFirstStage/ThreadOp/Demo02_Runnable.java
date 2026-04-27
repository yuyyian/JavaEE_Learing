package com.yuyian.Thread.ThreadFirstStage.ThreadOp;
//第二种写法:实现Runnable接口
//描述任务的时候,任务代码是写到Runnable的实现类中的
//即任务内容和Thread类的耦合程度比较低
//后续可以把任务交给进程和协程(纤程)更方便

class MyRunnable implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("hello thread");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class Demo02_Runnable {
    public static void main(String[] args) {
        Runnable r1 = new MyRunnable();
        Thread t1 = new Thread(r1);
        t1.start();
        while(true){
            System.out.println("hello main");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
