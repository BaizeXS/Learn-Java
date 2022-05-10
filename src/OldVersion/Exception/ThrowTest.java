package Learn.Exception;

import javax.swing.plaf.synth.SynthDesktopIconUI;

public class ThrowTest {
    public static void main(String[] args) {
        Student s = new Student();
        try {
            s.register(-1001);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
class Student {
    private int id;
    public void register(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
            throw new Exception("您输入的数据非法！");
        }
    }

    @Override
    public String toString() {
        return "Student [id=" + id + "]";
    }
}
