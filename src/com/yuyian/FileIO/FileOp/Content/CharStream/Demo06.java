package com.yuyian.FileIO.FileOp.Content.CharStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Demo06 {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("./test.txt",true)) {
            //此处的write,提供了String版本
            writer.write("hello world");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
