package com.yuyian.ThreadFirstStage.ThreadCase.BlockingQueue;
//阻塞队列 => 一种特殊的队列,也是先进先出 =>用于协调多个线程之间的工作~
//引入 生产者消费者模型
    //减少资源竞争,提高效率
    //可以更好的做到模块之间的"解耦合"
    //削峰 填谷
    //缺点:系统更复杂;如果引入的层次过多就会增加网络开销
//阻塞队列特点:(如封装成消息队列 MQ)
    //1.线程安全的
    //2.带有阻塞功能
        //1)如果队列为空,尝试出队列就会触发阻塞,直到队列不为空
        //2)如果队列满了,尝试入队列,也会触发阻塞,直到队列不满

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

//在java标准库中就有现成的实现 => BlockingQueue
public class Demo01 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bq2 = new ArrayBlockingQueue<>(3);
        BlockingQueue<String> bq = new LinkedBlockingDeque<>(3);

        //入队列,出队列(offer/add 是不带有阻塞功能的)
        bq.put("aaa");
        System.out.println("添加一个元素");
        bq.put("bbb");
        System.out.println("添加一个元素");
        bq.put("ccc");
        System.out.println("添加一个元素");
        bq.put("ddd");
        System.out.println("添加一个元素");

        String s = bq.take();
        System.out.println(s);
    }
}
