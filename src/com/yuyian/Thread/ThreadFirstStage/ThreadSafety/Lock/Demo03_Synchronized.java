package com.yuyian.Thread.ThreadFirstStage.ThreadSafety.Lock;

//<synchronized 的使用方法>
//1.synchronized (锁对象){} =>不是禁止调度,而是禁止其他线程插队 互斥性
    //基础使用,常用方法
//2.修饰一个普通方法,就可以省略锁对象
    //此时相当于对this加锁,不是没有锁对象
//3.synchronized 修饰一个静态方法
    //此时认为synchronized是凶狠对类对象加锁:Counter.class
public class Demo03_Synchronized {
   static class Counter{
       private int count = 0;
       private Object locker = new Object();
//       public void add(){
//           synchronized (locker){
//               count++;
//           }
//       }
       synchronized void add(){
           count++;
       }
       //等价于以下写法
       //锁对象是谁不重要,重要的是两个线程是否针对同一个对象加锁
//       public void add(){
//           synchronized (this){
//               count++;
//           }
//       }
       synchronized public void func(){
       }
//       //等价于以下写法
//       public static void func2(){
//           synchronized (Counter.class){
//
//           }
//       }
   }

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        Thread t1 = new Thread(()->{
            for(int i=0;i< 100;i++){
                counter.add();
            }
        });
        Thread t2 = new Thread(()->{
            for(int i=0;i< 100;i++){
                counter.add();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.count);

    }
}
