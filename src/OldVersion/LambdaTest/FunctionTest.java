package OldVersion.LambdaTest;
/* *
 * Java 内置的4大核心函数式接口
 * - 消费性接口 Consumer<T>      void accept(T t);
 * - 供给型接口 Supplier<T>      T get();
 * - 函数型接口 Function<T, R>   R apply(T t);
 * - 断定型接口 Predicate<T>     boolean test(T t);
 *
 * 方法引用——当传递给 lambda 体的操作，已经有实现的方法了，可以使用方法引用。
 * - 对象::实例方法名
 * - 类::静态方法名
 * - 类::实例方法名 s1.compareTo(s2) -> String :: compareTo;
 * 要求：接口中抽象方法的形参列表与返回值与方法引用的形参列表与返回值相同
 * 引用构造器： 类::new;
 * */
public class FunctionTest {
}
