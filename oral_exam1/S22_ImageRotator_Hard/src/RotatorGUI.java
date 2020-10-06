

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RotatorGUI extends JFrame{
    private final RotateLabel rLabel;
    private final JTextField actionField;
    private int angle;
    private Timer timer;
    public RotatorGUI(){

        angle=0;

        actionField = new JTextField(15);
        actionField.addActionListener(new SpeedHandler());
        add(actionField, BorderLayout.SOUTH);
        Icon pic = new ImageIcon(getClass().getResource("pic.png"));
        rLabel = new RotateLabel(pic);
        add(rLabel);
        timer = new Timer(1000, new TimerHandler());
        timer.start();
    }
    public void setAngle(int i){
        angle = i;
    }

    public int getAngle() {
        return angle;
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
            rLabel.setAngle(getAngle());
            rLabel.repaint();

            setAngle(getAngle()+1);
        }
    }
    private class SpeedHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent){
            timer.setDelay(Integer.parseInt(actionField.getText()));
        }

    }
}
