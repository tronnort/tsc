package com.tron.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class OutPutStreamDemo {
    public static void main(String[] args) {
        try {
            // true 参数表示追加还是覆盖
            FileOutputStream fileOutputStream = new FileOutputStream(new File("./java-study/src/main/java/com/tron/file/tron.txt"),true);
            String str = "hello world!";
            byte[] bytes = str.getBytes("utf-8");
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
