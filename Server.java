import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server;
    private Socket socket;
    private BufferedReader br;
    private PrintWriter out;

    public Server() {
        try {
            server = new ServerSocket(7777);
            System.out.println("Server is ready to accept connections ");
            System.out.println("Waiting for Requests");
            socket = server.accept();
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            startReading();
            startWriting();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void startReading()
    {
        //Thread Give us data by reading
        Runnable rn=()->
        {
            System.out.println("Reader Started ");
            while(true)
            {
             String message=  br.readLine();
             if(message.equals("Quit"))
             {
                 System.out.println("Client Has Stopped ");
             }
            }
        };
    }
    public  void startWriting()
    {
        //Thread will take data user and send it to client
        Runnable r2=()->{

        };
    }
    public static void main(String[] args) {
        System.out.println("This is Server");
        Server server = new Server();
    }
}
