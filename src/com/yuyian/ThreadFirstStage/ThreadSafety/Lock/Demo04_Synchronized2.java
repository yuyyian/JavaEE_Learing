package com.yuyian.ThreadFirstStage.ThreadSafety.Lock;
//死锁的情况
//1.一个线程一把锁,连续加锁两次
//2.两个线程两把锁,每个线程分别先获取一把锁,再尝试获取对方的锁(彼此之间互不相让)
//3.N个线程 M个锁 =>哲学家就餐问题(循环等待)

//synchronized第二个特性
//可重入
//嵌套synchronized 可能会引发"死锁问题",而这种嵌套不可避免
//所以"可重入特性"就是为了不让嵌套synchronized不会死锁(一个线程一把锁,加锁两次的情况)
    //让锁对象本身记录下,拥有者是哪个线程
    //后续再针对这个线程加锁的时候,就会判断当前线程是否已经持有锁了
        //如果不是,触发阻塞;如果是,不触发阻塞,直接放行
public class Demo04_Synchronized2 {
    static class Counter {
        private int count = 0;
        private Object locker = new Object();

        synchronized void add(){
            count++;
        }

        void func(){
            synchronized (this){
                func2();
            }
        }
        void func2(){
            synchronized (this){
                count++;
            }
        }
    }

}
