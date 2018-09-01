package exception;

import java.util.Scanner;

/**
 * @author JaneMin
 * @create 18-9-1
 */
public class ExceptionDemo {
    public static void main(String[] args) {

/*        int i = 12;
        int j = 0;
        try {
            System.out.println((i / j));

        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        System.out.println("program end");*/
        int result =  test();
        System.out.println("result = " + result);
    }

    private static int test() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("calculate start");
        try {
            System.out.println("please input first number");
            int one = scanner.nextInt();
            System.out.println("please input second number");
            int two = scanner.nextInt();
            System.out.println("calculate result is " + (one / two));
            return one/two;
        } catch (ArithmeticException e) {
            System.out.println("The second number can not be zero");
            return 0;
        } finally {
            System.out.println("calculate end");
            // return -1000000;

            /* if finally block contains return ,
            this other return statement at try block or catch block will be ignored
             */
        }
    }
}
