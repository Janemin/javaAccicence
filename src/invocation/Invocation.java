package invocation;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author JaneMin
 * @create 2018/10/10
 */
public class Invocation {

    public static void main (String[] args) throws Exception {
        test3();
    }

    public static void test1() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<Person> clazz = Person.class;

        // get instance by class
        Person person = clazz.newInstance();

        // accessible filed
        Field f1 = clazz.getField("name");
        f1.set(person, "JaneMin");

        // inaccessible filed
        Field f2 = clazz.getDeclaredField("age");
        f2.setAccessible(true);
        f2.set(person, 10);

        System.out.println(person);

        // no parameter method
        Method m1 = clazz.getMethod("show");
        m1.invoke(person);

        // has parameter method
        Method m2 = clazz.getMethod("nation",  String.class);
        m2.invoke(person, "CN");
    }

    // how to get the instance of Class
    public static void test2() throws ClassNotFoundException {
        // 1. from an instance object of runtime class
        Person person = new Person();
        Class<? extends Person> clazz = person.getClass();

        // 2. from runtime class it self
        Class<Person> clazz2 = Person.class;

        // 3. from Class's static method
        Class<?> clazz3 = Class.forName("invocation.Person");

        // 4. from classloader
        ClassLoader classLoader = Invocation.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("invocation.Person");
    }

    // ClassLoader
    public static void test3() {

        // 1. System ClassLoader 系统类加载器，负责java --classpath 或 -D java.class.path所指定目录下的类与jar
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(systemClassLoader);

        // 2. Extension ClassLoader 扩展类加载器，负责/jre/lib/ext 目录下或者 -D java.ext.dirs 指定目录下jar
        ClassLoader extensionClassLoader = systemClassLoader.getParent();
        // sun.misc.Launcher$ExtClassLoader@4554617c
        System.out.println(extensionClassLoader);

        // 3. Bootstrap ClassLoader 引导类加载器(无法获取)，负责java平台核心库
        ClassLoader ClassLoader = extensionClassLoader.getParent();
        // null
        System.out.println(ClassLoader);

        // 1 ==> 3 检查类是否已转载， 3 ==> 1 尝试加载类

        // demo of System ClassLoader
        ClassLoader loader = Person.class.getClassLoader();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(loader);

        // demo of Bootstrap ClassLoader
        ClassLoader loader2 = Object.class.getClassLoader();
        // null
        System.out.println(loader2);

        // useful method
        ClassLoader classLoader = Invocation.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("invocation\\config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String user = properties.getProperty("user");
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
