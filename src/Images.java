import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Images {

    public static void sendImage(DataOutputStream out ) throws IOException {
        Path path = Paths.get("Resources/design.jpg");
        byte[] data = Files.readAllBytes(path);

        out.writeBytes("HTTP/1.1 200 OK\r\n");
        out.writeBytes("Content-Type: image/jpg\r\n");
        out.writeBytes("Content-length: "+data.length+"\r\n");
        out.writeBytes("Connection: close\r\n");
        out.writeBytes("\r\n");
        out.write(data);
        out.flush();

    }

    public static void sendFavicon(DataOutputStream out ) throws IOException {
        Path path = Paths.get("Resources/test.png");
        byte[] data = Files.readAllBytes(path);

        out.writeBytes("HTTP/1.1 200 OK\r\n");
        out.writeBytes("Content-Type: image/png\r\n");
        out.writeBytes("Content-length: "+data.length+"\r\n");
        out.writeBytes("Connection: close\r\n");
        out.writeBytes("\r\n");
        out.write(data);
        out.flush();

    }


}
