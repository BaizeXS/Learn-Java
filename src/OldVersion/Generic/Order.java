package OldVersion.Generic;

import java.util.ArrayList;
import java.util.List;

/*
 * 自定义泛型类
 */
public class Order<T> {
    String orderName;
    int orderID;
    // 类的内部就可以使用类的泛型
    T orderT;
    public Order() {}

    public Order(String orderName, int orderID, T orderT) {
        this.orderName = orderName;
        this.orderID = orderID;
        this.orderT = orderT;
    }
    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    // 泛型方法：在方法中出现了泛型结构，泛型参数与类的泛型参数无关
    public static <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for(E e : arr) {
            list.add(e);
        }
        return list;
    }

    public static void main(String[] args) {
        Order<String> order = new Order<>();
        // 泛型方法在调用时，指名泛型参数的类型
        // 泛型方法是可以声明为静态的，泛型参数是在调用方法时确定的
        Integer[] arr = new Integer[]{1,2,3,4};
        List<Integer> list = copyFromArrayToList(arr);
        System.out.println(list);
    }
}
