package singleton;

/**
 * @author janemin
 * @create 18-8-25
 */

/**
 *
 */
public class SingletonModel {

    private SingletonModel() {}

    private static SingletonModel instance = new SingletonModel();

    public static SingletonModel getInstance() {
        return instance;
    }
}
