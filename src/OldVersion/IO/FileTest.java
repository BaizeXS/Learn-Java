package Learn.IO;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/*
 * File 类：
 * 1. File 类的一个对象代表一个文件或者一个文件目录（文件夹）
 * 2. File 能创建、删除、重命名文件和目录，但 File 不能访问内容本身，若要访问
 *    文件内容本身，则需要使用输入/输出流
 * 3. File 类的常用构造器
 *      - public File(String pathname)
 *          以 pathname 为路径创建 File 对象，该路径可以为绝对路径或者相对路
 *          径，相对路径为相对于当前 module
 *      - public File(String pathname, String child)
 *          以 parent 为父路径，child 为子路径创建 File 对象。
 *      - public File(File parent, String child)
 *          根据一个父 File 对象和子文件路径创建 File 对象。
 * 4. 路径分隔符——>可以使用 separator
 * 5. File 类的常用方法
 *    File 类的获取功能：
 *      - public String getAbsolutePath();          获取绝对路径。
 *      - public String getPath();                  获取路径。
 *      - public String getName();                  获取名称。
 *      - public String getParent();                获取上层文件目录路径。若无，返回 null。
 *      - public long length();                     获取文件长度（即字节数）。但是不能返回目录长度。
 *      - public long lastModified();               获取最后一次此改时间，毫秒值。
 *      以下方法适用于文件目录
 *      - public String[] list();                   获取指定目录下的所有文件或者文件目录的名称数组。
 *      - public File[] listFiles();                获取指定目录下的所有文件或者文件目录的 File 数组。
 *    File 类的重命名功能：
 *      - public boolean renameTo(File dest);       把文件重命名为指定的文件路径。
 *    File 类的判断功能：
 *      - public boolean isDirectory();             判断是否是文件目录。
 *      - public boolean isEmpty();                 判断是否是文件。
 *      - public boolean exists();                  判断文件是否存在。
 *      - public boolean canRead();                 判断文件是否可读。
 *      - public boolean canWrite();                判断文件是否可写。
 *      - public boolean isHidden();                判断文件是否隐藏。
 *    File 类的创建功能：
 *      - public boolean createNewFile();           创建文件。若存在，则不创建。
 *      - public boolean mkdir();                   创建文件目录。若存在，则不创建。若上层目录不存在，
 *                                                  则也不创建。
 *      - public boolean mkdirs();                  创建文件目录。若上层文件目录不存在，一并创建。
 *    File 类的删除功能：
 *      - public boolean delete();                  删除文件或者文件夹。
 * 6. 后续 File 类的对象会作为参数传递到流的构造器中，指名读取或者写入的"终点"
 * */
public class FileTest {
    public static void main(String[] args) throws IOException {
        // 创建 File 实例
        // 构造器 1
        File file1 = new File("Hello.txt");
        // 构造器 2
        File file2 = new File("src/Learn/","Hi.txt");
        // 构造器 3
        File file3 = new File("src/Learn/");
        File file4 = new File(file3,"Hello.java");
        /*
         *  public String getAbsolutePath();          获取绝对路径
         *  public String getPath();                  获取路径
         *  public String getName();                  获取名称
         *  public String getParent();                获取上层文件目录路径。若无，返回 null。
         *  public long length();                     获取文件长度（即字节数）。但是不能返回目录长度。
         *  public long lastModified();               获取最后一次此改时间，毫秒值。
         *  public String[] list();                   获取指定目录下的所有文件或者文件目录的名称数组。
         *  public File[] listFiles();                获取指定目录下的所有文件或者文件目录的 File 数组。
         */
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
        // 对目录进行操作
        String[] fList = file3.list();
        for (String s : fList) {
            System.out.println(s);
        }
        File[] files = file3.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
        // File 类的重命名： file1.renameTo(file2) ——> file1 存在，file2 不存在
        System.out.println("File 类的重命名：");
        file1.renameTo(file2);
        // File 类的判断功能：
        System.out.println("File 类的判断功能：");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
        // File 类的创建功能
        System.out.println("File 类的创建功能");
        File file5 = new File("src/Learn/Hi.txt");
        if (!file1.exists()) {
            file1.createNewFile();
            System.out.println("创建成功！");
        } else {
            file1.delete();
            System.out.println("删除成功！");
        }
        {
            file1.delete();
            System.out.println("删除成功！");
        }
    }
}
