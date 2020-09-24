
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import java.awt.*;

public class GUI extends JFrame {
    private final JTextField textField1;
    private final JTextField textField2;
    private final JLabel label1;
    private final JLabel label2;

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
        @Override
        public void keyTyped(KeyEvent event) {
        }

        @Override
        public void keyPressed(KeyEvent event) {
        }
        @Override
        public void keyReleased(KeyEvent event) {
            String string;
            int num;
            if (event.getSource() == textField1) {
                string = textField1.getText();
                if (!string.equals("")) {
                    num = Converter.RomanToArabic(string);
                    if (num >0){
                        textField2.setText(Integer.toString(num));
                    }
                    else {
                        textField2.setText("?");//invalid
                    }
                }
                else textField2.setText("");
            }
            if (event.getSource() == textField2) {
                string = textField2.getText();
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



