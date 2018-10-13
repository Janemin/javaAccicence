package invocation;

/**
 * @author JaneMin
 * @create 2018/10/10
 */
public class Person {
    public String name;
    private int age;

    public Person() {
        super();
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show() {
        System.out.println("i am a person named " + name);
    }

    public void nation(String str) {
        System.out.println("my nation is " + str);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
