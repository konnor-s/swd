import javax.swing.*;

/**
 * Facilitates the creation of a new Rotator GUI class GUI.
 * @author Konnor Sommer
 * @see RotatorGUI
 */
public class TestRotate {
    /**
     * Creates and displays a new RotatorGUI class GUI.
     *  @param args
     * @see RotatorGUI
     */
    public static void main(String[] args){
        RotatorGUI gui = new RotatorGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1200,800);
        gui.setVisible(true);
    }
}
