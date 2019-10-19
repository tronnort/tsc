package com.tron.file;

import java.io.*;
import java.util.Arrays;

public class InputStreamDemo {
    public static void input(){
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("./java-study/src/main/java/com/tron/file/name.txt"));
            byte[] bytes = new byte[1024];
            int length;
            if ((length = fileInputStream.read(bytes)) != -1) {
                String s = new String(bytes, 0, length);
                System.out.println(s);
            }
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getPath() {
        File file = new File("./");  //获取到项目的目录 到tsc目录
        System.out.println(file.getAbsolutePath());
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//        getPath();
        input();
    }

}
