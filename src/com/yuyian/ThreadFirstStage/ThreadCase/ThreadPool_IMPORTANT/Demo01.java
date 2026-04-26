package com.yuyian.ThreadFirstStage.ThreadCase.ThreadPool_IMPORTANT;
// 线程池
//提前把线程创建好,放到一个池子(数据结构)里,后续再申请线程时,直接从池子中取,用完了之后,还回到池子中
//java有现成的实现类=> ThreadPoolExecutor
//java的线程池把线程分为两种:
    //1.核心线程
    //2.临时线程
//构造方法参数复杂:
    //1.int corePoolSize => 核心线程数
    //2.int maximumPoolSize => 总线线程数
    //3.long keepAliveTime => 临时线程最大空闲时间
    //4.TimeUnit unit => 时间单位
    //5.BlockingQueue<Runnable> workQueue => 线程池要完成的任务队列,每个任务都是通过Runnable来描述的
    //6.ThreadFactory threadFactory => 线程工厂
        //{
        //工厂设计模式
        //正常创建一个对象时通过构造方法new出来的,但构造方法存在一定的缺陷,工厂模式就是用来填补这个缺陷的
        //}
        //ThreadFactor是Thread的工厂类,由于再线程中,是需要创建很多线程的.通过工厂可以个性化设定每一个线程的初始化操作(newThread方法)
    //下面这个参数是重难点
    //7.RejectedExecutionHandler handler => 拒绝策略
        //一般当任务阻塞队列满的时候会触发阻塞,但直接让添加任务的线程阻塞是不友好的,因此引入拒绝策略来应对
        //四种拒绝策略:
            //1.AbortPolicy => 直接终止
            //2.CallerRunsPolicy => 调用者负责执行任务
            //3.DiscardOldestPolicy => 丢弃队列中最老的任务
            //4.DiscardPolicy => 丢弃队列最新的任务

//上述构造方法过于复杂,因此java标准库提供了一个简化版本: Executors (对ThreadPoolExecutor进行了封装)
//其本质上也是一个工厂类,对ThreadPoolExecutor进行了不同的初始化

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo01 {
    public static void main(String[] args) {
        //固定线程数目的线程池,核心线程数和最大线程数都是4,没有临时线程
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        //核心线程数设为0 ,最大线程数设置为Int的最大值
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        //固定只有一个线程的线程池 => 用的不多
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        //这个线程池本质是一个定时器,放到这个线程池的任务,会在一定时间后执行
        ExecutorService executorService3 = Executors.newScheduledThreadPool(10);

        for (int i = 0; i < 10; i++) {
            int id = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行一些任务" + id);
                }
            });
        }
    }
}























