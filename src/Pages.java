import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Pages {

    public static void sendIndexPage(DataOutputStream out) throws IOException {
        Path path = Paths.get("Resources/Index.html");
        //BufferedReader br = new BufferedReader(path);
        byte[] data= Files.readAllBytes(path);

        out.writeBytes("HTTP/1.1 200 OK\r\n");
        out.writeBytes("Content-Type: text/html; charset=utf-8\r\n");
        out.writeBytes("\r\n");
        out.write(data);
        out.flush();

    }

    public static void sendBootstrap(DataOutputStream out) throws IOException {
        Path path = Paths.get("Resources/bootstrap.css");
        //BufferedReader br = new BufferedReader(path);
        byte[] data= Files.readAllBytes(path);

        out.writeBytes("HTTP/1.1 200 OK\r\n");
        out.writeBytes("Content-Type: text/css; charset=utf-8\r\n");
        out.writeBytes("\r\n");
        out.write(data);
        out.flush();

    }

}