package invocation;

/**
 * @author JaneMin
 * @create 2018/10/10
 */
public class TestConstructor {

    public static void main(String[] args) throws Exception {
        test1();
    }


    // use newInstance() to get an instance object from class
    public static void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName("invocation.Person");

        // use no-parameter constructor, so this class must have no-parameter constructor and this constructor is accessible
        // if the no-parameter constructor is not exists, newInstance() will throw InstantiationException.
        // if this constructor is inaccessible , newInstance() will throw IllegalAccessException.
        Object obj = clazz.newInstance();

        Person person = (Person)obj;
        System.out.println(person);
    }

    public static void test2() {

    }
    
}
