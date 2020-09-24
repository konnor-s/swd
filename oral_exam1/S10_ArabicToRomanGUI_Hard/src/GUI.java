import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class GUI extends JFrame{
    private final JTextField textField1;
    private final JTextField textField2;
    //private final JTextField textField3;
    //private final JTextField textField4;

    public GUI(){
        super("Convert Between Arabic and Roman Numerals");
        setLayout(new FlowLayout());

        textField1=new JTextField(10);
        textField1.setText("Enter Roman Numerals");
        add(textField1);
        textField2=new JTextField(10);
        textField2.setEditable(false);
        add(textField2);
        //textField3=new JTextField(10);
        //add(textField3);
        //textField4=new JTextField(10);
       // add(textField4);

        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);
    }
    private class TextFieldHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            String string = "";
            int num = 0;

            if (event.getSource() == textField1){
                string = event.getActionCommand();
                num = Converter.RomanToArabic(string);
                textField2.setText(Integer.toString(num));
            }
        }
    }
}
