package com.yuyian.FileIO.FileOp.Content.ByteStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo04_OutputStream {
    public static void main(String[] args) {
        try(OutputStream outputStream = new FileOutputStream("./test.txt",true)){
            //write方法也有三个版本 =>返回值类型是void
            //写一个字节 || 写一个字节数组 || 写字节数组的一部分
            //注意:每次write不是覆盖,而是清空;每次按照写方式打开文件,就会清空原有内容
            //可通过new FileOutputStream 的一个参数 append(追加),来指定每次打开为你文件是否清除
//            outputStream.write(97);
//            outputStream.write(98);
//            outputStream.write(99);
//            outputStream.write(100);
//            //这里写入的就是ABCD的ascii码值

//            outputStream.write(0xe4);
//            outputStream.write(0xbd);
//            outputStream.write(0xa0);
//            outputStream.write(0xe5);
//            outputStream.write(0xa5);
//            outputStream.write(0xbd);

//            //字节数组写入
//            byte[] bytes = {
//                    (byte)0xe4,(byte)0xbd,(byte)0xa0
//            };
//            outputStream.write(bytes);


        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
