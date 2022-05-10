package Test;

public class SQLxsTest {
    static String sXing =    "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许"
            + "何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章"
            + "云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳"
            + "酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常"
            + "乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹"
            + "姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞"
            + "熊纪舒屈项祝董粱杜阮蓝闵席季麻强贾路娄危"
            + "江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍"
            + "虞万支柯昝管卢莫经房裘缪干解应宗丁宣贲邓"
            + "郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁 ";

    static String[] sMing = {"小","明","丽","红","强","小丽","炎","燕",
            "晓燕","洋","阳","庄","小庄","晓阳","小洋",
            "山","进","明","小文","文","文丽","晓歌",
            "小歌","歌","晓波","小波","小亮","晓亮","亮",
            "品华","霞","红霞","晓炎","晓强","德华","华",
            "城","诚","小明"};
    static char[] lastName;
    static { lastName = sXing.toCharArray(); }

    public static void xs() {
        // 学生表添加数据语句
        System.out.println("学生表添加数据语句");
        int xh = 200000;
        for (int i = 0; i < 50; i++ ) {
            xh++;
            int index = (int) (Math.random() * (sMing.length-1)) + 1;
            String name = lastName[i] + sMing[index];
            String gender = Math.random() > 0.499 ? "M" : "F";
            // DATE
            int year = 1995 + (int) (Math.random() * 10) + 1;
            int month = (int) (Math.random() * 12) + 1;
            int day = (int) (Math.random() * 28) + 1;
            int ydh = (int) (Math.random() * 9) + 1;
            int bj = 63012000 + (int) (Math.random() * 50) + 1;
            System.out.println("INSERT INTO xs values('" + name + "','" + xh + "','" + gender + "','" + year + "-" + month + "-" + day + "','" + ydh + "','" + bj + "');");
        }
    }
    public static void js() {
        // 教师表添加数据
        System.out.println("教师表添加数据语句：");
        String[] zcb = {"教授","副教授","讲师","助教"};
        int jsbh = 100000;
        for (int i = 50; i < 70; i++ ) {
            jsbh++;
            int index = (int) (Math.random() * (sMing.length-1)) + 1;
            String name = lastName[i] + sMing[index];
            String zc = zcb[(int) (Math.random() * 3)];
            int ydh = (int) (Math.random() * 9) + 1;
            System.out.println("INSERT INTO js VALUES('" + name + "','" + jsbh + "','" + zc + "','" + ydh + "');");
        }
    }
    public static void kc() {
        String[] kcb = {"微积分","线性代数","C语言程序设计","数据结构与算法","数据库系统基础","离散数学","计算机网络","编译原理","计算机组成与原理"};
        String[] kcbh = {"A01","A02","A03","B01","B02","B03","C01","D01","D02"};
        String[] lx = {"基础课","基础课","基础课","专业课","专业课","专业课","专业课","专业课","专业课"};
        String[] xf = {"5.0","2.0","2.5","5.0","3.0","4.0","3.0","3.0","3.0"};
        // 课程表添加数据
        System.out.println("课程表添加数据语句：");
        for (int i = 0; i < 9; i++ ) {
            System.out.println("INSERT INTO kc VALUES('" + kcbh[i] + "','" + kcb[i] + "','" + lx[i] + "','" + xf[i] + "');");
        }
        // 选课表添加数据
        System.out.println("授课表添加数据语句：");
        for (int i = 100001; i < 100021; i++)
            for (int j = 0; j < 3; j++ )
                System.out.println("INSERT INTO sk VALUES ('" + kcbh[(int)(Math.random() * 8)] + "','" + i + "');");
        // 选课表添加数据
        System.out.println("选课表添加数据语句：");
        for (int i = 200001; i < 200051; i++)
            for (int j = 0; j < 3; j++ ) {
                System.out.println("INSERT INTO xk VALUES('" + i + "','" + kcbh[(int) (Math.random() * 8)] + "','" + (100000 + (int) (Math.random() * 20) + 1) + "','" + ((int) (Math.random() * 100) + 1) + ".0');");
                System.out.println("INSERT INTO xk VALUES('" + i + "','" + kcbh[(int) (Math.random() * 8)] + "','" + (100000 + (int) (Math.random() * 20) + 1) + "','" + ((int) (Math.random() * 100) + 1) + ".5');");
            }
    }

    public static void main(String[] args) {
        xs();
        js();
        kc();

    }
}