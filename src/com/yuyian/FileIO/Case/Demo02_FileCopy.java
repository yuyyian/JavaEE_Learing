package com.yuyian.FileIO.Case;

import java.io.*;
import java.util.Scanner;

public class Demo02_FileCopy {
    public static void main(String[] args) {
        //1.输入源文件和目标文件路径
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入源文件的路径: ");
        String srcPath = sc.next();
        System.out.println("请输入目标文件路径: ");
        String desPath = sc.next();

        //2.判断源文件是否存在
        File srcFile = new File(srcPath);
        if (!srcFile.exists()) {
            System.out.println("源文件不存在!");
            return;
        }
        //3.判定目标文件的父目录是否存在
        File desFile = new File(desPath);
        File parentFile = srcFile.getParentFile();
        if (!parentFile.exists()) {
            System.out.println("目标文件父目录不存在");
            return;
        }

        //4.进行复制
        copy(srcFile,desFile);
    }
    private static void copy(File srcFile, File desFile) {
        //try resource with 支持在try中打开多流对象
        try(InputStream inputStream = new FileInputStream(srcFile);
        OutputStream outputStream = new FileOutputStream(desFile)) {
            while(true){
                byte[] buffer = new byte[1024];
                int len = inputStream.read(buffer);
                if(len == -1){
                    System.out.println("复制完成");
                    break;
                }
                outputStream.write(buffer,0,len);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
