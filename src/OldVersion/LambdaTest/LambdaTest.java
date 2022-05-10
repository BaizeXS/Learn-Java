package Learn.LambdaTest;

import java.util.function.Consumer;

/* *
 * Lambda 表达式的使用
 * 1. 举例：(o1, o2) -> Integer.compare(o1, o2);
 * 2. 格式：
 *      ->：Lambda 操作符
 *      -> 左边：lambda 形参列表（接口中的抽象方法的形参列表）
 *      -> 右边：lambda 体（重写抽象方法的方法体）
 * 3. Lambda 表达式的使用
 *
 * 4. Lambda 表达式的本质：作为接口的实例
 * */
public class LambdaTest {
    public static void main(String[] args) {
        System.out.println("一、无参数无返回值");
        Runnable r1 = () -> System.out.println("Hello Lambda!");
        r1.run();

        System.out.println("二、有参数无返回值");
        Consumer<String> con01 = (String s) -> System.out.println(s);
        con01.accept("Test01");

        System.out.println("三、有参数无返回值，数据类型可以省略，由编译器推断得出");
        Consumer<String> con02 = (s) -> System.out.println(s);
        con02.accept("Test02");
        System.out.println("四、只有一个参数，可以省略小括号");
        Consumer<String> con03 = s -> System.out.println(s);
        con03.accept("Test03");

    }
}
