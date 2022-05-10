package Learn.Comparator;

import java.util.Arrays;

/*
 *  一、 说明：Java中的对象，正常情况下只能比较： == 或者 != ，不能使用 < 或 > 。
 *           若要实现对象的比较，需要使用两个接口中的任意一个：Comparable 或 Comparator
 *  二、 Comparable 接口的使用
 *  三、 Comparator 接口的使用
 */
public class CompareTest {
    public static void main(String[] args) {
        /*
         * Comparable 接口的使用举例：      自然排序
         * 1. 像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式。
         * 2. 像String、包装类等重写compareTo(obj)后，进行了从小到大的排列
         * 3. 重写compareTo()的规则
         *    如果当前对象this大于形参对象obj，则返回正整数
         *    如果当前对象this小于形参对象obj，则返回负整数
         *    如果当前对象this等于形参对象obj，则返回零
         * 4. 对于自定义类，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo()方法，
         *    在compareTo()中指明如何排序
         */
        CompareTest test = new CompareTest();
        test.Test2();
//        String[] arr = new String[]{"AA","GG","MM","JJ","KK","CC","DD"};
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

    }
    public void Test2() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("Lenovo",34);
        arr[1] = new Goods("Dell",43);
        arr[2] = new Goods("Xiaomi",12);
        arr[3] = new Goods("Huawei",43);
        arr[4] = new Goods("Microsoft",65);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
    /*
     * Comparator 接口的使用：        定制排序
     * 1. 背景：
     *    当元素的类型没有实现Comparable接口而又不方便修改代码，
     *    或者实现了Comparable接口的排序规则不适合当前的操作时，
     *    那么可以考虑使用Comparator的对象来排序。
     * 2.重写compare(Object 01,Object o2)方法，比较o1和o2的大小，
     *   如果方法返回正整数，则 o1 > o2；
     *   如果方法返回0，则 o1 = o2；
     *   如果方法返回负整数，则 o1 < o2；
     */
}
