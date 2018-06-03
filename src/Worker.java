import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Worker  implements Runnable{
    private Socket socket;
    private DataOutputStream out;
    private BufferedReader in ;

    public Worker (Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
       try {
        out = new DataOutputStream(socket.getOutputStream());
         in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String url = getURL(in);
        System.out.println("requesting "+url);


        System.out.println("Thread"+Thread.currentThread().getName()+" sending "+url);
        if(url.equals("/")){
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
           in.close();
           socket.close();

        }catch (Exception e){

           System.out.println("Error occured on Thread "+ Thread.currentThread().getName()+" "+e.getMessage());

        }



    }



    private String getURL(BufferedReader in) throws IOException {
        String[] url = in.readLine().split(" ");
        return url[1];
    }



}
