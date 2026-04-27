package com.yuyian.ThreadAdvanced.JUC.Semaphore;
//semaphore => 信号量
//本质就是一个计数器,描述了一种"可用资源"的个数
//围绕可用资源就会有两种操作
    //1.申请资源(P操作):计数器-1
    //2.释放资源(V操作):计数器+1
//如果计数器为0,继续申请资源,就会触发阻塞
//注:上述这些操作都是原子的!
//java把操作系统提供的信号量进行了封装

//信号量,相当于锁概念的进一步延伸
//锁,可以视为"初始值为1"的特殊信号量

import java.util.concurrent.Semaphore;

public class Demo01_Semaphore {
    public static void main(String[] args) throws InterruptedException {
        //构造方法的参数,就是信号量"计数器"的初始值,也就是可用资源的个数
        Semaphore semaphore = new Semaphore(3);
        semaphore.acquire();//申请资源,计数器-1
        System.out.println("执行P操作");
        semaphore.acquire();//申请资源,计数器-1
        System.out.println("执行P操作");
        semaphore.acquire();//申请资源,计数器-1
        System.out.println("执行P操作");
        //此时再申请会进入阻塞状态
        semaphore.acquire();//申请资源,计数器-1
        System.out.println("执行P操作");
        semaphore.release();//释放资源,计数器+1



    }
}
