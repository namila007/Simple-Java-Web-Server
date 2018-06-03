import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Worker implements Runnable {
    private Socket socket;

    public Worker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        DataOutputStream out;
        BufferedReader in;

        try {
            out = new DataOutputStream(socket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //crop and get the requested url
            String url = getURL(in);
            System.out.println("requesting " + url);


            System.out.println("Thread" + Thread.currentThread().getName() + " sending " + url);
            switch (url) {
                case "/":
                    Pages.sendIndexPage(out);
                    break;
                case "/getimage":
                    Images.sendImage(out);
                    break;
                case "/favicon.ico":
                    Images.sendFavicon(out);
                    break;
                case "/bootstrap.css":
                    Pages.sendBootstrap(out);
                    break;
                case "/cover.css":
                    Pages.sendCovercss(out);
                    break;
                case "/secondpage.html":
                    Pages.sendSecondPage(out);
                    break;
                default:
                    Pages.sendErrorPage(out);
                    break;
            }


            out.close();
            in.close();
            socket.close();

        } catch (Exception e) {

            System.out.println("Error occured on Thread " + Thread.currentThread().getName() + " " + e.getMessage());

        }


    }


    private String getURL(BufferedReader in) throws IOException {
        String[] url = in.readLine().split(" ");
        return url[1];
    }


}
