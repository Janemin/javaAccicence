package IOstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author JaneMin
 * @create 2018/9/24
 */
public class StreamDemo {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\admin\\Desktop";
        File file = new File(path, "备忘录.txt ");

        if (!file.exists()) {
            return;
        }
        FileInputStream inputStream = new FileInputStream(file);

        // readFile(inputStream);

        // readFileByByteArray(inputStream);

        inputStream.close();

        String filePath = "C:\\Users\\admin\\Desktop";
        File target = new File(path, "target.txt ");
        if (!target.exists()) {
            target.createNewFile();
        }
        FileOutputStream outputStream = new FileOutputStream(target);

        // writeToFile(outputStream, "hello world");

        outputStream.close();


    }

    public static void readFile(FileInputStream inputStream) throws IOException {
        int n = 0;
        while ((n = inputStream.read()) != -1) {
            System.out.print((char) n);
        }
    }

    public static void readFileByByteArray(FileInputStream inputStream) throws IOException {
        byte[] arr = new byte[100];
        while (inputStream.read(arr) != -1) {
            System.out.print(new String(arr));
            arr = new byte[100];
        }
    }

    public static void writeToFile(FileOutputStream outputStream, String content) throws IOException {
        char[] chars = content.toCharArray();
        for (char c : chars) {
            outputStream.write((int)c);
        }
    }

    public static void copyFile(FileInputStream inputStream, FileOutputStream outputStream) throws IOException {
        int n = 0;
        byte[] bytes = new byte[1024];
        while ((n = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, n);
        }
    }

}
