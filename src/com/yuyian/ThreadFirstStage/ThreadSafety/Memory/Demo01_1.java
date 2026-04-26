package com.yuyian.ThreadFirstStage.ThreadSafety.Memory;
import java.util.Scanner;

public class Demo01_1 {
    private static int flag = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            //此处有一个循环
            while(flag == 0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            //发现虽然没加volatile,但是加了sleep也会是上述程序不再优化~~
            //1.循环速度大幅度降低
            //2.有了sleep一次循环的瓶颈,就不是load.此时编译器就不会优化load
            //3.sleep本身会触发"线程调度",而调度过程会触发上下文且切换
            //但如果换成单纯的变量++,编译器又会优化,所以很难界定触发优化的边界
            System.out.println("t1结束!");
        });

        Thread t2 = new Thread(() ->{
            //修改flag值
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个flag值");
            flag = scanner.nextInt();
            System.out.println("t2结束!");
        });
        t1.start();
        t2.start();
        //发现修改flag值并不会让t1结束
        //这个问题产生的原因就是"内存可见性"
        //即t2对"flag"变量的修改,对t1线程不可见了
        t1.join();
        t2.join();
    }
}
