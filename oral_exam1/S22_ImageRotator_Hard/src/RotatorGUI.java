import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Class to set up the GUI, its components, and their event handlers
 *
 * @author Konnor Sommer
 *
 */
public class RotatorGUI extends JFrame{
    /**
     * Picture to be rotated
     */
    private final RotateLabel rLabel;
    /**
     * Field to enter angle to rotate to
     */
    private final JTextField angleField;
    /**
     * Angle of the picture
     */
    private int angle;
    /**
     * Timer used to schedule events to continuously rotate image
     */
    private Timer timer;
    /**
     * Button to choose continuous spin mode
     */
    private final JRadioButton continuous;
    /**
     * Button to choose incremental spin mode
     */
    private final JRadioButton incremental;
    /**
     * Slider to choose the speed of rotation for continuous mode
     */
    private final JSlider speedSlider;

    /**
     * Constructs GUI elements, defines event handlers, and assigns event handlers to certain elements
     */
    public RotatorGUI(){
        //Image ange starts at 0
        angle=0;
        angleField = new JTextField(5);

        //Create the speed slider
        speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 90, 45);
        speedSlider.setMajorTickSpacing(15);

        //Table which holds the labels for the speed slider
        Hashtable labelTable = new Hashtable();
        labelTable.put(  0 , new JLabel("0 deg/sec") );
        labelTable.put( 90 , new JLabel("90 deg/sec") );
        speedSlider.setLabelTable( labelTable );
        speedSlider.setPaintLabels(true);
        speedSlider.setPaintTicks(true);


        //Buffered image to load the image
        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource("pic.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


         //Image icon which holds the image
        ImageIcon pic = new ImageIcon(img);
        rLabel = new RotateLabel(pic);
        add(rLabel);

        //Create the radio buttons
        continuous = new JRadioButton("Continuous Mode -- Use speed slider", false);
        incremental = new JRadioButton("Incremental Mode -- Enter angle in box", true);

        //Button group for continuous and incremental buttons
        ButtonGroup buttons = new ButtonGroup();
        buttons.add(continuous);
        buttons.add(incremental);


        //Panel on which rotation controls are held
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(1,6));

        //Add elements to the infoPanel
        infoPanel.add(speedSlider);
        infoPanel.add(continuous);
        infoPanel.add(incremental);
        infoPanel.add(angleField);
        add(infoPanel, BorderLayout.SOUTH);

        //Add listeners
        speedSlider.addChangeListener(new SliderHandler());
        continuous.addItemListener(new ButtonHandler());
        incremental.addItemListener(new ButtonHandler());
        angleField.addActionListener(new AngleHandler());

        timer = new Timer(100, new TimerHandler());
    }

    /**
     * Implements JLabel functions to facilitate the rotation of a label
     */
    private class RotateLabel extends JLabel {
        /**
         * The angle to which the image needs to rotate
         */
        private int newAngle;

        /**
         * Constructs label with an image and angle of 0 degrees
         * @param pic The image icon for the JLabel
         */
        public RotateLabel(ImageIcon pic) {
            super(pic);
            newAngle = 0;
        }

        /**
         * Sets the new angle for the image
         * @param a The new angle
         */
        private void setAngle(int a){
            newAngle=a;
        }

        /**
         * Paints a rotated version of this image
         * @param g
         */
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.rotate(Math.toRadians(newAngle),getX() + getWidth()/2.  ,getY() +getHeight()/2. );
            super.paintComponent(g2d);
        }
    }

    /**
     * Implements action listener method for the timer
     * @see RotatorGUI#timer
     */
    private class TimerHandler implements ActionListener {
        /**
         * Detects when the timer ticks and moves the angle 2 degrees.
         * @param actionEvent
         */
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            rLabel.setAngle(angle);
            rLabel.repaint();
            angle = angle + 2;
        }
    }

    /**
     * Implements action listener method for angle input.
     *
     */
    private class AngleHandler implements ActionListener{
        /**
         * Detects when an angle is entered and sets the rLabel (image) angle.
         * @param actionEvent
         * @see RotatorGUI#rLabel
         */
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            angle = Integer.parseInt(angleField.getText());
            rLabel.setAngle(angle);
            rLabel.repaint();
        }
    }

    /**
     * Implements item listener method for the buttons.
     */
    private class ButtonHandler implements ItemListener {
        /**
         * Detects when a button is pressed and sets the rotation state accordingly.
         * If continuous is selected, starts the timer and sets the speed.
         * If incremental is selected, stops the timer.
         * @param itemEvent
         * @see RotatorGUI#timer
         */
        @Override
        public void itemStateChanged(ItemEvent itemEvent) {
            if (continuous.isSelected()){
                timer.start();
                timer.setDelay(1000/(speedSlider.getValue()/2));//speedSlider is in deg/sec. Angle moves 2 deg per timer tick. Convert deg/sec to sec.
            }
            if (incremental.isSelected()){
                timer.stop();
            }
        }
    }

    /**
     * Implements change listener method for the speed slider.
     */
    private class SliderHandler implements ChangeListener{
        /**
         * Detects when the speed slider moves and sets new delay for timer.
         * @param changeEvent
         * @see RotatorGUI#speedSlider
         * @see RotatorGUI#timer
         */
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            if (!speedSlider.getValueIsAdjusting()){//only work if its not moving. prevent laggy slider
                if (continuous.isSelected()) {
                    int speed = speedSlider.getValue();
                    timer.setDelay(1000 / (speed / 2));
                }
            }
        }
    }
}
