import javax.swing.*;

public class TestDisplayEvents {
    public static void main(String[] args){
        DisplayEventsGUI gui = new DisplayEventsGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(1300,300);
        gui.setVisible(true);
    }
}
