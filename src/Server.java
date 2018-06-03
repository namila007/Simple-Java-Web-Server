import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
    private ExecutorService executor;


    public Server (int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server Started on port "+ port);
        executor = Executors.newCachedThreadPool();

        while(true){

            executor.execute(new Worker(server.accept()));
        }

    }





}
