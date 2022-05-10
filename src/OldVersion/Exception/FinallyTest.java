package Learn.Exception;
/*
 * 1、finally 是可选的
 * 2、finally 是一定会执行的，即使catch出异常了或者catch语句中有return语句
 * 3、数据库连接、输入输出流、网络编程Socket等资源，JVM无法处理，必须我们手动释放，需要写在finally中
 *
 */
public class FinallyTest {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            System.out.println(a/b);
        } catch(ArithmeticException e) {
            e.printStackTrace();
        }  finally {
            System.out.println("我好帅！");
        }
    }
}
