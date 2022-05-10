package Learn.IO;
/*
 * 处理流：转换流
 * 1. InputStreamReader：字节输入流——>字符输入流
 * 2. OutputStreamWriter：字符输出流——>字节输出流
 *
 * 标准输入输出流：
 * 标准输入流：System.in：从键盘输入
 * 标准输出流：System.out：从控制台输出
 * - 可以通过 System 的 setIn(InputStream in); && setOut(PrintStream out); 重新指定输入输出的流
 *
 * 打印流：
 * PrintStream——>字节流
 * PrintWriter——>字符流
 *
 * 数据流：用于读写基本数据类型变量或字符串——>写入文件中
 * DataInputStream：读取数据的顺序要与写入时顺序一致
 * DataOutputStream：writeUTF();writeInt();writeBoolean();每次写入后执行 flush(); 方法
 *
 * 对象流：
 * ObjectInputStream
 * ObjectOutputStream
 * 序列化：用ObjectOutputStream保存基本类型数据或对象机制
 * 反序列化：用ObjectOutputStream读取基本类型数据或对象机制
 * 要求对象是可序列化的——>Serializable
 * 序列化：将内存中的Java对象通过ObjectOutputStream转化为字节流进行数据持久化
 *  */
public class InputStreamReaderTest {
}
