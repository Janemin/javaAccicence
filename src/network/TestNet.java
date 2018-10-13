package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author JaneMin
 * @create 2018/10/13
 */
public class TestNet {

    public static void main (String[] args) throws Exception {
        test1();
    }

    public static void test1() throws UnknownHostException {
        InetAddress bilibili = InetAddress.getByName("www.bilibili.com");

        // www.bilibili.com
        System.out.println(bilibili.getHostName());

        // 218.98.33.197
        System.out.println(bilibili.getHostAddress());

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
    }
}
