package com.yuyian.ThreadFirstStage.ThreadSafety.Lock;
//如歌避免代码中出现死锁
//关键在于理解死锁的四个"必要条件"
    //1.锁是互斥的
    //2.锁不可被抢占
        //线程遇到锁会堵塞等待,而不是直接强夺过来  //=>对于synchronized来说,条件一和条件二都是基本特点,无法更改
    //3.请求和保持
        //拿到第一把所得情况下,不去释放第一把锁,再尝试请求第二把锁
    //4.循环等待
        //等待锁释放,等待的关系(顺序)构成了循环


//打破请求和保持
//缺陷:无法解决场景:确实需要拿到锁1的前提,再尝试拿锁2
//因此我们要打破循环的等待关系
//可以针对锁进行编号:约定,加多个锁的时候,必须按照一定的顺序来枷锁(按编号从小到大)
public class Demo07_SolveDLock {
    public static void main(String[] args) throws InterruptedException {
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread(()->{
            synchronized (locker1){
                System.out.println("t1拿到了locker1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //把第二把锁的加锁操作放到第一把锁的外面,先释放第一把所,再尝试加第二把锁
            synchronized (locker2){
                System.out.println("t1拿到了locker2");
            }

        });
        Thread t2 = new Thread(()->{
            synchronized (locker2){
                System.out.println("t2拿到了locker2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (locker1){
                System.out.println("t2拿到了locker2");
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
