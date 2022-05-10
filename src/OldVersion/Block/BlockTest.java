package Learn.Block;
/*
 * 代码块(或初始化块)
 *
 * 1. 代码块的作用：用来初始化类、对象
 * 2. 若要修饰，只能用static修饰
 * 3. 分类：静态代码块和非静态代码块
 * 4. 静态代码块
 *      - 内部可以有输出语句
 *      - 随着类的加载而执行
 *      - 只在加载类的时候执行一次
 *      - 作用：初始化类的属性
 *      - 如果类中有多个静态代码块，在按照声明的先后顺序执行
 *      - 静态代码块的执行要优于非静态代码块的执行
 *      - 静态代码块内只能调用静态的属性、方法，不能使用非静态的属性、方法
 * 5. 非静态代码块
 *      - 内部可以有输出语句
 *      - 随着对象的创建而执行
 *      - 每创建一次就执行一次
 *      - 作用：可以在创建对象时，对对象的属性等进行初始化
 *      - 如果类中有多个非静态代码块，在按照声明的先后顺序执行
 * 6. 对属性可以初始化的位置：
 *      - 默认初始化
 *      - 显示初始化
 *      - 构造器中初始化
 *      - 有了对象后，可以通过"对象.属性"或"对象.方法"的方式，进行赋值
 *      - 在代码块中赋值
 */
public class BlockTest {
    public static void main(String[] args) {
        String desc = Person.desc;
        Person p1 = new Person();
    }
}

class Person {
    // Attributes
    String name;
    int age;
    static String desc =  "I am an individual person.";
    // Construction
    public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // 静态代码块
    static {
        System.out.println("Hello, static block.");
        desc = "I am good.";
    }
    // 非静态代码块
    {
        System.out.println("Hello, non-static block.");
    }
    // Methods
    public void eat() {
        System.out.println("I am eating.");
    }
    @Override
    public String toString() {
        return "Person [ name = " + name +", age = " + age + "]";
    }
}