package org.evolution.io.file;

import java.io.*;
import java.util.Arrays;

/*
* 一个汉字存储
*
* gbk  两个字节
* unf-8 三个字节
*
*
* */
public class ByteFileTransfer {


    public static void main(String[] args) throws IOException {
//        inputMethod();
//        outputMethod();
//        BufferedInputStream bufferedInputStream
//        byteTransfer();
//        byteArrayTransfer();
          String s  =  "中国";
        System.out.println(Arrays.toString(s.getBytes()));
    }

    private static void byteArrayTransfer() throws IOException {
        FileInputStream fis = new FileInputStream("1.txt");
        FileOutputStream fos = new FileOutputStream("2.txt",true);
        byte[] data = new byte[1024];
        int by;
        while ((by = fis.read(data)) != -1) {
            fos.write(data,0,by);
        }
        fis.close();
        fos.close();
    }

    private static void byteTransfer() throws IOException {
        FileInputStream fis = new FileInputStream("1.txt");
        FileOutputStream fos = new FileOutputStream("2.txt",true);
        int by;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }
        fis.close();
        fos.close();
    }

    private static void outputMethod() throws IOException {
        File file = new File("1.txt");
        OutputStream os = new FileOutputStream(file,true); // 默认写入并覆盖
        String str = "中国你好";
        os.write(str.getBytes());
        os.close();
    }

    private static void inputMethod() throws IOException {
        /*查询是否有这个文件，没有则创建*/
        File file = new File("2.txt");
        InputStream is = new FileInputStream(file);

        /*在内存中开辟一块空间*/
        byte[] data = new byte[1024];

        /*把数据读取到内存*/
//        is.read(data); // 读取1024个字节数据
//        is.read(); // 读取1字节数据
//        System.out.println(new String(data).toString());

        /*读取完返回-1*/
        int by;
        while ((by = is.read()) != -1) {
            System.out.print((char)by);
        }

        is.close();
    }
}
