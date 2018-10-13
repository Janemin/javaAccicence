package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author JaneMin
 * @create 2018/10/13
 */

class Send extends Thread{
    @Override
    public void run() {
        try {
            send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send() throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket();

        byte[] bytes = "this is send data".getBytes();
        // 数据报，每一个数据报不能 > 64k ,数据报中要记录一些基本信息
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length,
                InetAddress.getByName("127.0.0.1"), 9090);

        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}

class Receiver extends Thread{
    @Override
    public void run() {
        try {
            receive();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void receive() throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(9090);

        byte[] bytes = new byte[1024];
        // 数据报，每一个数据报不能 > 64k ,数据报中要记录一些基本信息
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);

        datagramSocket.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));

        datagramSocket.close();
    }
}
public class TestUDP {
    public static void main(String[] args) {
        new Send().start();
        new Receiver().start();
    }
}
