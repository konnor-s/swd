
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class RotatorGUI extends JFrame{
    private final RotateLabel rLabel;
    private final JTextField speedField;
    private final JTextField angleField;
    private int angle;
    private Timer timer;
    private final JRadioButton continuous;
    private final JRadioButton incremental;
    private final ButtonGroup buttons;
    private final JPanel topPanel;

    public RotatorGUI(){
        angle=0;
        speedField = new JTextField(15);
        speedField.addActionListener(new SpeedHandler());
        angleField = new JTextField(15);
        angleField.addActionListener(new AngleHandler());
        Icon pic = new ImageIcon(getClass().getResource("pic.png"));
        rLabel = new RotateLabel(pic);
        add(rLabel);

        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,6));

        continuous = new JRadioButton("Continuous", false);
        incremental = new JRadioButton("Incremental", true);
        buttons = new ButtonGroup();
        buttons.add(continuous);
        buttons.add(incremental);

        topPanel.add(speedField);
        topPanel.add(continuous);
        topPanel.add(incremental);
        topPanel.add(angleField);

        add(topPanel, BorderLayout.SOUTH);

        continuous.addItemListener(new ButtonHandler());
        incremental.addItemListener(new ButtonHandler());


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

        }//
    }
    private class TimerHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            rLabel.setAngle(angle);
            rLabel.repaint();
            angle = angle + 2;
        }
    }
    private class SpeedHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent){
            timer.setDelay(Integer.parseInt(speedField.getText()));
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
            }
            if (incremental.isSelected()){
                timer.stop();
            }
        }
    }
}
