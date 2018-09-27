package thread;

/**
 * @author JaneMin
 * @create 2018/9/23
 */
class AThread extends Thread {
    public AThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " execute " + i + " time");
        }
    }
}
public class JoinThread {
    public static void main(String[] args) {
        AThread one = new AThread("one");
        one.start();
        try {
            // thread one at Dead status then execute thread two
            one.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new AThread("two").start();
    }
}
