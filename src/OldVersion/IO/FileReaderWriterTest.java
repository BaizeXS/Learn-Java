package Learn.IO;

import java.io.*;

/*
 * 一、流的分类
 * 1. 操作数据单位：   字节流 && 字符流
 * 2. 数据的流向：    输入流 && 输出流
 * 3. 流的角色：      节点流 && 处理流
 * 二、流的体系结构
 * 抽象基类：            节点流                     缓冲流（处理流的一种）
 * InputStream          FileInputStream             BufferedInputStream
 * OutputStream         FileOutputStream            BufferedOutputStream
 * Reader               FileReader                  BufferedReader
 * Writer               FileWriter                  BufferedWriter
 * 三、基本操作流程
 * 1. File 类的实例化——>加载文件
 * 2. FileReader 流的实例化
 * 3. 读入/写出数据的操作
 * 4. 资源关闭
 * 四、注意点
 * 1. 写出数据时，文件若不存在则新建。若存在，则根据参数选择覆盖或者追加（FileWriter(file,true);）。
 *
 *
 *
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
        /* 读入文件并输出内容
         * 说明：
         * 1、使用read();方法
         * 2、异常处理：为了保证流资源可以执行关闭操作，需要使用 try-catch-finally 处理。
         * 3、读入文件一点要存在，否则会有 FileNotFoundException。
         *
         */
        // 读入实例1
        // 1. 实例化 File 对象，指明要操作的文件
//        File file = new File("src/Learn/IO/Hello");
//        FileReader fr = null;
//        try {
//            // 2. 提供具体的流
//            fr = new FileReader(file);
//            // 3. 数据的读入
//            // read();          返回读入的一个字符。若至末尾，则返回-1。
//            // 方式一：
////        int read = fr.read();
////        while (read != -1) {
////            System.out.print((char)read);
////            read =fr.read();
////        }
////        System.out.println();
//            // 方式二：
//            int data;
//            while((data = fr.read()) != -1) {
//                System.out.print((char)data);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            // 4. 流的关闭操作
//            try {
//                if (fr != null) {
//                    fr.close();
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        // 读入实例2
//        // 1. File 类实例的创建
//        File file2 = new File("src/Learn/IO/Hello");
//        FileReader fr2 = null;
//        try {
//            // 2. FileReader 流的创建
//            fr2 = new FileReader(file2);
//            // 3. 数据读取
//            char[] cbuffer = new char[5];
//            int len;
//            // read(char[] cbuf); 返回读入的字符个数。若至末尾，则返回-1。
//            while((len = fr.read(cbuffer)) != -1) {
//                for (int i = 0; i < len; i++)
//                    System.out.print((char)cbuffer[i]);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            // 4. 流的关闭
//            try {
//                if (fr2 != null) {
//                    fr2.close();
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }

        // 写出实例1
        // 1. 实例化 File 对象，指明要写出的文件
//        File file3 = new File("src/Learn/IO/Hello");
//        // 2. 提供 FileWriter 对象，用于数据的写出
//        FileWriter fw = new FileWriter(file3);
//        // 3. 写出的操作
//        fw.write("I have a dream.");
//        fw.write("What's your name?");
//        // 4. 流资源的关闭
//        fw.close();
        // 文件读写操作
        FileReader fr = null;
        FileWriter fw = null;
        try {
            // 1. 实例化 File 对象
            File srcFile = new File("src/Learn/IO/Hello");
            File destFile = new File("src/Learn/IO/Hi");
            // 2. 创建输入输出流对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            // 3. 读入与写出
            char[] cbuf = new char[5];  // 读入数据的数组
            int len;                    // 记录读入数据个数
            while ((len = fr.read(cbuf)) != -1) {
                // 每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4. 关闭流资源
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
