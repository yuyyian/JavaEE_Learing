package com.yuyian.ThreadAdvanced.JUC.Collection;
//JUC提供了一些线程安全的集合类

//多线程环境使用ArrayList
    //1.自己使用同步机制(synchronized & ReentrantLock)
    //2.Collection.synchronizedList(new ArrayList); => [关键方法都是带有synchronized]
        //synchronizedList是标准库提供的一个基于synchronized进行线程同步的List
    //3.使用CopyOnWriteArrayList => 写时拷贝

//多线程使用哈希表
    //1.自己加锁
    //2.HashTable 类似于Vector,在关键方法上加了synchronized => 针对this加锁，任何一个线程，只要操作这个hashTable就有可能触发锁竞争
    //上述这两种方法都不推荐使用
    //3.ConcurrentHashMap => 针对多线陈场景专门优化的哈希表
        //最大的调整就是针对锁的粒度进行了调整
            //因为对哈希表来说，如果两个线程的修改，是在不同的链表上，本身就是线程安全的 => 锁桶方案
            //真正出发锁竞争的情况是非常小的,几乎忽略不计~~
            //拿每个链表的头节点作为锁对象,可以减少不必要的开销
        //同时采取来了原子类的方案,基于CAS操作,针对size进行变更
        //ConCurrentHashMap扩容的时候,采取"化整为零"的方案
            //不会一次性把所有键值对都搬运过去.而是每次只搬一点(确保这次搬运的速度足够快,持有锁的时间比较短)

import java.util.ConcurrentModificationException;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class Demo01 {
    public static void main(String[] args) {
//        Hashtable<String,String> hashtable = new Hashtable<>();
//        hashtable.put("111","a");
//        hashtable.get("111");
        ConcurrentHashMap<String,String> hashMap = new ConcurrentHashMap<>();
        hashMap.put("key1", "value1");
        hashMap.get("key2");
        //

    }
}
