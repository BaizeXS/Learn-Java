package Learn.Collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

/*
 * Map 接口：双列数据，存储 key-value 对的数据
 * 一、Map 接口继承树
 * |----Map
 *      |---- Hashtable：古老的实现类；线程安全；效率低；不可以存储 null 的 key 和 value；
 *          |---- Properties：常用来处理配置文件。key-value均为String类型。
 *      |---- HashMap：主要实现类；线程不安全；效率高；可以存储 null 的 key 和 value；
 *          |---- LinkedHashMap：对于频繁的遍历操作，此类效率高
 *      |---- SortedMap
 *          |---- TreeMap：保证按照添加key-value对进行排序，实现排序遍历。此时考虑key的自然排序或定制排序。
 * 二、HashMap 底层
 *  1. JDK7：数组+链表
 *  2. JDK8：数组+链表+红黑树
 * 三、HashMap 底层实现原理
 *  1. JDK7：
 *      HashMap map = new HashMap();
 *      - 实例化后，底层创建了一个长度为16的Entry[] table
 *      map.put(key1,value1);
 *      - 调用key1所在类的hashCode()方法，计算key1的哈希值
 *      - 将某种算法应用于key1的哈希值，从而得到元素在Entry数组的存储位置
 *      - 若此位置为空，则将key1-value1添加到该位置
 *          - 若此位置不为空，比较key1-value1和已经存在的数据的哈希值
 *          - 若哈希值都不等，则直接添加
 *              - 若哈希值相同，则调用key1类的equals()方法，看二者是否相同
 *                  - equals() 返回 false，添加该元素
 *                  - equals() 返回 true， 更新该key1对应的value值
 *      默认扩容方式：扩容为原来的2倍
 *  2. JDK8:
 *      - 实例化后，底层没有创建了一个长度为16的Node数组
 *      - 底层数组为Node[]，而不是Entry[]数组
 *      - 首次调用put()方法时，创建长度为16的Node数组
 *      - 底层结构为：数组+链表+红黑树
 *          当 链表上元素个数 > 8 且 当前数组长度 > 64时，该链表改为红黑树存储。
 * 四、HashMap 源码分析
 * 五、Map常用方法
 *  1. 添加、删除、修改
 *  Object put(Object key, Object value);
 *  void putAll(Map m);
 *  Object remove(Object key);
 *  void clear();
 *  2. 元素查询
 *  Object get(Object key);
 *  boolean containsKey(Object key);
 *  boolean containsValue(Object value);
 *  int size();
 *  boolean isEmpty();
 *  boolean equals(Object obj);
 * 3. 遍历
 *  Set keySet();
 *  Collection values();
 *  Set entrySet();————————>getKey(); && getValue();
 *
 * 面试题：
 * 1. HashMap 的底层实现原理？
 * 2. HashMap 和 Hashtable 的区别？
 * 3. CurrentHashMap 和 Hashtable 的区别？（暂时不讲）
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap map = new HashMap();

    }
}
