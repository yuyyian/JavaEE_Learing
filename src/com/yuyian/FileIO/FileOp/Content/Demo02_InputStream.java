package com.yuyian.FileIO.FileOp.Content;

import java.io.*;

public class Demo02_InputStream {
    public static void main(String[] args) throws IOException {
        // 创建文件流对象,这个操作就对应操作系统中的,"打开文件"
        InputStream inputStream = new FileInputStream("./test.txt");
        //read无参数版本一次读取一个字节
//        while(true){
//            //用int接收是为了应对read读到末尾返回-1的情况
//            int c = inputStream.read();
//            if(c==-1){
//                System.out.println("读取完毕");
//                break;
//            }
//            //字节内容,更习惯用16进制表示
//            System.out.printf("0x%x\n",c);

        //read有参数版本,每次读取会尽可能把byte[]数组填满
        while(true){
            byte[] bytes = new byte[1024];//空数组
            int n = inputStream.read(bytes);//输出型参数,由read内部在参数数组中进行填充
            //返回值n为实际读到的有效字节数
            if(n==-1){
                System.out.println("读取完毕");
                break;
            }
            System.out.println("n = " + n);
            for(int i=0;i<n;i++){
                System.out.printf("0x%x\n",bytes[i]);
            }
        }
        //read三参数版本,每次从off(offset)开始填充,共填充len个字节 => 只使用数组的一部分

        //读取完毕,循环break后,需要关闭文件 => 否则会导致内存泄漏
        inputStream.close();
    }
}
