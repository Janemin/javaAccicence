package IOstream;

import java.io.*;

/**
 * @author JaneMin
 * @create 2018/9/24
 */
public class BufferedStream {
    public static void main(String[] args) throws IOException {
        BufferedInputStream inputStream = createBufferedInputStream("");
        BufferedOutputStream outputStream = createBufferedOutStream("");
        outputStream.write(20);
        outputStream.flush();
        inputStream.close();
        outputStream.close();

    }

    public static BufferedInputStream createBufferedInputStream(String fileName) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(fileName);
        return new BufferedInputStream(inputStream);
    }

    public static BufferedOutputStream createBufferedOutStream(String fileName) throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream(fileName);
        return new BufferedOutputStream(outputStream);
    }
}
