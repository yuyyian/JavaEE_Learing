package com.yuyian.Thread.ThreadFirstStage.ThreadCase.Singleton;
//单例模式
//懒汉模式
//线程不安全 => 可能有多个new操作
//引入锁 可以解决上述的问题
class SingletonLazy{
    private static volatile SingletonLazy instance = null;
    private static Object locker = new Object();
    private SingletonLazy(){}
    //第一次使用这个实例的时候,才会创建这个实例,创建时机是更晚的
    public static SingletonLazy getInstance(){
//        synchronized (locker){
//            if(instance==null){
//                instance=new SingletonLazy();
//            }
//        }//此时这段代码每次执行都是会加锁的
//        //而只有第一次创建实例的时候是线程不安全的,后续都是安全的.这样的代码是冗余的,会影响性能


        if(instance == null){//创建好后不再加锁
            synchronized (locker){
                if(instance == null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
        //补充:指令重排序引发的线程安全问题
        //指令重排序也是一种编译优化手段 => 确保逻辑一致,调整代码顺序,效率更高
        //与多线程结合会出问题:eg instance = new SingletonLazy();
        //抽象成三个步骤 =>1第一个执行,2/3顺序无所谓 => 出现123/132两种情况
        //1.申请内存空间
        //2.在内存空间上初始化
        //3.内存地址保存到一个引用变量中
        //当132的时候会出现线程安全问题:t1的13完成但未初始化1,此时t2可以访问引用,但无法调用具体的变量和方法
        //此时虽然t1持有锁,但由于t2没有进行加锁操作,所以t2会直接返回,出现问题
        //解决方法也很简单,给instance加上 volatile关键字,让编译器针对这个变量的读写操作不要触发优化

    }

}

public class Demo03_Lazy {
    public static void main(String[] args) {
        SingletonLazy s1=SingletonLazy.getInstance();
        SingletonLazy s2=SingletonLazy.getInstance();
        System.out.println(s1==s2);
    }

}
