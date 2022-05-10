package Learn.InterfaceTest;
/*
 * 接口的应用——代理模式：
 */
public class NetWorkTest {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.Browse();
    }
}

interface NetWork {
    public void Browse();
}
// 被代理类
class Server implements NetWork {
    @Override
    public void Browse() {
        System.out.println("真实的服务器访问网络");
    }
}

class ProxyServer implements NetWork {
    private NetWork work;

    public ProxyServer(NetWork work) {
        this.work = work;
    }

    public void Check() {
        System.out.println("联网前的检察工作");
    }

    @Override
    public void Browse() {
        Check();
        work.Browse();
    }
}