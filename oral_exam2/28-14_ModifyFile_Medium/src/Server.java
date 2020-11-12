import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Server {
    private ServerSocket server;
    private Socket connection;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private static Scanner fileData;
    public void runServer(){
        try{
            server = new ServerSocket(23870);
            while(true){
                try {
                    waitForConnection();
                    getStreams();
                    processConnection();
                }
                catch(EOFException eofException){
                }
                finally{
                    //closeConnection();
                }

            }
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
    private void waitForConnection() throws IOException{
        connection = server.accept();
    }
    private void getStreams() throws IOException{
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
    }
    private void processConnection() throws IOException{
        while(true){
            try{
                String newContents = new String();
                String oldContents;
                newContents = (String) input.readObject();
                Path path = Paths.get(newContents);
                if(Files.exists(path)) {
                    oldContents = new String(Files.readAllBytes(path));
                    output.writeObject(oldContents);
                    output.flush();
                }
                   // fileData = new Scanner(path);
                    //newContents =

                //update file
            }
            catch(ClassNotFoundException classNotFoundException){}
        }
    }
}
