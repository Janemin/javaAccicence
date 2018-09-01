package exception;

import java.util.Scanner;

/**
 * @author JaneMin
 * @create 2018/9/1
 */
public class ThrowDemo {
    public static void main(String[] args) {

        testAge();

        try {
            testAgeThrows();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testAge() {
        try {
            System.out.println("please tell me your age");
            Scanner scanner = new Scanner(System.in);
            int age = scanner.nextInt();
            if (age > 80 || age < 18) {
                throw new Exception("your are not allow to living in alone because your age");
            } else {
                System.out.println("welcome");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testAgeThrows() throws Exception{
        System.out.println("please tell me your age");
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        if (age > 80 || age < 18) {
            throw new Exception("your are not allow to living in alone because your age");
        } else {
            System.out.println("welcome");
        }
    }
}
