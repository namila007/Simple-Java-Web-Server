import java.io.IOException;

public class Worker  extends Thread{
    private int port;
    public Worker(int Port){
        this.port = port;
    }
    @Override
    public void run() {
        try{
            Server sv = new Server(port);
        }
        catch (Exception e) {
            System.out.println("Error occured on Thread "+Thread.currentThread().getName()+" , error "+ e.getMessage());
        }
    }
}
