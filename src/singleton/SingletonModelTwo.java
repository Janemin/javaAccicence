package singleton;

/**
 * @author janemin
 * @create 18-8-25
 */
public class SingletonModelTwo {
    private SingletonModelTwo() {}

    private static SingletonModelTwo instance;

    public static SingletonModelTwo getInstance() {
        // thread unsafe
        if (instance == null) {
            instance = new SingletonModelTwo();
        }
        return instance;
    }
}
