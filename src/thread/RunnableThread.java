package thread;

/**
 * @author JaneMin
 * @create 2018/9/23
 */
class PrintRunnable implements Runnable{
    // multi thread sharing
    int i = 0;
    @Override
    public void run() {
        while (i < 10)
            System.out.println(Thread.currentThread().getName() + " i = " + i++);
    }
}
public class RunnableThread {
    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        Thread one = new Thread(runnable);
        Thread two = new Thread(runnable);
        one.start();
        two.start();
    }
}
