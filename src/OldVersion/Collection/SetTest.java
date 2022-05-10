package Learn.Collection;

/*
 * 1. Set 接口的框架结构
 *  /---- Collection 接口：单列集合，用于存储一个一个的对象
 *      /---- Set 接口：无序，不可重复    ——>高中讲的"集合"：无序、确定、互异
 *          /---- HashSet：Set 接口的主要实现类；是线程不安全的；可以存储 null 值；
 *              /---- LinkedHashSet：作为 HashSet 子类；遍历其内部元素时，可以按照添加的顺序进行遍历；
 *          /---- TreeSet：底层为红黑树；可以按照添加对象的指定属性，进行排序
 * 2. Set 中没有定义额外的新的方法，使用的均为 Collection 中声明过的方法
 * 3. Set 的无序性和不可重复性（HashSet）
 *  - 无序性：不等于随机性；存储数据时，元素添加顺序不是按照数组的索引顺序而添加的，而是根据数据的哈希值添加
 *  - 不可重复性：保证添加元素按照 equals() 方法判断时，不能返回 true，即添加的元素不能重复
 * 4. 添加数据的过程（HashSet为例）
 *    1) 计算元素哈希值，得到存储数组的位置索引
 *    2) 若空则添加，否则比较哈希值
 *    3) 若哈希值不同则添加，否则调用 equals() 方法
 *    4) 若不同则添加，否则添加失败
 *    连接方式：数组+链⌚表
 *    JDK7 与 JDK8：七上八下
 * 5. 要求 Set 中添加的元素必须重写 equals() 方法和 hashCode() 方法
 *    要求重写的 equals() 方法和 hashCode() 方法必须保持一致性：相等的对象必须要有相等的散列码
 * 6. LinkedHashSet:
 *      对于频繁的遍历操作，LinkedHashSet效率优于HashSet——>数组中带双向链表，来确定顺序
 * 7. 向TreeSet添加的元素，必须是同一个类的
 *      TreeSet 排序用的 compareTo()
 *
 */

import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
        //
        TreeSet set = new TreeSet();
        set.add(123);
        set.add(128);
        set.add(125);
        set.add(-123);
        set.add(13);
        set.add(23);
        Iterator iterator = set.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
    }
}
