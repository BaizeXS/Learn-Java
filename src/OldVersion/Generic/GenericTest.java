package Learn.Generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 泛型的使用
 * 1. JDK 5.0 新增的特性
 * 2. 在集合中使用泛型
 *  - 集合接口或集合类在JDK5.0时均修改为带泛型的结构
 *  - 在实例化集合类时，可以指明具体的泛型类型
 *  - 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构使用到类的泛型位置，都指定为实例化的泛型类型。
 *    例如：add(E e) ——>实例化后： add(Integer e)
 *  - 泛型不能是基本数据类型，必须为类或者包装类
 *  - 若实例化时，未指定泛型的类型，则默认为 java.lang.Object
 * 3. 自定义泛型结构：泛型类、泛型接口、泛型方法
 *  - 泛型类：见 Order，若定义了泛型类，但是实例化没有指明泛型类，则认为此泛型类为Object类型
 *  - 定义构造器时，不需要添加 <>
 *  - 泛型不同的引用不能相互赋值
 *    例如 List<String> 和 List<Integer> 不能使用同一个引用
 *
 *  - ！！！ 静态方法中不能使用泛型
 *  - ！！！ 异常类不能为泛型类
 *  - 泛型数组
 *      T[] t = new T[10];  // 编译不通过
 *      T[] t = (T[])new Object[10];    // 编译通过
 *  - 泛型方法：
 *  泛型的嵌套
 * 4. 泛型与继承
 * 5. 通配符的使用：?
 *      G<A> 和 G<B> 的公共父类为 G<?>
 *      有限制条件的通配符
 *          G<? extends A> 小于等于， 上界为 A
 *          G<? super B>   大于等于， 下界为 B
 *
 *
 */
public class GenericTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(99);
        list.add(79);
        list.add(9);
        list.add(91);
        list.add(88);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
//        list2 = list1;
        // list1 和 list2 是同级别的，并非子父类
        List<Object> list01 = new ArrayList<>();
        List<String> list02 = new ArrayList<>();

        List<?> list00 = null;
        list00 = list01;
        list00 = list02;
        // 添加：对于 List<?> 就不能添加数据了，若添加，只能添加为 null
//        list.add("AA");
        list.add(null);
        // 获取
        list.get(0);
    }
}
