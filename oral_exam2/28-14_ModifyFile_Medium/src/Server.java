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

/**
 * Implements a server for sending, receiving, and editing files.
 * @author Konnor Sommer
 */
public class Server {
    /**
     * Socket for this server
     */
    private ServerSocket server;
    /**
     * Socket for connection to client
     */
    private Socket connection;
    /**
     * Output stream to client
     */
    private ObjectOutputStream output;
    /**
     * Input stream from client
     */
    private ObjectInputStream input;

    /**
     * Runs the server, opening it for connections to clients
     */
    public void runServer(){
        try{
            server = new ServerSocket(23870,1);
            //open server to connect to clients. After 1 client closes theirs, loop through again for another client
            while(true){
                try {
                    waitForConnection();
                    getStreams();
                    processConnection();
                }
                catch(EOFException eofException){
                }
                finally{
                    closeConnection();
                }

            }
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    /**
     * Waits for a client to connect to this server
     * @throws IOException
     */
    private void waitForConnection() throws IOException{
        System.out.println("Waiting for connection...");
        connection = server.accept();
    }

    /**
     * Opens input and output streams to client
     * @throws IOException
     */
    private void getStreams() throws IOException{

        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        System.out.println("Connected successfully");
    }

    /**
     * Allows client to send modifications to a desired file, and this server will modify that file.
     * @throws IOException
     */
    private void processConnection() throws IOException {
        String root = "oral_exam2/28-14_ModifyFile_Medium/src/";
        //Continuous looping while client is open
        while (true) {
            String nameIn = "";
            String contentIn = "";
            String oldContents;
            //Get client's  file name
            try {
                nameIn = (String) input.readObject();
            } catch (ClassNotFoundException ignored) { }

            //set path
            Path path = Paths.get(root + nameIn);

            //If this path exists, send file
            if (!nameIn.equals("") & Files.exists(path)) {
                //Read contents from file into string
                oldContents = new String(Files.readAllBytes(path));
                //send contents to client
                output.writeObject(oldContents);
                output.flush();

                //Read edited file from client
                try {
                    contentIn = (String) input.readObject();
                } catch (ClassNotFoundException ignored) {
                }

                //Write edited contents back to file and close it
                Formatter fileOut = new Formatter(root + nameIn);
                fileOut.format(contentIn);
                fileOut.close();

            }
            //if file is invalid or blank
            else {
                output.writeObject("Invalid file name");
            }
        }
    }

    /**
     * Closes connection with client
     */
    private void closeConnection(){
        try{
            output.close();
            input.close();
            connection.close();
            System.out.println("Connection closed");
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }

}
