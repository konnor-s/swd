import javax.swing.*;

/**
 * Main class for testing the orbiting planets GUI
 */
public class PlanetTest {
    /**
     * Creates the GUI
     * @param args
     */
    public static void main(String[] args){
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1000,700);
        gui.setVisible(true);
    }
}
