package com.yuyian.Thread.ThreadFirstStage.ThreadOp;
//通过匿名内部类的方式创建线程
public class Demo03_Thread2 {
    public static void main(String[] args) {
        Thread t = new Thread(){  //创建了一个没有名字的子类实例,通过t引用指向
            //子类重写了一个run方法
            @Override
            public void run(){
                while(true){
                    System.out.println("hello Thread");
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();

    }
}
