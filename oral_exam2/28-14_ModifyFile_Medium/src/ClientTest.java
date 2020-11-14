import javax.swing.*;

/**
 * Class which opens a client.
 * @author Konnor Sommer
 */
public class ClientTest {
    /**
     * Opens a client.
     * @param args
     */
    public static void main(String[] args) {
        Client application;
        application = new Client("127.0.0.1");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(500,400);
        application.setVisible(true);
        application.runClient();
    }
}
