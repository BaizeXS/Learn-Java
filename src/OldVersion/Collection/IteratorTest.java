package Learn.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * 集合元素的遍历：使用迭代器 Iterator 接口
 * 1. 内部方法： hasNext() 和 next() 。
 * 2. next()方法美调用一次指针均下移一次。
 * 3. 集合每次调用 iterator() 方法都会得到一个全新的迭代器对象，
 *    默认游标均在集合的第一个元素之前。
 * 4. remove() 方法，可以在遍历的时候，删除集合中的元素。
 *    此方法不同于集合直接调用 remove() 方法。
 */
public class IteratorTest {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(new String("Jerry"));
        coll.add(false);
        // 遍历输出元素
        System.out.println("----------------------------------------");
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // remove() 方法调用：删除集合中 "Tom" 这个数据
        iterator = coll.iterator();
        while(iterator.hasNext()) {
            Object obj = iterator.next();
            if ("Tom".equals(obj)) {
                iterator.remove();
            }
        }
        // 移除后遍历集合
        System.out.println("----------------------------------------");
        iterator = coll.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 增强 for 循环
        System.out.println("Foreach循环，内部仍然为迭代器");
        for (Object obj : coll) {
            System.out.println(obj);
        }
        System.out.println("遍历数组");
        int[] arr = new int[] {1,2,3,4,5,6,7};
        for (int i:arr) {
            System.out.println(i);
        }
    }
}
