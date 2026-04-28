package com.yuyian.FileIO.Case;

import java.io.File;
import java.util.Scanner;

//扫描指定目录,并找到名称中包含指定字符的所有普通文件(不包含目录),并且后续询问用户是否要删除文件
//=> 文件查找功能
public class Demo01_FileSearch {
    public static void main(String[] args) {
        //1.让用户输入要查询的文件名
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要搜索的目录");
        String dir = sc.next();
        System.out.println("请输入要查询的指定字符");
        String fileName = sc.next();

        //2.判定目录是否存在
        File rootFile = new File(dir);
        if(!rootFile.isDirectory()){
            System.out.println("目录不存在");
            return;
        }

        //3.进行查找,递归遍历目录中的所有文件和子目录
        scanDir(rootFile,fileName);

    }

    private static void scanDir(File rootFile, String fileName) {
        System.out.println(rootFile.getAbsolutePath());
        //1.列出rootFile里面的内容
        File[] files = rootFile.listFiles();
        if(files==null){
            return;
        }
        //2.遍历数组,判定每个元素的类型
        for(File file:files){
            if(file.isDirectory()){
                scanDir(file,fileName);
            }else if(file.isFile()){
                if(file.getName().contains(fileName)){
                    tryDelete(file);
                }
            }
        }
    }

    private static void tryDelete(File file){
        System.out.println("准备删除文件:" + file.getAbsolutePath());
        Scanner sc=new Scanner(System.in);
        System.out.println("确认是否删除?(Y/N)");
        String choice=sc.next();
        if(choice.equals("Y") || choice.equals("y")){
            file.delete();
            System.out.println("删除成功");
        }
    }
}
