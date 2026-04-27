package com.yuyian.Thread.ThreadFirstStage.ThreadOp;

public class Demo06_Name {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"我的线程");
        t.setDaemon(true);
        System.out.println("是否存活" + t.isAlive());
        t.start();
        System.out.println("是否存活" + t.isAlive());
        //注意事项:
        //start执行后,main方法就运行结束了
        //main线程也就结束了
        //对于一个线程来说,他的入口方法执行完毕,就意味着线程销毁

        System.out.println("是否为后台线程:" + t.isDaemon());
        for(int i = 0; i < 3; i++){
            System.out.println(Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
