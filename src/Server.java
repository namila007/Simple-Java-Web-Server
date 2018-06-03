import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
    private ExecutorService executor;


    public Server(int port) throws IOException {
        //starting server socket
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server Started on port " + port);

        //thread pool
        executor = Executors.newCachedThreadPool();

        //when closing the server
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Closing Server");
                executor.shutdown();
            }
        });

        while (true) {
            //creating a new thread and run the server socket
            executor.execute(new Worker(server.accept()));
        }


    }


}
