package network;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author JaneMin
 * @create 2018/10/13
 */
public class TestURL {
    public static void main(String[] args) throws Exception {
        test2();
    }

    public static void test1() throws MalformedURLException {
        URL url = new URL("https://www.bilibili.com/video/av21413073/?p=51");

        // 协议
        System.out.println(url.getProtocol());
        // 主机名
        System.out.println(url.getHost());
        // 端口号
        System.out.println(url.getPort());
        // 文件名
        System.out.println(url.getFile());
        // 文件路径
        System.out.println(url.getPath());
        // 文件相对位置
        System.out.println(url.getRef());
        // 查询名
        System.out.println(url.getQuery());
    }

    // 读取数据 openStream()
    public static void test2() throws IOException {
        URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539434667434&di=af4d8779fdc130a7fec2c6daf37bd1db&imgtype=jpg&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D2260726702%2C2226581879%26fm%3D214%26gp%3D0.jpg");

        InputStream inputStream = url.openStream();

        byte[] bytes = new byte[100];
        int len;
        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\admin\\Desktop\\1.jpg"));
        while ((len = inputStream.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        inputStream.close();
        fos.close();
    }

    // 输出数据 openConnection()  ==> URLConnection
    public static void test3() throws IOException {
        URL url = new URL("");
        URLConnection urlConnection = url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        OutputStream outputStream = urlConnection.getOutputStream();
    }
}
