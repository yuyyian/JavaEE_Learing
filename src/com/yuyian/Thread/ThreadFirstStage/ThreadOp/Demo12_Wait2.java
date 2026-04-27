package com.yuyian.Thread.ThreadFirstStage.ThreadOp;

public class Demo12_Wait2 {
    public static void main(String[] args) throws InterruptedException {
        //获取main线程的引用
        Thread mainThread = Thread.currentThread();

        Thread t = new Thread(() ->{
            //让t线程阻塞等待main线程
            try {
                System.out.println("t线程等待之前");
                mainThread.join();
                System.out.println("t线程等待之后");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();
        //让main线程执行逻辑
        for(int i = 0; i < 5; i++){
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }
}
