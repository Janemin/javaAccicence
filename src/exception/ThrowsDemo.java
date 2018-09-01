package exception;

import java.util.Scanner;

/**
 * @author JaneMin
 * @create 2018/9/1
 */
public class ThrowsDemo {
    public static void main(String[] args) {
        try {
            int result = test();
            System.out.println("result = " + result);
        } catch (ArithmeticException e) {
            System.out.println("The second number can not be zero");
            // e.printStackTrace();
        }
        System.out.println("out of try-catch block");

    }

    public static int test() throws ArithmeticException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("calculate start");
        System.out.println("please input first number");
        int one = scanner.nextInt();
        System.out.println("please input second number");
        int two = scanner.nextInt();
        System.out.println("calculate end");
        return one / two;
    }
}
