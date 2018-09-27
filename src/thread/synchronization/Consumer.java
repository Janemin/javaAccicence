package thread.synchronization;

/**
 * @author JaneMin
 * @create 2018/9/24
 */
public class Consumer implements Runnable{
    Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            queue.getN();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
