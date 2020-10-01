import javax.swing.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;


public class DisplayEventsGUI extends JFrame{
    private final JTextField inputField;
    private final JLabel actionCap;
    private final JLabel keyCap;
    private final JLabel itemCap;
    private final JLabel listCap;
    private final JLabel mouseCap;
    private final JLabel motionCap;
    private final JLabel actionField;
    private final JLabel keyField;
    private final JLabel itemField;
    private final JLabel listField;
    private final JLabel mouseField;
    private final JLabel motionField;
    private final JLabel instruct;
    private final JList<String> colorList;
    private final ButtonGroup buttons;
    private final JRadioButton plainButton;
    private final JRadioButton italicButton;
    private final Font labelFont;
    private final Color[] colors={Color.WHITE,Color.BLUE,Color.RED};
    private final String[] colorNames={"White","Blue","Red"};
    private final JPanel panel1;
    private final JPanel panel2;
    public DisplayEventsGUI() {
        super("Display Events");
        panel1=new JPanel();
        panel1.setLayout(new FlowLayout());
        panel2=new JPanel();
        panel2.setLayout(new GridLayout(12,1));
        colorList=new JList<String>(colorNames);
        colorList.setVisibleRowCount(3);
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        labelFont=new Font("Serif",Font.PLAIN,9);
        inputField = new JTextField(15);
        instruct=new JLabel();
        instruct.setText("Move/click mouse, use list, use buttons, and type to see events");


        actionCap=new JLabel();
        actionCap.setText("Action Event:");
        actionField = new JLabel();
        actionField.setFont(labelFont);
        keyCap=new JLabel();
        keyCap.setText("Key Event:");
        keyField = new JLabel();
        keyField.setFont(labelFont);
        itemCap=new JLabel();
        itemCap.setText("Item Event:");
        itemField=new JLabel();
        itemField.setFont(labelFont);
        listCap=new JLabel();
        listCap.setText("List Selection Event:");
        listField=new JLabel();
        listField.setFont(labelFont);
        mouseCap=new JLabel();
        mouseCap.setText("Mouse Event:");
        mouseField=new JLabel();
        mouseField.setFont(labelFont);
        motionCap=new JLabel();
        motionCap.setText("Mouse Motion Event:");
        motionField=new JLabel();
        motionField.setFont(labelFont);



        plainButton = new JRadioButton("Plain", true);
        italicButton = new JRadioButton("Italic", false);
        buttons = new ButtonGroup();
        buttons.add(plainButton);
        buttons.add(italicButton);



        panel1.add(instruct);
        panel1.add(new JScrollPane(colorList));
        panel1.add(inputField);
        panel1.add(plainButton);
        panel1.add(italicButton);

        panel2.add(actionCap);
        panel2.add(actionField);
        panel2.add(keyCap);
        panel2.add(keyField);
        panel2.add(itemCap);
        panel2.add(itemField);
        panel2.add(listCap);
        panel2.add(listField);
        panel2.add(mouseCap);
        panel2.add(mouseField);
        panel2.add(motionCap);
        panel2.add(motionField);

        add(panel1,BorderLayout.NORTH);
        add(panel2,BorderLayout.SOUTH);

        plainButton.addItemListener(new ButtonHandler(new Font("Serif",Font.PLAIN,14)));
        italicButton.addItemListener(new ButtonHandler(new Font("Serif",Font.ITALIC,14)));

        inputField.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        actionField.setText("Action Event: " + actionEvent.toString());
                    }
                }
        );
        inputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent keyEvent) {
                        keyField.setText("Key Typed: " +keyEvent.toString());
                    }

                    @Override
                    public void keyPressed(KeyEvent keyEvent) {
                        keyField.setText("Key Pressed: "+keyEvent.toString());

                    }

                    @Override
                    public void keyReleased(KeyEvent keyEvent) {
                        keyField.setText("Key Released: "+keyEvent.toString());

                    }
                }
        );
        colorList.addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent listSelectionEvent) {
                        inputField.setBackground(colors[colorList.getSelectedIndex()]);
                        listField.setText("List Selection ("+colorList.getSelectedValue()+"): "+listSelectionEvent.toString());
                    }
                }
        );
        addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent mouseEvent) {
                        mouseField.setText("Mouse Clicked: "+mouseEvent.toString());
                    }

                    @Override
                    public void mousePressed(MouseEvent mouseEvent) {
                        mouseField.setText("Mouse Pressed: "+mouseEvent.toString());
                    }

                    @Override
                    public void mouseReleased(MouseEvent mouseEvent) {
                        mouseField.setText("Mouse Released: "+mouseEvent.toString());
                    }

                    @Override
                    public void mouseEntered(MouseEvent mouseEvent) {
                        mouseField.setText("Mouse Entered: "+mouseEvent.toString());
                    }

                    @Override
                    public void mouseExited(MouseEvent mouseEvent) {
                        mouseField.setText("Mouse Exited: "+mouseEvent.toString());
                    }
                }
        );
        addMouseMotionListener(
                new MouseMotionListener(){
                    @Override
                    public void mouseDragged(MouseEvent mouseEvent) {
                        motionField.setText("Mouse Dragged: "+mouseEvent.toString());
                    }

                    @Override
                    public void mouseMoved(MouseEvent mouseEvent) {
                        motionField.setText("Mouse Moved: "+mouseEvent.toString());
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
            if (font.getStyle()==0){
                itemField.setText("Item State Changed: (Plain): "+event.toString());
            }
            if (font.getStyle() == 2) {
                itemField.setText("Item State Changed: (Italic): "+event.toString());
            }
        }
    }
}
