package com.yuyian.FileIO.FileOp.Content;
//文件内容操作 => 基于"流"对象实现(Stream) [数据传输的通道]
//在IO过程中,输入输出是以CPU为基准,进行考虑的
// 读文件:硬盘的数据读到内存
// 写文件:内存的数据写到硬盘

//java中通过一系列的类来表示流对象
//分为两大类:
    //1.字节流 => 读写数据的时候是以字节为基本单位,一次最少读写一个字节
    //常用于读写二进制文件
        //InputStream 读
        //OutputStream 写
    //2.字符流 => 读写数据的时候是以字符为基本单位,一次最少读写一个字符 => 一个字符有可能对应多个字节
    //常用于读写文本文件
        //Reader 读
        //Writer 写



public class Demo01_FileContentOp {
}
