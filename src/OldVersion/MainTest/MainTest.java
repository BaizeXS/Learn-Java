package Learn.MainTest;
/*
 * main方法的使用
 *  1. main()方法作为程序的入口
 *  2. main()方法也是一个普通的静态方法，可以通过类来调用
 *  3. main()方法可以作为我们与控制台交互的方式
 */
public class MainTest {
    public static void main(String[] args) {
        Main.main(new String[100]);
    }
}

class Main {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            args[i] = "args_" + i;
            System.out.println(args[i]);
        }
    }
}