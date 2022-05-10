package Learn.IO;
/* *
 * RandomAccessFile 的使用
 * 1. RandomAccessFile 直接继承于 java.lang.Object 类，实现了 DataInput 和 DataOutput 流
 * 2. RandomAccessFile 既可以作为一个输入流，也可以作为一个输出流
 * 3. 创建 RandomAccessFile 类的实例需要指定一个 mode 参数，该参数指定 RandomAccessFile 的访问模式：
 *      - r         ：只读
 *      - rw        ：读取和写入
 *      - rwd       ：读取和写入，同步文件内容的更新
 *      - rws       ：读取和写入，同步文件内容和元数据的更新
 * 4. RandomAccessFile作为输出流：
 *      若文件不存在，则自动创建。
 *      若文件已存在，则会对原有文件内容从头开始覆盖。
 * 5. RandomAccessFile 类的对象的方法：
 *      seek(int position);         将指针移到position处
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) throws FileNotFoundException {
        RandomAccessFile raf1 = new RandomAccessFile(new File("src/Learn/IO/函数时接口.png"),"r");
        RandomAccessFile raf2 = new RandomAccessFile(new File("src/Learn/IO/img1.png"), "rw");
        byte[] buffer = new byte[1024];
        int len;
        try {
            while((len = raf1.read(buffer)) != -1 ) {
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                raf1.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                raf2.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
