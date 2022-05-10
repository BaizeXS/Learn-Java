package Learn.InterfaceTest;

public class USBTest {
    public static void main(String[] args) {
        Computer com = new Computer();
        // 1. 非匿名类的非匿名对象
        Flash flash = new Flash();
        com.transferData(flash);
        // 2. 非匿名类的匿名对象
        com.transferData(new Printer());
        // 3. 匿名类的非匿名对象
        USB phone = new USB() {
            @Override
            public void start() {
                System.out.println("Phone is working.");
            }
            @Override
            public void stop() {
                System.out.println("Phone stopped working.");
            }
        };
        com.transferData(phone);
        // 4. 匿名类的匿名对象
        com.transferData(new USB(){
            @Override
            public void start() {
                System.out.println("Switch starts working.");
            }
            @Override
            public void stop() {
                System.out.println("Switch stopped working.");
            }
        });

    }
}
class Computer {
    public void transferData(USB usb) {
        usb.start();
        usb.stop();
    }
}
interface USB {
    void start();
    void stop();
}
class Flash implements USB {

    @Override
    public void start() {
        System.out.println("U盘开始工作！");
    }

    @Override
    public void stop() {
        System.out.println("U盘结束工作！");
    }
}
class Printer implements USB {

    @Override
    public void start() {
        System.out.println("打印机开始工作！");
    }

    @Override
    public void stop() {
        System.out.println("打印机结束工作！");
    }
}
