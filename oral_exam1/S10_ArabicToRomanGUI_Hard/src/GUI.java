
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import java.awt.*;

/**
 * Class whch extends JFrame, used for constructing the GUI.
 * @author Konnor Sommer
 */
public class GUI extends JFrame {
    private final JTextField textField1;
    private final JTextField textField2;
    private final JLabel label1;
    private final JLabel label2;

    /**
     *
     */
    public GUI() {
        super("Convert Between Arabic and Roman Numerals");
        setLayout(new FlowLayout());

        textField1 = new JTextField();
        textField1.setColumns(15);

        textField2 = new JTextField();
        textField2.setColumns(15);


        label1 = new JLabel("Roman Numerals");
        label2 = new JLabel("Arabic Numerals");
        add(label1);
        add(textField1);
        add(textField2);
        add(label2);

        FieldHandler handler = new FieldHandler();
       // FieldHandler handler2 = new FieldHandler();
        textField1.addKeyListener(handler);
        textField2.addKeyListener(handler);
    }

    private class FieldHandler implements KeyListener {
        /**
         * Unused method.
         * @param event
         */
        @Override
        public void keyTyped(KeyEvent event) {}
        /**
         * Unused method.
         * @param event
         */
        @Override
        public void keyPressed(KeyEvent event) { }

        /**
         * Detects when a key is released in a text field and updates the opposing text field.
         * textField1 will update textField2 with new Arabic numerals.
         * textField2 will update textField1 with new Roman numerals.
         * @param event
         */



        @Override
        public void keyReleased(KeyEvent event) {
            String string;
            int num;
            //Event in textField1
            if (event.getSource() == textField1) {
                string = textField1.getText();
                //If there is a string entered
                if (!string.equals("")) {
                    num = Converter.RomanToArabic(string);
                    //If the converted number is positive, output it to textField2
                    if (num >0){
                        textField2.setText(Integer.toString(num));
                    }
                    //If the converted number isn't positive (invalid output), set textField2 to "?"
                    else {
                        textField2.setText("?");//invalid
                    }
                }
                //If no string, set textField2 to no string
                else textField2.setText("");
            }
            //Event in textField2
            if (event.getSource() == textField2) {
                string = textField2.getText();
                //If
                if (!string.equals("")) {
                    if (Integer.parseInt(string)>0 && Integer.parseInt(string)<4000) {
                        string = Converter.ArabicToRoman(Integer.parseInt(string));
                        textField1.setText(string);
                    }
                    else{
                        textField1.setText("?");
                    }
                }
                else textField1.setText("");
            }
        }
    }
}



