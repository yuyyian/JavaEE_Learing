package com.yuyian.Thread.ThreadAdvanced.JUC;
//JUC => java.util.concurrent

//1.Callable接口    =>call自定义返回值
//类似于Runnable接口 =>run方法返回void

public class Demo01 {
    //通过Runnable的方案,我们需要借助一个成员变量,耦合性比较高
    private static int sum = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            int result = 0;
            for(int i=0 ;i <= 100; i++){
                result += i;
            }
            //由于Runnable是没有后返回值的,所以不能:
            //return result;
            sum = result;
        });
        t1.start();
        t1.join();
        System.out.println(sum);
    }

}
