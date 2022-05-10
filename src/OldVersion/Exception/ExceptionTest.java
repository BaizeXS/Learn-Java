package Learn.Exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/*
 * 一、异常的体系结构
 * java.lang.Throwable
 *      |-----java.lang.Error：一般不编写针对性的代码进行处理
 *      |-----java.lang.Exception：可以进行异常的处理
 *              |-----编译时异常
 *                      |-----IOException
 *                              |-----FileNotFoundException
 *                      |-----ClassNotFoundException
 *              |-----运行时异常
 *                      |-----NullPointerException
 *                      |-----ArrayIndexOutOfBoundsException
 *                      |-----ClassCastException
 *                      |-----NumberFormatException
 *                      |-----InputMismatchException
 *                      |-----ArithmeticException
 * 二、异常处理：抓抛模型
 * 过程一——抛：程序在正常运行的过程中，一旦出现异常，就会在异常代码处生成一个对应的异常类对象，并将其抛出，其后的代码也不再执行。
 * 过程二——抓：异常处理方式
 *          - try-catch-finally
 *          - throws
 * 三、try-catch-finally
 * try {
 *      // 可能出现异常的代码
 * } catch (异常类型1 变量名1) {
 *      // 处理异常的方式1
 * } catch (异常类型2 变量名2) {
 *      // 处理异常的方式2
 * } catch (异常类型3 变量名3) {
 *      // 处理异常的方式3
 * }
 * finally {
 *      // 一定会执行的代码
 * }
 * 说明：
 * 1、finally是可选的
 * 2、使用try将可能出现异常的代码包装起来，在执行过程中，一旦出现异常，就会在异常代码处生成一个对应的异常类对象，根据次对象的类型，在catch中匹配
 * 3、一旦try中的异常对象匹配到每个catch时，就会进入catch语句执行异常处理，跳出当前结构（无finally）
 * 4、catch中的异常如果没有子父类关系，则谁声明在上面，谁声明在下面无所谓。
 *    catch中的异常如果有子父类关系，则子类必须在父类上面
 * 5、常用处理异常方法：
 *      - String getMessage();
 *      - printStackTrace();
 * 6、由于运行时异常比较常见，通常不针对运行时异常编写try-catch-finally结构，但是编译时异常需要编写！
 * 7、try-catch-finally 可以嵌套
 *
 * 四、throws + 异常类型
 * 1、"throws + 异常类型"写在方法声明处，指明方法执行时，可能会抛出的异常类型。一旦出现异常，仍然会在异常代码处生成异常类对象，满足throws类型时，则抛出
 * 2、异常代码的后续代码则不再执行
 * 3、方法重写规则之一：子类重写的方法抛出的异常类型不能大于父类被重写方法抛出的异常
 * 五、如何选择
 * 1、若父类中被重写的方法没有throws方式处理异常，子类重写的方法也不能用throws，而应该用try-catch
 * 2、递进式结构整体使用try-catch
 *
 * 六、手动抛出异常——throw
 */
public class ExceptionTest {
    public void f1() {
        String str = "123";
        str = "abc";
        try {
            int num = Integer.parseInt(str);
            System.out.println("Hello World!");
        } catch (NumberFormatException | InputMismatchException e) {
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public void f2() throws IOException {
        File file = new File("Hello.txt");
        FileInputStream fis = new FileInputStream(file);
        int data = fis.read();
        while(data != -1) {
            System.out.println((char)data);
            data = fis.read();
        }
        fis.close();
    }
    public void f3() throws IOException {
        f2();
    }
    public static void main(String[] args) {
        int i = 0;
        if (i == 0) {
            try {
                throw new Exception("I am here.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        try {
            new ExceptionTest().f3();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
