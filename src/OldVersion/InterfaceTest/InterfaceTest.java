package Learn.InterfaceTest;
/*
 * 接口的使用：
 * 1. 接口使用 interface 关键字
 * 2. Java 中，接口和类是并列的两个结构
 * 3. 如何定义接口以及接口中的成员
 *      3.1 JDK7 及以前：只能定义常量和抽象方法
 *          - 全局常量： public static final的,但是书写时可以省略不写，默认即为全局常量
 *          - 抽象方法： public abstract的
 *      3.2 JDK8，除了定义全局常量和方法之外，还可以定义静态方法和默认方法
 * 4. 接口不能定义构造器，意味着接口不能被实例化
 * 5. 开发中，一般用类实现接口——implements
 *    如果一个类实现了接口中所有抽象方法则可以实例化
 *    否则该类为抽象类，不能被实例化
 * 6. Java 可以实现多个接口
 *    格式： class AA extends BB implements CC,DD,EE {}
 * 7. 接口和接口之间可以继承，而且可以多继承
 * 8. 接口的使用，体现多态性
 * 9. 接口实际是一种规范
 * 10. 接口也具有多态性
 * 11. 慢慢理解面向接口编程
 */
public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);
    }
}

interface Flyable {
    // 全局常量
    public static int MAX_SPEED = 7900;   // 第一宇宙速度
    int MIN_SPEED = 1;

    // 抽象方法
    public abstract void fly();
    // 省略了 public abstract
    void stop();
}

class Plane implements Flyable {

    @Override
    public void fly() {
        System.out.println("Flying");
    }

    @Override
    public void stop() {
        System.out.println("Stopped.");
    }
}

abstract class Kite implements Flyable {
    // 未实现方法
}

interface Attackable {
    void attack();
}

class Bullet implements Flyable,Attackable {

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void attack() {

    }
}

interface AA {
    void method1();
}

interface BB {
    void method2();
}
interface CC extends AA, BB {

}

interface M {
    // 静态方法
    public static void KK() {
        System.out.println("I am static.");
    }
    // 默认方法
    public default void method() {
        System.out.println("I am default.");
    }
    default void method1() {
        System.out.println("I am default,too.");
    }
}

class N implements M {
    public static void main(String[] args) {
        N n = new N();
        // n.KK(); 接口中的静态方法只能通过接口来调用
        M.KK();
        // 通过实现类的对象，可以调用接口中的默认方法
        // 如果实现类重写了接口中的默认方法，调用时，调用的仍然是重写后的方法

        // 类优先原则
        // 如果实现类继承的父类和实现的接口中声明了同名同参数的方法
        // 子类未重写方法的前提下，调用的是父类的方法

        // 如果实现类的实现的两个接口中声明了同名同参数的方法，会报错——接口冲突
        // 必须在实现类中重写此方法
        n.method();
        n.method1();
        // 如何在子类/实现类的方法中调用父类、接口中被重写的方法
    }
}