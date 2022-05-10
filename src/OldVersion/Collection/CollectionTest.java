package Learn.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/*
 * 一、集合框架的概述
 * 1. 集合、数组都是对多个数据进行存储操作的结构，简称 Java 容器。
 * 说明：此时的存储主要指内存层面的存储，不涉及持久化储存。
 * 2.1 数组在存储多个数据方面的特点：
 *  - 数组初始化后，其长度就确定了。
 *  - 数组被定义后，其元素类型也就确定了。我们只能操作制定类型的数据了。
 *    比如：String[] strArr; int[] intArr; Object[] objArr;
 * 2.2
 *  - 数组初始化后，长度不可修改。
 *  - 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便。
 *  - 获取数组中实例元素的个数的需求，数组没有现成的属性或方法可用
 *  - 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 * 3. Java 集合可以分为 Collection 和 Map
 * 二、集合框架
 *      /---- Collection 接口：单列集合，用于存储一个一个的对象
 *          /---- List 接口：有序，可重复    ——>"动态"数组
 *              /---- ArrayList、LinkedList、Vector
 *          /---- Set 接口：无序，不可重复    ——>高中讲的"集合"：无序、确定、互异
 *              /---- HashSet、LinkedHashSet、TreeSet
 *      /---- Map 接口：双列集合，用于存储一对（Key-Value）一对的数据
 *          /---- HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 * 三、Collection 接口中的方法使用
 * 1. 向Collection接口的实现类对象中添加数据obj时，要求obj所在类要重写 equals() 方法。
 *
 */
public class CollectionTest {
    public void test1() {
        Collection coll = new ArrayList();
        // （1）add(Object e):将元素e添加到集合中
        coll.add("AA");
        coll.add("BB");
        coll.add("CC");
        coll.add(123);
        coll.add(new Date());
        coll.add(new String("Tom"));
        // （2）size()：获取集合中元素的个数
        System.out.println(coll.size());
        // （3）addAll()：将其他集合中元素全部添加到当前集合
        Collection newColl = new ArrayList();
        newColl.add(456);
        newColl.add("DD");
        coll.addAll(newColl);
        System.out.println(coll);
        // （4）isEmpty()：判断集合中是否为空
        System.out.println(coll.isEmpty());
        // （5）clear()：清空集合元素
        // coll.clear();
        System.out.println(coll);
        // （6）contains(Object o)：判断集合中是否包含 o，对于对象的判断默认调用 equals() 方法进行判断。
        System.out.println("是否包含123："+coll.contains(123));
        System.out.println("是否包含Tom："+coll.contains(new String("Tom")));
        // （7）containsAll(Collection coll1)：判断集合中是否包含 coll1 中的全部元素。
        System.out.println("是否包含newColl："+coll.containsAll(newColl));
        // （8）remove(Object obj)：移除元素 obj，该方法也会调用 obj 的 equals() 方法。
        coll.remove(123);
        // （9）removeAll(Collection coll1)：移除当前集合中的所有属于 coll1 中的元素。
        // 相当于 差集 运算
        Collection coll1 = Arrays.asList(456,45678);
        System.out.println("移除前");
        System.out.println(coll);
        coll.removeAll(coll1);
        System.out.println("移除后");
        System.out.println(coll);
        // （10）retainAll(Collection coll1)：将当前集合与 coll1 做 交集 运算
        Collection coll2 = Arrays.asList("Tom","AA","BB","Cc");
        coll.retainAll(coll2);
        System.out.println(coll);
        // （11）equals(Object obj)：判断两个集合是否相等 ——> 包含顺序！！！
        Collection coll3 = Arrays.asList("AA","BB","Tom");
        System.out.println("coll 与 coll3 是否相同："+coll.equals(coll3));
        // （12）hashCode()：返回当前对象的哈希值
        System.out.println(coll.hashCode());
        // （13）toArray()：集合转化为数组
        // 拓展：数组 ——> List：Arrays.asList();
        // 注意：List 中均为对象，不能为对象类型
        coll.toArray();
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
        // （14）iterator()：返回Iterator接口的实例，用于便利集合中的元素
    }
    public static void main(String[] args) {
        CollectionTest ct = new CollectionTest();
        ct.test1();
    }
}
