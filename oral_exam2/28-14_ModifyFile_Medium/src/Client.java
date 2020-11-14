import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Implements a client and its GUI for sending file modifications to a server.
 * @author Konnor Sommer
 */
public class Client extends JFrame {
    /**
     * Text field for file name
     */
    private JTextField fileName;
    /**
     * Text area for file contents
     */
    private JTextArea contentArea;
    /**
     * Ouptput stream to server
     */
    private ObjectOutputStream output;
    /**
     * Input stream from server
     */
    private ObjectInputStream input;
    /**
     * File contents
     */
    private String fileContents = "";
    /**
     * host address
     */
    private String chatServer;
    /**
     * Socket for this client
     */
    private Socket client;

    /**
     * Constructs the GUI for this client
     * @param host address
     */
    public Client(String host){
        super("Client");

        chatServer = host;

        fileName = new JTextField();
        fileName.setText("Enter file name (text1.txt or text2.txt)");

        contentArea = new JTextArea();
        contentArea.setEditable(false);

        JButton saveButton = new JButton();
        saveButton.setText("Save Changes");

        //Add action listener to file name field which sends the name to the server for verification
        fileName.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event){
                        //Send name to server
                        try{
                            output.writeObject(event.getActionCommand());
                            output.flush();
                        }
                        catch(IOException ioException){
                            ioException.printStackTrace();
                        }
                        //Change filed to blank and set uneditable
                        fileName.setText("");
                        fileName.setEditable(false);
                    }
                }
        );
        //Add listener to save button to send file modifications to server
        saveButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    //If the content area is editable, send its data to the . Otherwise, don't do anything
                    if (contentArea.isEditable()) {
                        try {
                            output.writeObject(contentArea.getText());
                            output.flush();

                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        //reset area to blank and set it to uneditable. set file name to editable for requesting another file
                        contentArea.setText("");
                        contentArea.setEditable(false);
                        fileName.setEditable(true);
                    }
                }
            }

        );

        add(fileName, BorderLayout.NORTH);
        add(new JScrollPane(contentArea), BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);

    }

    /**
     * Connect this client to the server and allow them to communicate
     */
    public void runClient(){
        try  {
            connectToServer();
            getStreams();
            processConnection();
        }
        catch (EOFException ignored) {

        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
        finally {
            closeConnection();
        }

    }

    /**
     * Connects this client to the server
     * @throws IOException
     */
    private void connectToServer() throws IOException   {
        client = new Socket(InetAddress.getByName(chatServer),23870);
    }

    /**
     * Gets input and output streams for the server connection
     * @throws IOException
     */
    private void getStreams() throws IOException {
        output = new ObjectOutputStream(client.getOutputStream());
        input = new ObjectInputStream(client.getInputStream());
    }

    /**
     * Receives file data from server and displays it for editing
     * @throws IOException
     */
    private void processConnection() throws IOException {
        //loop through while client is open
        while(true) {
            //Read input from server to file contents string
            try { fileContents = (String) input.readObject();}
            catch (ClassNotFoundException ignored) {     }
            contentArea.setText(fileContents);
            //if input is good, set the content area to editable. otherwise keep it uneditable and set file name to editable to request another file.
            if (!fileContents.equals("Invalid file name")) {
                contentArea.setEditable(true);
            }
            else{
                fileName.setEditable(true);
            }
        }
    }

    /**
     *Closes this client
     */
    private void closeConnection(){

        try{
            System.out.println("Terminated");
            output.close();
            input.close();
            client.close();
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
        //Shuts down this program
        finally{
            System.exit(0);
        }
    }
}
