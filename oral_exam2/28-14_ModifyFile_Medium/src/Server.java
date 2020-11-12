import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class Server {
    private ServerSocket server;
    private Socket connection;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Formatter fileOut;
    private String root = "oral_exam2/28-14_ModifyFile_Medium/src/";
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
        System.out.println("Talking...");
        while(true){

            String nameIn = new String();
            String contentIn = new String();
            String oldContents;
            //Get client's  file name
            try { nameIn = (String) input.readObject(); }
            catch(ClassNotFoundException c){}
            //set path
            Path path = Paths.get(root+nameIn);

            if(Files.exists(path)) {
                //Read contents from file into string
                oldContents = new String(Files.readAllBytes(path));
                //send contents to client
                output.writeObject(oldContents);
                output.flush();

                //Read edited file from client
                try { contentIn = (String) input.readObject(); }
                catch(ClassNotFoundException c){}

                //Write edited contents back to file
                fileOut = new Formatter(root +nameIn);
                fileOut.format(contentIn);
                fileOut.close();
                //fileOut.flush();
            }
            else{
                output.writeObject("Invalid file name");
            }
        }
    }
}
