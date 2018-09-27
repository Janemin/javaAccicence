package thread;



/**
 * @author JaneMin
 * @create 2018/9/23
 */
class ThreadA extends Thread {
    private String name;
    public ThreadA(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread " + getName() + " is running " + i + " time");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadPriority {
    /*
    * Thread Priority
    *   * Priority has 10 level , use 1 - 10 indicate (level 1 < level 10), out of range will throw IllegalArgumentException
    *   * Main Thread default priority is 5
    * */
    public static void main(String[] args) {
        int mainPriority = Thread.currentThread().getPriority();
        System.out.println(mainPriority);
        ThreadA one = new ThreadA("one");
        one.setPriority(Thread.MAX_PRIORITY);

        ThreadA two = new ThreadA("two");
        two.setPriority(Thread.MIN_PRIORITY);
        one.start();
        two.start();
    }
}
