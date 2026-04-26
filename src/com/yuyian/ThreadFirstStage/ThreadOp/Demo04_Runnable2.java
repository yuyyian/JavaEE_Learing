package com.yuyian.ThreadFirstStage.ThreadOp;
//通过匿名内部类的方式创建线程
public class Demo04_Runnable2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello thread");
            }
        });
        t1.start();
    }
}
