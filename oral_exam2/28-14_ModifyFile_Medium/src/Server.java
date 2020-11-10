import java.io.EOFException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket server;
    private Socket connection;
    public void runServer(){
        try{
            server = new ServerSocket(23870);
            while(true){
                try{
                    waitForConnection();
                    getStreams();
                    processConnection();
                    catch(EOFException eofException){

                    }
                }
            }
        }
    }
}
