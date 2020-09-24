import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GUI extends JFrame{
    private final JTextField textField1;
    private final JTextField textField2;

    //private final JTextField textField3;
    //private final JTextField textField4;

    public GUI(){
        super("Convert Between Arabic and Roman Numerals");
        setLayout(new FlowLayout());

        textField1=new JFormattedTextField("XV");
        //textField1.setText("XV");
        add(textField1);
        textField2=new JFormattedTextField("15");
        //textField2.setText("15")
        add(textField2);
        //textField3=new JTextField(10);
        //add(textField3);
        //textField4=new JTextField(10);
       // add(textField4);
        FieldHandler handler = new FieldHandler();
        textField1.addPropertyChangeListener("value",handler);
        textField2.addPropertyChangeListener("value", handler);
    }
    /*
    private class TextFieldHandler implements TextListener{
        @Override
        public void textValueChanged(TextEvent event){
            String string = "";
            int num = 0;

            if (event.getSource() == textField1){
                string = event.paramString();
                num = Converter.RomanToArabic(string);
                textField2.setText(Integer.toString(num));
            }
            if(event.getSource() == textField2){
                string = event.paramString();
                string = Converter.ArabicToRoman(Integer.parseInt(string));
                textField1.setText(string);
            }
        }

     */
    public class FieldHandler implements PropertyChangeListener{
        @Override
        public void propertyChange(PropertyChangeEvent event) {
            String string = "";
            int num = 0;

            if (event.getSource() == textField1) {
                string = event.getPropertyName();
                num = Converter.RomanToArabic(string);
                textField2.setText(Integer.toString(num));
            }
            else if (event.getSource() == textField2) {
                string = event.getPropertyName();
                string = Converter.ArabicToRoman(Integer.parseInt(string));
                textField1.setText(string);
            }
        }
    }
}
