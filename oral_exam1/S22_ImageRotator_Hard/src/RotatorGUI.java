
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
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;


public class RotatorGUI extends JFrame{

    private final RotateLabel rLabel;
    private final JTextField angleField;
    private int angle;
    private Timer timer;
    private final JRadioButton continuous;
    private final JRadioButton incremental;
    private final JSlider speedSlider;

    public RotatorGUI(){
        angle=0;
        angleField = new JTextField(5);

        speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 90, 45);
        speedSlider.setMajorTickSpacing(15);
        Hashtable labelTable = new Hashtable();
        labelTable.put(  0 , new JLabel("0 deg/sec") );
        labelTable.put( 90 , new JLabel("90 deg/sec") );
        speedSlider.setLabelTable( labelTable );
        speedSlider.setPaintLabels(true);
        speedSlider.setPaintTicks(true);

        BufferedImage img = null;
        try {
            img = ImageIO.read(getClass().getResource("pic.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Icon pic = new ImageIcon(img);
        rLabel = new RotateLabel(pic);
        add(rLabel);

        continuous = new JRadioButton("Continuous Mode -- Use speed slider", false);
        incremental = new JRadioButton("Incremental Mode -- Enter angle in box", true);
        ButtonGroup buttons = new ButtonGroup();
        buttons.add(continuous);
        buttons.add(incremental);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(1,6));
        infoPanel.add(speedSlider);
        infoPanel.add(continuous);
        infoPanel.add(incremental);
        infoPanel.add(angleField);
        add(infoPanel, BorderLayout.SOUTH);

        speedSlider.addChangeListener(new SliderHandler());
        continuous.addItemListener(new ButtonHandler());
        incremental.addItemListener(new ButtonHandler());
        angleField.addActionListener(new AngleHandler());

        timer = new Timer(100, new TimerHandler());
    }
    private class RotateLabel extends JLabel {
        private int newAngle;
        public RotateLabel(Icon pic) {
            super(pic);
            newAngle = 0;
        }
        private void setAngle(int a){
            newAngle=a;
        }
        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.rotate(Math.toRadians(newAngle),getX() + getWidth()/2.  ,getY() +getHeight()/2. );
            super.paintComponent(g2d);
        }
    }
    private class TimerHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            rLabel.setAngle(angle);
            rLabel.repaint();
            angle = angle + 2;
        }
    }
    private class AngleHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            angle = Integer.parseInt(angleField.getText());
            rLabel.setAngle(angle);
            rLabel.repaint();
        }
    }
    private class ButtonHandler implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent itemEvent) {
            if (continuous.isSelected()){
                timer.start();
                timer.setDelay(1000/(speedSlider.getValue()/2));
            }
            if (incremental.isSelected()){
                timer.stop();
            }
        }
    }
    private class SliderHandler implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            if (continuous.isSelected()) {
                int speed = speedSlider.getValue();
                timer.setDelay(1000 / (speed / 2));
            }
        }
    }
}
