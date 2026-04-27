package com.yuyian.Thread.ThreadFirstStage.ThreadOp;
//线程等待 => 约定两个线程结束的先后顺序~~
//让后结束的线程阻塞,等待先结束的线程执行完
public class Demo11_Wait {
    public static void main(String[] args) {
        Thread t = new Thread(() ->{
            for(int i=0;i<5;i++){
                System.out.println("hello thread");
            }
        });
        t.start();

        //主线程中,可以对t线程进行等待
        System.out.println("主线程等待之前");
        //由于join 可能触发阻塞 所以需要抛出InterruptedException异常
        //(补充:任何一个处于阻塞状态的线程都有可能被interrupt提前唤醒,导致抛出异常)
        try {
            t.join();//在哪个线程调用,该线程就是等待的一方(此处是main)
            //join前面是哪个引用,对应的线程就是被等的一方(t)
            //此处就是main等t结束
            //字面理解:t加入到main中
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("主线程等待之后");
    }
}
