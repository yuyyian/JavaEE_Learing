package com.yuyian.FileIO.FileOp.Content.CharStream;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo05 {
    public static void main(String[] args) {
        try(Reader reader = new FileReader("./test.txt")){
            //read也是有三种:读一个字符||读若干个字符,填充到char[],返回实际读取的字符数||读若干个字符,填充到char[]的一部分
            while(true){
//                int ch = reader.read();
//                if(ch == -1){
//                    break;
//                }
//                System.out.print((char)ch);

                char[] chars = new char[1024];
                int len = reader.read(chars);
                if(len == -1){
                    break;
                }
                for(int i=0;i<len;i++){
                    System.out.println(chars[i]);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
