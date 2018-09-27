package thread;

/**
 * @author JaneMin
 * @create 2018/9/23
 */
class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " is running");
        }
    }
}

public class CreateThread {
    public static void main(String[] args) {
        MyThread one = new MyThread("Thread one");
        MyThread two = new MyThread("Thread two");
        // start thread
        one.start();
        // start a thread twice ->  java.lang.IllegalThreadStateException
        // one.start();
        two.start();
    }
}
