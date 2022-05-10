package Learn.StaticTest;
/*
 * static 关键字的使用
 * 1. static：静态的
 * 2. static可以修饰：属性、方法、代码块、内部类
 * 3. static修饰属性：静态变量（类变量）
 *      3.1 属性按照是否使用static修饰分为静态属性和实例属性，
 *          实例变量：
 *                  通过类创建的每一个对象都独立拥有一套类的非静态变量。
 *                  修改一个对象的属性不改变其他对象的属性。
 *          静态变量：
 *                  我们创建了类的多个对象，多个对象共享统一个静态变量。
 *                  通过一个对象修改静态变量，其他对象再次调用该静态变量时，则已被修改。
 *          其中静态变量是多个对象共享统一个变量。
 *      3.2 static修饰属性的其他说明
 *          - 静态变量随着类的加载而加载
 *          - 静态变量的加载早于对象的创建
 *          - 由于类只会加载一次，则静态变量在内存中也只会存在一份，存在于方法区的静态域中
 * 4. static修饰方法
 *      - 随着类的加载而加载，可以通过 "类.静态方法()" 的方式调用
 *      - 静态方法中只能调用静态方法或静态属性！！！
 *      - 非静态方法中可以调用静态方法或使用静态变量
 *
 * 5. static注意点
 *      - static内部不能使用this或者super！！！
 * 6. 开发中如何确定一个属性是否需要声明为static？
 *      - 属性可以被对个对象共用的，不会随对象变化而变化
 *      - 类中的常量也会用static修饰
 * 7. 开发中如何确定一个方法是否需要声明为static？
 *      - 操作静态属性的方法，通常设置为static
 *      - 工具类的方法，习惯上声明为static，例如Math、Arrays、Collections
 */
public class StaticTest {
    public static void main(String[] args) {

        Chinese.nation = "CN";

        Chinese c1 = new Chinese();
        c1.name = "Xiao Ming";
        c1.age = 40;
        c1.eat();

        Chinese c2 = new Chinese();
        c2.name = "Xiao Hong";
        c2.age = 30;
        c2.eat();

        Chinese.show();

    }
}

// 中国人
class Chinese {
    String name;
    int age;
    static String nation;
    public void eat() {
        System.out.println("I am eating.");
    }
    public static void show() {
        System.out.println("I am showing.");
    }
}