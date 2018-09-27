package thread.synchronization;

import static java.lang.Thread.sleep;

/**
 * @author JaneMin
 * @create 2018/9/24
 */
public class Producer implements Runnable {
    Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int i = 0;
        while(true) {
            queue.setN(i++);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
