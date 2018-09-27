package thread;

/**
 * @author JaneMin
 * @create 2018/9/23
 */
public class ThreadInfo {
    /*
     * Thread status
     *   * new  新建
     *   * runnable  可运行
     *   * running  正在运行
     *   * blocked 阻塞
     *   * dead 终止
     *
     * Thread lifecycle
     *   *  New (new Thread())  == start() ==> Runnable == (get CPU control) ==> Running
     *                                         Runnable <== (lose CPU control | yield())== Running
     *   *  Running == join() | wait() | sleep() | IO request ==> Blocked
     *   *  Blocked == 等待调用join()的线程执行完毕 | notify() | notifyAll() | sleep timeout |IO request complete ==> Runnable
     *   *  Running == 线程执行完毕 | 线程异常终止 | stop() ==> Dead
     *   *  Runnable | Blocked == stop() ==> Dead
     * */

    public static void main(String[] args) {
        Thread thread = new SimpleThread();
        thread.start();
        new SimpleThread().start();
    }
}

class SimpleThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 30; i++) {
                System.out.println(getName() + " execute " + i + " time");
                Thread.sleep(i * 20);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " Interrupted");
            e.printStackTrace();
        }
    }
}
