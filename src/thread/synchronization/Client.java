package thread.synchronization;

/**
 * @author JaneMin
 * @create 2018/9/24
 */
public class Client {
    /*
    * wait()
    * notify()
    * notifyAll()
    * */
    public static void main(String[] args) {
        Queue queue = new Queue();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
