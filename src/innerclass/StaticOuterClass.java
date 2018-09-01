package innerclass;

/**
 * @author janemin
 * @create 18-8-26
 */
public class StaticOuterClass {
    private int var;

    private static String staticVar = "staticVar";

    private String commonVar = "commonVar";

    private String method() {
        return "CommonOuterClass";
    }

    private String outerClassMethod() {
        return "outerClassMethod";
    }

    public StaticInnerClass getCommonInnerClass() {
        return new StaticInnerClass();
    }

    public static class StaticInnerClass {
        private int var;

        private String method() {
            return "CommonInnerClass";
        }

        public void innerClassMethod() {
            // outer class static var
            System.out.println(staticVar);
            // outer class common var
            System.out.println(new StaticOuterClass().commonVar);
            // inner class var
            System.out.println(var);
            // inner class method
            System.out.println(method());
        }
    }

    public static void main(String[] args) {
        StaticOuterClass outerClass = new StaticOuterClass();
        // get inner class instance
        StaticOuterClass.StaticInnerClass innerClass = new StaticOuterClass.StaticInnerClass();

        innerClass.innerClassMethod();
    }
}
