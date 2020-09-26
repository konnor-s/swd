
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import java.awt.*;

/**
 * Class which is used for defining the characteristics of the GUI within the JFrame and how it operates.
 * @author Konnor Sommer
 * @see GUI#GUI()
 * @see FieldHandler
 */
public class GUI extends JFrame {
    /**
     * Field for inputting Roman numerals.
     */
    private final JTextField textField1;
    /**
     * Field for inputting Arabic numerals.
     */
    private final JTextField textField2;
    /**
     * Label for Roman numeral field.
     */
    private final JLabel label1;
    /**
     * Label for Arabic field.
     */
    private final JLabel label2;

    /**
     *Constructs GUI elements and adds them to the JFrame.
     */
    public GUI() {
        super("Convert Between Arabic and Roman Numerals");
        setLayout(new FlowLayout());

        //Create textfields and their labels, add them to the JFrame
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

        //Register event handler with text fields
        FieldHandler handler = new FieldHandler();
        textField1.addKeyListener(handler);
        textField2.addKeyListener(handler);
    }

    /**
     * Event-listener interface that handles keyPressed events for text fields 1 and 2.
     * When something is typed in either text field, it is put through the appropriate converter, then the opposite text field is updated with the conversion.
     */
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
         * @param event The keyReleased event
         * @see Converter#RomanToArabic(String)
         * @see Converter#ArabicToRoman(int)
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
                //If string is entered
                if (!string.equals("")) {
                    //Try to use Integer.parseInt() method
                    try {
                        //if integer is valid
                        if (Integer.parseInt(string) > 0 && Integer.parseInt(string) < 4000) {
                            //Convert the number to roman then update textField1
                            string = Converter.ArabicToRoman(Integer.parseInt(string));
                            textField1.setText(string);
                        }
                        //integer out of range
                        else textField1.setText("?");
                    }
                    //If something other than an integer is entered
                    catch(Exception e){
                        textField1.setText("?");
                    }
                }
                else textField1.setText("");
            }
        }
    }
}



