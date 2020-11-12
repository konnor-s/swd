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

public class Client extends JFrame {
    private JTextField fileName;
    private JTextArea contentArea;
    private JButton saveButton;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String fileContents = "";
    private String chatServer;
    private Socket client;

    public Client(String host){
        super("Client");

        chatServer = host;

        fileName = new JTextField();
        fileName.setText("Enter file name");
        contentArea = new JTextArea();
        saveButton = new JButton();
        saveButton.setText("Save Changes");

        fileName.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event){
                        try{
                            output.writeObject(event.getActionCommand());
                            output.flush();
                        }
                        catch(IOException ioException){
                            ioException.printStackTrace();
                        }
                        fileName.setText("");
                    }
                }
        );
        saveButton.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent event) {
                        try {
                            output.writeObject(contentArea.getText());
                            output.flush();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                }

        );

        add(fileName, BorderLayout.NORTH);
        add(new JScrollPane(contentArea), BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);

    }
    public void runClient(){
        try  {
            connectToServer();
            getStreams();
            processConnection();
        }
        catch (EOFException eofException) {

        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
        finally {
            closeConnection();
        }
    }

    private void connectToServer() throws IOException   {
        client = new Socket(InetAddress.getByName(chatServer),23870);
    }
    private void getStreams() throws IOException {
        output = new ObjectOutputStream(client.getOutputStream());
        input = new ObjectInputStream(client.getInputStream());
    }
    private void processConnection() throws IOException {
       // setTextFieldEditable(true);
        while(true) {
            try {
                fileContents = (String) input.readObject();

            } catch (ClassNotFoundException classNotFoundException) {
            }
        }
    }
    private void closeConnection(){
        //setTextFieldEditable(false);
        try{
            output.close();
            input.close();
            client.close();
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }

    }

}
