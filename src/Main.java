import java.io.IOException;

public class Main {
    final static int PORT =3000;

    public static void main(String[] args) {
        try {
            //starting the server
             new Server(PORT);
        }
        catch (IOException e){
            e.getMessage();
        }

    }
}
