package thread.synchronization;

/**
 * @author JaneMin
 * @create 2018/9/24
 */
public class Queue {
    private int n = 0;

    private boolean flag = false;

    public synchronized int getN() {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Queue.getN <==" + n);
        flag = false;
        notifyAll();
        return n;
    }

    public synchronized void setN(int n) {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Queue.setN ==>" + n);
        this.n = n;
        flag = true;
        notifyAll();
    }
}
