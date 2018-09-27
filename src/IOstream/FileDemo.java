package IOstream;

import java.io.File;
import java.io.IOException;

/**
 * @author JaneMin
 * @create 2018/9/24
 */
public class FileDemo {
    public static void main(String[] args) {
        String path = "C:\\Users\\admin\\Desktop\\score.txt";
        File file = new File(path);

        // File file = new File("C:\\Users\\admin\\Desktop","score.txt");

        // File parentFile = new File("C:\\\\Users\\\\admin\\\\Desktop");
        // File childFile = new File(parentFile, "score.txt");

        if (file.isDirectory())
            System.out.println("This file is a directory");
        if (file.isFile())
            System.out.println("This file is a file");

        File fileTarget = new File("C:\\Users\\admin\\Desktop", "target");
        if (!fileTarget.exists()) {
            fileTarget.mkdir();
        }

        File fileTarget1 = new File("C:\\Users\\admin\\Desktop\\target1\\target1");
        if (!fileTarget1.exists()) {
            fileTarget1.mkdirs();
        }

        File simpleTxt = new File("C:\\Users\\admin\\Desktop", "simple.txt");
        if (!simpleTxt.exists()) {
            try {
                simpleTxt.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
