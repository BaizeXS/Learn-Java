package Learn.Abstract;

/*
 * abstract 关键字的使用
 * 1. abstract：抽象
 * 2. abstract 可以修饰的结构：
 *      - 类
 *      - 方法
 * 3. abstract 类：
 *      - 不能被实例化
 *      - 一定有构造器，便于子类对象实例化的时候调用
 *      - 开发中一般会提供抽象类的子类
 * 4. abstract 方法：
 *      - 没有方法体
 *      - 只有方法声明
 *      - 抽象方法只能放在抽象类中，即包含抽象方法的类一定是抽象类，反之不一定
 *      - 若子类重写了父类中的所有抽象方法，则此子类才能被实例化，否则子类为抽象类
 * 5. abstract 注意点
 *      - 不能修饰属性、构造器等
 *      - 不能修饰私有方法、静态方法、final的方法、final的类
 */

public class AbstractTest {
    public static void main(String[] args) {
        Person p1 = new Student();
        p1.eat();
    }
}

abstract  class Person {
    String name;
    int age;
    public Person() {

    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // 抽象方法
    abstract public void eat();

    public void walk() {
        System.out.println("I am walking.");
    }
}

class Student extends Person {
    Student() {

    }
    Student(String name, int age) {
        super(name,age);
    }
    @Override
    public void eat() {
        System.out.println("Students are eating.");
    }
}

