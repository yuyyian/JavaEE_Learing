package com.yuyian.ThreadFirstStage.ThreadOp;

public class Demo14_JoinTime {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println(System.currentTimeMillis());
//        Thread.sleep(1000);
//        System.out.println(System.currentTimeMillis());
//        //存在10ms的误差
        Thread t = new Thread(() ->{
            for(int i = 0; i < 5; i++){
                System.out.println("hello Thread");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        t.start();
        System.out.println("主线程等待前");
        t.join(3000);
        System.out.println("主线程等待后");

    }
}
