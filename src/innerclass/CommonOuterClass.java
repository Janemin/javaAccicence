package innerclass;

/**
 * @author janemin
 * @create 18-8-26
 */
public class CommonOuterClass {
    private int var;

    private String className = "CommonOuterClass";

    private String method() {
        return "CommonOuterClass";
    }

    private String outerClassMethod() {
        return "outerClassMethod";
    }

    public CommonInnerClass getCommonInnerClass() {
        return new CommonInnerClass();
    }

    public class CommonInnerClass {
        private int var;

        private String method() {
            return "CommonInnerClass";
        }

        public void innerClassMethod() {
            // outer class var
            System.out.println(className);
            // outer class method
            System.out.println(outerClassMethod());
            // inner class var
            System.out.println(var);
            // outer class var
            System.out.println(CommonOuterClass.this.var);
            // inner class method
            System.out.println(method());
            // outer class method
            System.out.println(CommonOuterClass.this.method());
        }
    }

    public static void main(String[] args) {
        CommonOuterClass outerClass = new CommonOuterClass();
        // get inner class instance
        CommonInnerClass innerClass1 = outerClass.new CommonInnerClass();
        // get inner class instance
        CommonInnerClass innerClass2 = new CommonOuterClass().new CommonInnerClass();
        // get inner class instance
        CommonInnerClass innerClass3 = outerClass.getCommonInnerClass();

        innerClass1.innerClassMethod();
    }
}
