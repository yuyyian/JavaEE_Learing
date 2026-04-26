package com.yuyian.ThreadFirstStage.ThreadOp;
//跟简单的写法!=>创建线程 (基于lambda表达式)
public class Demo05_EasierWay {
    public static void main(String[] args) {
        //lambda表达式,本质是匿名方法
        Thread t = new Thread(() -> {
            while(true){
                System.out.println("hello thread!");
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

    }
}
