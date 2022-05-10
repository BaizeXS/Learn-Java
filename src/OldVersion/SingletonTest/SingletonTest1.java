package Learn.SingletonTest;
/*
 * 单例设计模式
 * 1. 所谓类的单例模式，就是采取一定方法保证在整个软件系统中，某个类只能有一个对象实例
 * 2. 如何实现？
 *      - 饿汉式
 *      - 懒汉式
 * 3. 区分饿汉式和懒汉式
 *      - 饿汉式：
 *              好处：饿汉式是线程安全的
 *              坏处：对象加载时间过长
 *      - 懒汉式：
 *              好处：延迟对象的创建
 *              坏处：目前线程不安全，多线程时再修改
 * 4. 单例模式的应用
 *  - 网站计数器
 *  - 应用程序的日志应用
 *  - 数据库的连接池的设计
 *  - 项目中，读取配置文件的类
 *  - Application
 *  - Windows的Task Manager
 *  - Windows的Recycle Bin
 */

public class SingletonTest1 {
    public static void main(String[] args) {
        Bank b1 = Bank.getInstance();
        Bank b2 = Bank.getInstance();
        System.out.println(b1 == b2);
    }
}

// 饿汉式
class Bank {
    // 1. 私有化构造器
    private Bank(){}
    // 2. 内部创建类的对象
    // 4. 要求对象也为静态的
    private static Bank instance = new Bank();
    // 3. 提供公共静态方法返回类的对象
    public static Bank getInstance() {
        return instance;
    }
}