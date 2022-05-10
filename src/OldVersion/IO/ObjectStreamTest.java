package OldVersion.IO;

import java.io.*;
import java.util.RandomAccess;

/* *
 * 对象流：
 * 1. 对象流分类：ObjectInputStream && ObjectOutputStream
 * 2. 作用：用于存储和读取基本数据类型的数据或者对象的处理流。
 * */
public class ObjectStreamTest {
    public static void main(String[] args) {
        /* *
         * 序列化过程：将内存中的 Java 对象保存到磁盘中或者通过网络传输。
         * 使用：ObjectOutputStream
         * Person 类需要实现 Serializable 接口：
         *      1. 该接口为标识接口，无需重写方法
         *      2. 该接口提供一个全局常量 serialVersionUID
         *      3. 除了Person必须是可序列化的，其内部元素均应该为可序列化的（尤指我们自己定义的类）
         * 补充：ObjectInputStream && ObjectOutputStream 不能操作 static 和 transient 修饰的成员变量
         * */
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("ObjectStreamTest"));
            oos.writeObject(new String("Hello World！"));
            oos.flush();
            oos.writeObject(new Person("杨济赫",10));
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        /* *
         * 反序列化过程：将磁盘中或网络传输中的对象还原为内存中的对象。
         * 使用：ObjectInputStream
         * */
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("ObjectStreamTest"));
            Object obj = ois.readObject();
            String str = (String)obj;
            System.out.println(str);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
