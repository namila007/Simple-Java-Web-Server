import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Server {

    public Server (int port) throws IOException {
        ServerSocket server = new ServerSocket(port);

        while(true){
            try(Socket socket = server.accept()){
                DataOutputStream out= new DataOutputStream(socket.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String url = getURL(in);
                System.out.println(url);

                if(url.equals("/")){
                    System.out.println("hello");
                  Pages.sendIndexPage(out);
                }
                else if (url.equals("/getimage")){
                    Images.sendImage(out);
                }
                else if (url.equals("/favicon.ico")){
                    Images.sendFavicon(out);
                }
                else if(url.equals("/bootstrap.css")){
                    Pages.sendBootstrap(out);
                }
                else if(url.equals("/cover.css")){
                    Pages.sendCovercss(out);
                }
                else if(url.equals("/secondpage.html")){
                    Pages.sendSecondPage(out);
                }
                else{
                    Pages.sendErrorPage(out);
                }
                out.close();

            }catch (Exception e){
                e.printStackTrace();
            }

        }



    }



    private String getURL(BufferedReader in) throws IOException{
        String[] url = in.readLine().split(" ");
        return url[1];
    }


}
