import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File(
                "data.txt");

        try (FileInputStream fis = new FileInputStream(file); FileOutputStream fos =
                new FileOutputStream("new_data.txt")) {
            int length = fis.available();
            byte[] buffer = new byte[length];
            fis.read(buffer);

            char[] charBuffer = new char[length];
            for (int i = 0; i < length; i++) {
                charBuffer[i] = (char) buffer[i];
            }

            Text text = new Text(String.valueOf(charBuffer));
            text.setBigWords();

            byte[] new_buffer = (text.toString() + "\n" + String.join(", ", text.bigWords)).
                    getBytes(StandardCharsets.UTF_8);
            fos.write(new_buffer);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}