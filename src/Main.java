import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) {
       // ExecutorService executorService = new ThreadPoolExecutor();
        try{
            Server sv = new Server(3000);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
