import javax.swing.JFrame;

/**
 * Main class for testing Arabic/Roman numeral conversion and the corresponding GUI.
 * @author Konnor Sommer
 */
public class TestArabicToRoman {
    /**
     * Creates and displays the GUI used for Arabic/Roman numeral conversion.
     * @param args
     */
    public static void main(String[] args){
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(800,100);
        gui.setVisible(true);
    }
}
