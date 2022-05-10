package Learn.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/*
 * 1. List接口
 *  /---- Collection 接口：单列集合，用于存储一个一个的对象
 *      /---- List 接口：有序，可重复    ——>"动态"数组
 *           /---- ArrayList：作为 List 接口的主要实现类，线程不安全的，效率高，底层为Object[]
 *           /---- LinkedList：底层为双向链表，对于频繁的插入删除操作，使用此类效率比ArrayList高️
 *           /---- Vector：作为List接口的古老实现类，线程安全的，效率低,底层为Object[]
 * 面试题：ArrayList、LinkedList、Vector 三者的异同？
 * 同：
 *    三者均实现了 List 接口，
 *    存储数据特点相同：存储有序可重复元素
 *
 * 2. ArrayList 源码分析： JDK7 和 JDK8 略有不同
 * 2.1 JDK 7:
 *      ArrayList list = new ArrayList(); // 底层创建了长度是10的Object[]数组elementData
 *      list.add(123);   // elementData[0] = new Integer(123);
 *      ...
 *      list.add(11);    // 如果此次的添加导致底层elementData数组容量不够，则扩容，
 *      默认情况下，扩容为原来容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中
 *
 *      结论：开发中建议使用带参数的构造器：ArrayList list = new ArrayList(int capacity)
 * 2.2 JDK8
 *      ArrayList list = new ArrayList(); // 底层Object[] elementData初始化为{},并没有创建长度为10的数组
 *      list.add(123);  // 第一次调用add()时，底层才创建了长度为10的数组，并将数据123添加到数组中
 *      添加和扩容操作与JDK7无异
 * 3. LinkedList 源码分析
 *      LinkedList list = new ListTest(); // 内部声明了Node类型的first和last属性，默认值为null
 *      list.add(123); // 将 123 封装到 Node 中，创建了Node对象。其中Node为双向链表。
 * 4. List 接口中的常用方法
 *      - void add(int index, object ele); 在 index 处插入元素 ele
 *      - boolean addAll(int index, Collection eles); 从 index 处开始将 eles 中的所有元素添加进来
 *      - Object get(int index); 获取指定 index 位置上的元素
 *      - int indexOf(Object ele); 返回 ele 在集合中首次出现的位置
 *      - int lastIndexOf(Object ele); 返回 ele 在集合中末次出现的位置
 *      - Object remove(int index); 移除指定 index 位置上的元素，并返回该元素
 *      - Object set(int index, Object ele);  设置指定 index 位置上的元素为 ele
 *      - List subList(int fromIndex, int toIndex); 返回从 fromIndex 到 toIndex 位置的子集合
 * 5. 常用方法
 * 增：add(int index);
 * 删：remove(int index); / remove(Object obj)
 * 改：set(int index, Object obj);
 * 查：get(int index);
 * 插：add(int index, Object obj);
 * 长度：size();
 * 遍历：
 *  - Iterator
 *  - 增强 for 循环
 *  - 普通 for 循环
 *
 */
public class ListTest {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ArrayList<Integer> list = new ArrayList<>();
        // 1. void add(int index, object ele); 在 index 处插入元素 ele
        System.out.println("----------add 方法----------");
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        // 2. boolean addAll(int index, Collection eles); 从 index 处开始将 eles 中的所有元素添加进来
        System.out.println("----------addAll 方法----------");
        list.addAll(3,Arrays.asList(5,6,7,8,9));
        list.add(5);
        System.out.println(list);
        // 3. Object get(int index); 获取指定 index 位置上的元素
        System.out.println("----------get 方法----------");
        System.out.println(list.get(4));
        // 4. int indexOf(Object ele); 返回 ele 在集合中首次出现的位置
        System.out.println("----------indexOf 方法----------");
        System.out.println(list.indexOf(5));
        // 5. int lastIndexOf(Object ele); 返回 ele 在集合中末次出现的位置
        System.out.println("----------lastIndexOf 方法----------");
        System.out.println(list.lastIndexOf(5));
        // 6. Object remove(int index); 移除指定 index 位置上的元素，并返回该元素
        System.out.println("----------remove 方法----------");
        System.out.println(list.remove(6));
        System.out.println(list);
        // 7. Object set(int index, Object ele);  设置指定 index 位置上的元素为 ele
        System.out.println("----------set 方法----------");
        list.set(5, 5);
        System.out.println(list);
        // 8. List subList(int fromIndex, int toIndex); 返回从 fromIndex 到 toIndex 位置的子集合
        System.out.println("----------subList 方法----------");
        System.out.println(list.subList(3,6));
    }
}
