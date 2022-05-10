package Learn.InnerClass;
/*
 * 类的内部成员之五：内部类
 * 1. Java中允许将一个类A声明在另一个类B中，则类A为内部类，类B为外部类
 * 2. 内部类的分类：成员内部类（静态、非静态） && 局部内部类（方法内、代码块内、构造器内）
 * 3. 成员内部类：
 *      3.1 作为外部类的成员
 *          > 可以调用外部类的结构
 *          > 可以被 static 修饰
 *          > 可以被四种权限修饰符修饰
 *      3.2 作为一个类
 *          > 类内可以定义属性、方法、构造器、类等
 *          > 可以被 final 修饰，表示该类不可被继承，反之可以被继承
 *          > 可以被 abstract 修饰
 * 4. 关注以下3个问题
 *      4.1 如何实例化成员内部类对象
 *      4.2 如何在成员内部类中区分调用外部类的结构
 *      4.3 开发中如何使用局部内部类
 */
public class InnerClassTest {
    public static void main(String[] args) {

        // 创建 Dog 实例（静态的成员内部类）
        Person.Dog dog = new Person.Dog();
        dog.bark();
        // 创建 Bird 实例（非静态的成员内部类）
        Person p = new Person();
        Person.Bird bird = p.new Bird();    // .new 操作符
        bird.Sing();
    }
}

class Person {
    String name;
    int age;
    private int IDNumber;

    public void eat() {
        System.out.println("I am eating.");
    }
    // 静态内部类
    static class Dog {
        String name;
        int age;
        public void bark() {
            System.out.println("凯童是条狗");
//          eat();    静态的加载早，故无法调用
        }

    }
    // 非静态内部类
    class Bird {
        String name;
        public Bird() {}
        public void Sing() {
            System.out.println("I am a bird.");
            eat();
            // 调用外部类的属性
            // Person.this.eat();
        }
        public void display(String name) {
            System.out.println(name);                       // 参数 name
            System.out.println(this.name);                  // Bird name
            System.out.println(Person.this.name);           // Person name
        }
    }
    abstract class Cat {}
    final class Deer {}

    public void method() {
        // 局部内部类——方法内
        class A {}
    }

    {
        // 局部内部类——代码块内
        class B {}
    }

    public Person() {
        // 局部内部类——构造器内
        class C{}
    }
}
