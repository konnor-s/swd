import javax.swing.*;

public class TestDisplayEvents {
    public static void main(String[] args){
        DisplayEventsGUI gui = new DisplayEventsGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1200,500);
        gui.setVisible(true);
    }
}
