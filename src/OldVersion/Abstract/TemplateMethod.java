package Learn.Abstract;

public class TemplateMethod {
    /*
     * 模版方法设计模式
     */
    public static void main(String[] args) {
        Template t = new subTemplate();
        t.spendTime();
    }
}

abstract class Template{
    public abstract void code();
    public void spendTime() {
        // 计算某代码的时间
        long start = System.currentTimeMillis();
        code();     // 易变的过程
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为："+(end-start));
    }
}

class subTemplate extends Template {

    @Override
    public void code() {
        for (int i = 2; i <= 1000; i++) {
            boolean isFlag = true;
            for(int j = 2; j <= Math.sqrt(i);) {
                if (i % j == 0) {
                    isFlag = false;
                    break;
                }
            }
            if (isFlag) {
                System.out.println(i);
            }
        }
    }
}