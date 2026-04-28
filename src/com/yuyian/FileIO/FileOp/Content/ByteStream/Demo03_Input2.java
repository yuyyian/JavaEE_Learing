package com.yuyian.FileIO.FileOp.Content.ByteStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Demo03_Input2 {
    private static void readFile()  {
        InputStream inputStream = null;
        try{
            inputStream = new FileInputStream("./test.txt");
            while(true){
                byte [] b = new byte[1024];
                int len = inputStream.read(b);
                if(len == -1){
                    System.out.println("读取结束!");
                    break;
                }
                for(int i=0;i<len;i++){
                    System.out.printf("0x%x",b[i]);
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            try {
                if(inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void readFile2(){
        //使用 try with resource 与发来简化上述代码
        // try执行结束之后就会自动调用close方法
        try(InputStream inputStream = new FileInputStream("./test.txt")){
            while(true){
                byte [] b = new byte[1024];
                int len = inputStream.read(b);
                if(len == -1){
                    System.out.println("读取结束");
                    break;
                }
                for(int i=0;i<len;i++){
                    System.out.printf("0x%x",b[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        readFile();
    }
}
