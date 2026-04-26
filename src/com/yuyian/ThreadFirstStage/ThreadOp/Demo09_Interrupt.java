package com.yuyian.ThreadFirstStage.ThreadOp;
//中断一个线程 => "打断""终止"
//正常情况下,一个线程需要把入口方法执行完才能使线程结束
//有时候,我们希望这个线程能够提前结束(尤其是在sleep过程中)

//方法一:通过变量(自定义一个flag)
//方法二:使用线程内置的标志位: isInterrupted();
public class Demo09_Interrupt {
    private static boolean flag = true;
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            while(flag){
                System.out.println("hello thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        System.out.println("hello main");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = false;
        System.out.println("t线程终止");
    }
}
