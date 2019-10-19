package com.tron.file;

import java.io.*;

public class CopyDemo {
    public static void main(String[] args) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("./java-study/src/main/java/com/tron/file/name.txt")));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("./java-study/src/main/java/com/tron/file/tron.txt")));
            copy(bufferedInputStream,bufferedOutputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void copy(InputStream input, OutputStream output) throws Exception {
        byte[] buff = new byte[1024];
        int length = 0;
        while ((length = input.read(buff)) != -1) {
            output.write(buff,0,length);
        }
        output.flush();
        input.close();
    }
}
