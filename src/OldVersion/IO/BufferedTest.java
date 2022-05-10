package Learn.IO;

import java.io.*;

/*
 * 缓冲流：
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 作用：加速读写速度
 * 原因：内部有缓冲区
 * BufferedReader：拥有readLine(); 方法按行读取
 * BufferedWriter：拥有newLine(); 方法换行
 *
 */
public class BufferedTest {
    public static void fileCopy(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 1. 创建 File 对象
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            // 2. 创建流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 3. 读写操作
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4. 关闭流：
            // 要求：先关外层流，再关内层流！！！
            // 说明：在关闭外层流的同时，内层流会自动关闭。
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void fileCopyWithBuf(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            // 1. 创建 File 对象
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            // 2. 创建流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            // 3. 读写操作
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                // 刷新缓冲区
                // bos.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 4. 关闭流：
            // 要求：先关外层流，再关内层流！！！
            // 说明：在关闭外层流的同时，内层流会自动关闭。
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        fileCopy("/Users/stevexu/Downloads/RADStudio-1042-esd-4203.exe","/Users/stevexu/Downloads/RADStudio2.exe");
        long end = System.currentTimeMillis();
        System.out.println("普通复制操作花费时间为： " + (end - start));
        start = System.currentTimeMillis();
        fileCopyWithBuf("/Users/stevexu/Downloads/RADStudio-1042-esd-4203.exe","/Users/stevexu/Downloads/RADStudio3.exe");
        end = System.currentTimeMillis();
        System.out.println("带Buffer复制操作花费时间为： " + (end - start));

    }
}
