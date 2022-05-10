package OldVersion.Collection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("src/Learn/Collection/pros");
        // 加载文件
        pros.load(fis);

        String name = pros.getProperty("name");
        String pswd = pros.getProperty("pswd");

        System.out.println("name = " + name + ", passwd = " + pswd);
    }
}
