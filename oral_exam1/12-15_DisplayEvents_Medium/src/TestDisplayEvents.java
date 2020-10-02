import javax.swing.*;

/**
 * Implements test of DisplayEventsGUI class
 * @see DisplayEventsGUI
 */
public class TestDisplayEvents {
    /**
     * Creates DisplayEventsGUI and displays it for testing.
     * @param args
     * @see DisplayEventsGUI
     */
    public static void main(String[] args){
        DisplayEventsGUI gui = new DisplayEventsGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1300,300);
        gui.setVisible(true);
    }
}
