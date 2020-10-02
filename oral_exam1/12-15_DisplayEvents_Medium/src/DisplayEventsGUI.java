import javax.swing.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;


public class DisplayEventsGUI extends JFrame{
    /**
     * Field for inputting text
     */
    private final JTextField inputField;
    /**
     * Label for captioning action events
     */
    private final JLabel actionCap;
    /**
     * Label for captioning key events
     */
    private final JLabel keyCap;
    /**
     * Label for captioning item events
     */
    private final JLabel itemCap;
    /**
     * Label for captioning list selection events
     */
    private final JLabel listCap;
    /**
     * Label for captioning mouse events
     */
    private final JLabel mouseCap;
    /**
     * Label for captioning mouse motion events
     */
    private final JLabel motionCap;
    /**
     * Label for displaying action event details
     */
    private final JLabel actionField;
    /**
     * Label for displaying key event details
     */
    private final JLabel keyField;
    /**
     * Label for displaying item event details
     */
    private final JLabel itemField;
    /**
     * Label for displaying list event details
     */
    private final JLabel listField;
    /**
     * Label for displaying mouse event details
     */
    private final JLabel mouseField;
    /**
     * Label for displaying mouse motion event details
     */
    private final JLabel motionField;
    /**
     * Label for displaying instruction on how to operate program
     */
    private final JLabel instruct;
    /**
     * List for selecting colors
     */
    private final JList<String> colorList;
    /**
     * Button group for plain and italic buttons
     */
    private final ButtonGroup buttons;
    /**
     * Button to change font to plain
     */
    private final JRadioButton plainButton;
    /**
     * Button to change font to italics
     */
    private final JRadioButton italicButton;
    /**
     * Font to apply to event detail labels
     */
    private final Font labelFont;
    /**
     * Array of colors
     */
    private final Color[] colors={Color.WHITE,Color.BLUE,Color.RED};
    /**
     * Array of color names
     */
    private final String[] colorNames={"White","Blue","Red"};
    /**
     * Top panel used for inputs/ performing events
     */
    private final JPanel panel1;
    /**
     * Bottom panel used for displaying event information
     */
    private final JPanel panel2;

    /**
     * Constructs GUI elements, defines event handlers, and assigns event handlers to certain elements
     */
    public DisplayEventsGUI() {
        super("Display Events");

        //Construct both panels
        panel1=new JPanel();
        panel1.setLayout(new FlowLayout());
        panel2=new JPanel();
        panel2.setLayout(new GridLayout(12,1));

        //Construct Jlist of colors for selection
        colorList=new JList<String>(colorNames);
        colorList.setVisibleRowCount(3);
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Construct input text field
        inputField = new JTextField(15);

        //Construct instructions label
        instruct=new JLabel();
        instruct.setText("Move/click mouse, use list, use buttons, and type to see events");

        //Define font used for event detail labels
        labelFont=new Font("Serif",Font.PLAIN,9);

        //Construct event captions and detail labels
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


        //Construct buttons for plain and italic, add them to button group
        plainButton = new JRadioButton("Plain", true);
        italicButton = new JRadioButton("Italic", false);
        buttons = new ButtonGroup();
        buttons.add(plainButton);
        buttons.add(italicButton);

        //Add elements to panel1
        panel1.add(instruct);
        panel1.add(new JScrollPane(colorList));
        panel1.add(inputField);
        panel1.add(plainButton);
        panel1.add(italicButton);

        //Add elements to panel2
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

        //Add panel1 and panel2 to top and bottom of frame
        add(panel1,BorderLayout.NORTH);
        add(panel2,BorderLayout.SOUTH);

        //Add item listeners to both font buttons
        plainButton.addItemListener(new ButtonHandler(new Font("Serif",Font.PLAIN,14)));
        italicButton.addItemListener(new ButtonHandler(new Font("Serif",Font.ITALIC,14)));

        //Add action listener to inputField
        inputField.addActionListener(new ActionHandler());
        //Add key listener to input field
        inputField.addKeyListener(new KeyHandler());
        //Add list selection listener to color list
        colorList.addListSelectionListener(new ListHandler());
        //Add mouse listener to the JFrame
        addMouseListener(new MouseHandler());
        //Add mouse motion listener to the JFrame
        addMouseMotionListener(new MotionHandler());
    }
    /**
     * Implements action listener methods
     */
    private class ActionHandler implements ActionListener {
        /**
         * Detects when an action occurs and prints the event details to the label actionField
         * @param actionEvent   Action event which occured
         * @see DisplayEventsGUI#actionField
         */
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            actionField.setText("Action Event: " + actionEvent.toString());
        }
    }
    /**
     * Implements key listener methods
     */
    private class KeyHandler implements KeyListener {
        /**
         * Detects when a key typed event occurs and prints the event details to the label keyField
         * @param keyEvent  Key typed event which occured
         * @see DisplayEventsGUI#keyField
         */
        @Override
        public void keyTyped(KeyEvent keyEvent) {
            keyField.setText("Key Typed: " +keyEvent.toString());
        }
        /**
         * Detects when a key pressed event occurs and prints the event details to the label keyField
         * @param keyEvent  Key pressed event which occured
         * @see DisplayEventsGUI#keyField
         */
        @Override
        public void keyPressed(KeyEvent keyEvent) {
            keyField.setText("Key Pressed: "+keyEvent.toString());

        }
        /**
         * Detects when a key released event occurs and prints the event details to the label keyField
         * @param keyEvent  Key released event which occured
         * @see DisplayEventsGUI#keyField
         */
        @Override
        public void keyReleased(KeyEvent keyEvent) {
            keyField.setText("Key Released: "+keyEvent.toString());

        }
    }
    /**
     * Implements list selection methods
     */
    private class ListHandler implements ListSelectionListener {
        /**
         * Detects when a value changed event occurs and prints the event details to the label listField, also changing inputField to the selected color
         * @param listSelectionEvent   Value changed event which occured
         * @see DisplayEventsGUI#listField
         * @see DisplayEventsGUI#inputField
         */
        @Override
        public void valueChanged(ListSelectionEvent listSelectionEvent) {
            inputField.setBackground(colors[colorList.getSelectedIndex()]);
            listField.setText("List Selection ("+colorList.getSelectedValue()+"): "+listSelectionEvent.toString());
        }
    }

    /**
     * Implements mouse listener methods
     */
    private class MouseHandler implements MouseListener {
        /**
         * Detects when a mouse clicked event occurs and prints the event details to the label mouseField
         * @param mouseEvent  Mouse clicked event which occured
         * @see DisplayEventsGUI#mouseField
         */
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            mouseField.setText("Mouse Clicked: "+mouseEvent.toString());
        }
        /**
         * Detects when a mouse pressed event occurs and prints the event details to the label mouseField
         * @param mouseEvent  Mouse pressed event which occured
         * @see DisplayEventsGUI#mouseField
         */
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            mouseField.setText("Mouse Pressed: "+mouseEvent.toString());
        }
        /**
         * Detects when a mouse released event occurs and prints the event details to the label mouseField
         * @param mouseEvent  Mouse released event which occured
         * @see DisplayEventsGUI#mouseField
         */
        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            mouseField.setText("Mouse Released: "+mouseEvent.toString());
        }
        /**
         * Detects when a mouse entered event occurs and prints the event details to the label mouseField
         * @param mouseEvent  Mouse entered event which occured
         * @see DisplayEventsGUI#mouseField
         */
        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
            mouseField.setText("Mouse Entered: "+mouseEvent.toString());
        }
        /**
         * Detects when a mouse exited event occurs and prints the event details to the label mouseField
         * @param mouseEvent  Mouse exited event which occured
         * @see DisplayEventsGUI#mouseField
         */
        @Override
        public void mouseExited(MouseEvent mouseEvent) {
            mouseField.setText("Mouse Exited: "+mouseEvent.toString());
        }
    }

    /**
     * Implements mouse motion listener methods
     */
    private class MotionHandler implements MouseMotionListener{
        /**
         * Detects when a mouse dragged event occurs and prints the event details to the label motionField
         * @param mouseEvent  Mouse dragged event which occured
         * @see DisplayEventsGUI#motionField
         */
        @Override
        public void mouseDragged(MouseEvent mouseEvent) {
            motionField.setText("Mouse Dragged: "+mouseEvent.toString());
        }
        /**
         * Detects when a mouse moved event occurs and prints the event details to the label motionField
         * @param mouseEvent  Mouse moved event which occured
         * @see DisplayEventsGUI#motionField
         */
        @Override
        public void mouseMoved(MouseEvent mouseEvent) {
            motionField.setText("Mouse Moved: "+mouseEvent.toString());
        }
    }
    /**
     * Implements methods from ItemListener for applying to buttons.
     */
    private class ButtonHandler implements ItemListener{
        /**
         * Font to be used for this button
         */
        private Font font;

        /**
         * Construct the handler with its font
         * @param font    The font to be used for this button
         */
        public ButtonHandler(Font font){
            this.font=font;
        }

        /**
         * Detects when an item state changed event occurs and prints the event details to the label itemField, and sets the font of inputField to the button's font
         * @param event  Item state changed event which occured
         * @see DisplayEventsGUI#itemField
         * @see DisplayEventsGUI#inputField
         */
        @Override
        public void itemStateChanged(ItemEvent event){
            //set the font of the input field
            inputField.setFont(font);
            //Display either plain or italics message
            if (font.getStyle()==0){
                itemField.setText("Item State Changed: (Plain): "+event.toString());
            }
            if (font.getStyle() == 2) {
                itemField.setText("Item State Changed: (Italic): "+event.toString());
            }
        }
    }
}
