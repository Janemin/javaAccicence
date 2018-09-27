package string;

/**
 * @author JaneMin
 * @create 2018/9/2
 */
public class StringCommonMehtod {
    public static void main(String[] args) {
        String str = "JaneMin";
        int locationOfChar = str.indexOf('a');  // 1
        int locationOfString = str.indexOf("an"); // 1
        int stringLength = str.length(); // 7
        str.substring(2); // neMin
        str.substring(2, 5); // neM  [2,5)

        String string = "JaneMinJaneMin";
        int lastLocationOfChar = string.lastIndexOf('e');  // 10
        int lastLocationOfString = string.lastIndexOf("eM"); // 10
        string.indexOf("a", 1); // 1
        string.indexOf("a", 2); // 8
        str.indexOf("1"); // -1

        byte[] bytesArr = string.getBytes();
        String strFromBytesArr = new String(bytesArr);

    }
}
