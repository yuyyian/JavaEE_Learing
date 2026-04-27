package com.yuyian.Thread.ThreadFirstStage.ThreadSafety.Memory;
//由 "内存可见性" 引发的线程安全问题 =>> 编译器优化机制自身存在的bug
//补充:编译器优化
    //=>编译器再编译执行的过程中,会分析和理解现有代码的意图和效果,
    //然后自动对这个代码进行一个调整和优化,再确保程序执行逻辑不变的情况下,提高编程的效率
    //大部分情况下,编译器优化,可以做到逻辑不变,但有些特定情况下,编译器优化可能出现"误判"到之后逻辑发生改变(eg:多线程代码)

//为解决上述bug 引出volatile(易变的)关键字 修饰那些可能会发生变化的变量,来提醒编译器
import java.util.Scanner;

public class Demo01 {
    private static volatile int flag = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            //此处有一个循环
            //反复执行 (load cmp)
            //编译器会把从内存load数据这个操作优化掉了
            //=> 前几次读内存\
            //=> 后面就直接从寄存器或者缓存(L1,L2,L3...)中读取这个flag
            while(flag == 0){
                //doNothing
            }
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
