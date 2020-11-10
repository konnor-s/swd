import javax.swing.*;

public class ClientTest {
    public static void main(String[] args) {
        Client application;
        application = new Client("127.0.0.1");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(500,400);
        application.setVisible(true);
        application.runClient();
    }
}
