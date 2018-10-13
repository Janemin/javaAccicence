package network;

/**
 * @author JaneMin
 * @create 2018/10/13
 */

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP/IP
 * Socket 套接字   端口号和ip地址的组合得出一个网络套接字
 *
 */
class Client extends Thread {
    @Override
    public void run() {
        try {
            client();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void client() throws Exception{
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);

        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("I am client".getBytes());
        // 告知服务端 输入完毕
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();

        byte[] bytes = new byte[1024];
        int len;
        while((len = inputStream.read(bytes)) != -1) {
            String s = new String(bytes, 0, len);
            System.out.print(s);
        }
        inputStream.close();

        outputStream.close();

        socket.close();
    }
}

class Server extends Thread {
    @Override
    public void run() {
        try {
            server();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void server() throws Exception{
        ServerSocket serverSocket = new ServerSocket(9090);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        while((len = inputStream.read(bytes)) != -1) {
            String s = new String(bytes, 0, len);
            System.out.print(s);
        }
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("I has accepted your msg".getBytes());
        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}

public class TestSocket {
    public static void main(String[] args) {
        new Server().start();
        new Client().start();
    }
}
