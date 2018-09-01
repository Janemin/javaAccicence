package exception;

/**
 * @author JaneMin
 * @create 2018/9/1
 */
public class ExceptionChain {
    public static void main(String[] args) {
        try {
            testThree();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testOne() throws CustomizedException {
        throw new CustomizedException();
    }

    public static void testTwo() throws Exception {
        try {
            testOne();
        } catch (CustomizedException e) {
            Exception exception = new Exception("new Exception");
            exception.initCause(e);
            throw exception;
            // throw new Exception("The exception from testTwo()", e);
        }
    }

    public static void testThree() throws Exception {
        try {
            testTwo();
        } catch (Exception e) {
            throw new Exception("The exception from testThree()", e);
        }
    }
}
