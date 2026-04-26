package com.yuyian.ThreadFirstStage.ThreadSafety.Lock;
//线程安全! ===> 重难点
//线程安全问题 && 线程不安全 : 某逻辑在单线程下执行ok,但在多线程执行会产生bug
    //原因
    //1.[根本] 线程的调度执行是随机的(抢占式执行)=>罪魁祸首
    //2.多个线程同时修改同一个变量
    //3.修改操作,不是原子的
    //4.内存可见性
    //5.指令重排序
public class Demo01 {
    private static int count = 0;
    //写成员变量lambda确实能使用,但此时并不是变量捕获语法,而是内部类访问外部类成员
    //lambda本质就是一个匿名内部类~~(函数式接口)
    public static void main(String[] args) throws InterruptedException {
        //int count = 0;该变量是不能写到main函数里面的
        //Lambda表达式要想正确捕获变量,要求是final或者事实final(即没加final,但也没人去修改)
        Thread t1 = new Thread(() -> {
            for(int i=0;i< 100;i++){
                count++;
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i=0;i< 100;i++){
                count++;
            }
        });
        t1.start();
        t2.start();
        //t1 t2两个线程是在同时修改这个count变量
        //并且修改操作不是原子的,就会产生上述问题
        //count++本身对应三个指令(cpu角度)
        //1.load:把内存里的数值,加载到cpu寄存器里
        //2.add:寄存器的数据加一放到寄存器
        //3.save:把寄存器的值协会到内存中
        //当两个线程的指令重叠就会导致加不到200

        t1.join();
        t2.join();
        System.out.println("count:"+count);
    }
}
