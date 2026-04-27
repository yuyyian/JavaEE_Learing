package com.yuyian.FileIO.FileOp;
//Java进行文件操作
//1.文件系统操作 =>依赖于File对象
    //创建文件,删除文件,移动文件,获取文件属性
//2.文件内容操作
    //读文件 && 写文件

//File对象

import java.io.IOException;

public class FileSystemOp {
    public static void main(String[] args) throws IOException {//此异常代表输入输出的过程中出现异常了
        //绝对路径
        //File file = new File("d:/IO/test.txt");
        //相对路径 可从终端找到idea的基准路径:D:\java\code\JavaThread\Thread(PS:PowerShell windows终端名字)
//        File file = new File("./test.txt");

        //注意: ./ => 当前目录 && ../ => 上一级目录

        //1.路径方法
//        System.out.println(file.getParent());
//        System.out.println(file.getName());
//        System.out.println(file.getPath());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getCanonicalPath());

        //2.类别方法
//        System.out.println(file.exists());
//        System.out.println(file.isFile());
//        System.out.println(file.isDirectory());//是不是目录

        //3.创删文件
//        file.createNewFile();
//        if(file.exists()){
//            file.delete();
//        }

//        file.createNewFile();
//        System.out.println("create file");
//        file.deleteOnExit();//不是立刻删除,二十进程推出之后,才触发删除
//        System.out.println("delete file");
//        Scanner sc = new Scanner(System.in);
//        System.out.println("input anything to exit");
//        sc.nextLine();//这里是为了手动创建阻塞

        //4.目录查询方法
//        File file2 = new File("./");
//        System.out.println(Arrays.toString(file2.list()));
//        System.out.println(Arrays.toString(file2.listFiles()));

        //5.创建目录
//        File file1 = new File("./test/aaa/bbb");
//        File file2 = new File("./test");
//        file1.mkdir();//创建一级目录
//        file1.mkdirs();//创建多级目录

        //6.文件改名 ,同时也能实现移动文件的效果 =>原理是在改文件引用
//        File file = new File("./test.txt");
//        if(!file.exists()){
//            file.createNewFile();
//        }
//        Scanner sc = new Scanner(System.in);
//        System.out.println("input anything:");
//        sc.nextLine();
//        File file2 = new File("./test2.txt");
//        file.renameTo(file2);
//        file2.delete();

//        File file = new File("./test/test2.txt");
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//        Scanner sc = new Scanner(System.in);
//        System.out.println("input anything:");
//        sc.nextLine();
//        File file1 = new File("./test2.txt");
//        file.renameTo(file1);


    }

}
