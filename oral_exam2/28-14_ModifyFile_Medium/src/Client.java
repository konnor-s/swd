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
    private JTextArea fileContents;
    private JButton saveButton;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String message = "";
    private String chatServer;
    private Socket client;

    public Client(String host){
        super("Client");

        chatServer = host;

        fileName = new JTextField();
        fileName.setText("Enter file name");
        fileContents = new JTextArea();
        saveButton = new JButton();
        saveButton.setText("Save Changes");

        fileName.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event){
                       // sendData(event.getActionCommand());
                        fileName.setText("");
                    }
                }
        );

        add(fileName, BorderLayout.NORTH);
        add(new JScrollPane(fileContents), BorderLayout.CENTER);
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
        client = new Socket(InetAddress.getByAddress(),23870);
    }
    private void getStreams() throws IOException {
        output = new ObjectOutputStream(client.getOutputStream());
        input = new ObjectInputStream(client.getInputStream());
    }
    private void processConnection() throws IOException {
        setTextFieldEditable(true);
        do {
            try {
                message = (String) input.readObject();
                displayMessage(message);
            } catch (ClassNotFoundException classNotFoundException) {
            }
        }
    }
    private void closeConnection(){
        setTextFieldEditable(false);
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
