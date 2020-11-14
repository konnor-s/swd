/**
 * Class which opens a server
 * @author Konnor Sommer
 */
public class ServerTest {
    /**
     * Opens a server.
     * This should be run before opening a client.
     * @param args
     */
    public static void main(String[] args) {
        Server server = new Server();
        server.runServer();
    }
}
