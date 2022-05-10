package Learn.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * 测试 FileInputStream 和 FileOutputStream 的使用
 *
 *
 *
 */
public class FileInputOutputTest {
    public static void main(String[] args) {
        //
        File file = new File("src/Learn/IO/Hello");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
