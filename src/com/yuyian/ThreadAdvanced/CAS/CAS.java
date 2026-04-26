package com.yuyian.ThreadAdvanced.CAS;
//CAS (Compare and Swap 比较和交换)
//上述逻辑通过'一个CPU指令'来完成 <= 原子的!!!
//本质:拿着内存中的值和寄存器1的值进行比较,如果相等,就把内存中的值和寄存器2的值进行交换
//由于只关心内存的变换,交换也可近似理解成赋值
//CPU的特殊指令完成了上述操作=>操作系统封装了这个指令,形成了一个系统API=>java中又封装了操作系统的API

//CAS的典型应用:
    //1.实现原子类:AtomicInteger
    //2.实现自旋锁

//原子类的开发场景=> 满足统计需求
import java.util.concurrent.atomic.AtomicInteger;

public class CAS {
//    private static int count = 0;
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 5000; i++) {
//                count++;//java不支持运算符重载
                count.getAndIncrement();//count++
//                count.incrementAndGet();//++count
//                count.decrementAndGet();//--count
//                count.getAndIncrement();//count--
//                count.getAndAdd(10);//count += 10
                //...
                //上述都是原子的
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 5000; i++) {
                count.getAndIncrement();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
