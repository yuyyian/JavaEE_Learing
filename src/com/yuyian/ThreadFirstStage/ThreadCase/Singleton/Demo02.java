package com.yuyian.ThreadFirstStage.ThreadCase.Singleton;
// 期望这个类只能有一个实例
// 饿汉模式,很紧迫 =>创建实例的时机是非常短的.
// 线程安全(只进行了读操作)
class Singleton{
    // 把唯一的实例创建出来
    private static Singleton instance = new Singleton();

    // 把构造方法设置为private,此时就无法在类的内部来new对象了
    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
}
public class Demo02 {
    public static void main(String[] args) {
        Singleton s1=Singleton.getInstance();
        Singleton s2=Singleton.getInstance();
        System.out.println(s1==s2);
    }
}
