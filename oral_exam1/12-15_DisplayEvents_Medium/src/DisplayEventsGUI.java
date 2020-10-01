import javax.swing.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;

/*
ActionListener,
ItemListener,
ListSelectionListener,
MouseListener,
MouseMotionListener
KeyListener
 */
public class DisplayEventsGUI extends JFrame{
    private final JTextField inputField;
    private final JLabel actionField;
    private final JLabel keyField;
    private final JLabel itemField;
    private final JLabel listField;
    private final JList<String> colorList;
    private final ButtonGroup buttons;
    private final JRadioButton plainButton;
    private final JRadioButton italicButton;
    private final Font labelFont;
    private final Color[] colors={Color.WHITE,Color.BLUE,Color.RED};
    private final String[] colorNames={"White","Blue","Red"};
    public DisplayEventsGUI() {
        super("Display Events");
        setLayout(new FlowLayout());
        colorList=new JList<String>(colorNames);
        colorList.setVisibleRowCount(3);
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        labelFont=new Font("Serif",Font.PLAIN,9);
        inputField = new JTextField(15);
        actionField = new JLabel();
        actionField.setFont(labelFont);
        keyField = new JLabel();
        keyField.setFont(labelFont);
        itemField=new JLabel();
        itemField.setFont(labelFont);
        listField=new JLabel();
        listField.setFont(labelFont);

        plainButton = new JRadioButton("Plain", true);
        italicButton = new JRadioButton("Italic", false);
        buttons = new ButtonGroup();
        buttons.add(plainButton);
        buttons.add(italicButton);

        add(new JScrollPane(colorList));
        add(inputField);
        add(plainButton);
        add(italicButton);
        add(actionField);
        add(keyField);
        add(itemField);
        add(listField);

        plainButton.addItemListener(new ButtonHandler(new Font("Serif",Font.PLAIN,14)));
        italicButton.addItemListener(new ButtonHandler(new Font("Serif",Font.ITALIC,14)));

        inputField.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        actionField.setText(actionEvent.toString());
                    }
                }
        );
        inputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent keyEvent) {
                        keyField.setText(keyEvent.toString());
                    }

                    @Override
                    public void keyPressed(KeyEvent keyEvent) {
                        keyField.setText(keyEvent.toString());

                    }

                    @Override
                    public void keyReleased(KeyEvent keyEvent) {
                        keyField.setText(keyEvent.toString());

                    }
                }
        );
        colorList.addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent listSelectionEvent) {
                        inputField.setBackground(colors[colorList.getSelectedIndex()]);
                        listField.setText(listSelectionEvent.toString());
                    }
                }
        );
    }
    private class ButtonHandler implements ItemListener{
        private Font font;

        public ButtonHandler(Font font){
            this.font=font;
        }
        @Override
        public void itemStateChanged(ItemEvent event){
            inputField.setFont(font);
            itemField.setText(event.toString());
        }
    }
}
