package Learn.Abstract;

import Learn.AaA.Employee;

/*
 * 抽象类的匿名子类
 *
 */
public class PersonTest {
    public static void method(Student s){

    }
    public static void method1(Person p) {
        p.eat();
        p.walk();
    }
    public static void main(String[] args) {
        method(new Student());          // 匿名对象
        Worker worker = new Worker();   // 非匿名类，非匿名方法
        method1(worker);

        method1(new Worker());          // 非匿名类，匿名对象
        Person p = new Person() {       // 匿名子类的无名对象
            @Override
            public void eat() {
                System.out.println("I am Eating.From a anno class");
            }
        };
        method1(p);

    }
}

class Worker extends Person {
    @Override
    public void eat() {
    }
}
