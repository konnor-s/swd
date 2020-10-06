

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RotatorGUI extends JFrame{
    private final RotateLabel rLabel;
    private final JTextField actionField;
    public RotatorGUI(){
       // setLayout(new FlowLayout());
        actionField = new JTextField(15);
        actionField.addActionListener(new ActionHandler());
        add(actionField, BorderLayout.SOUTH);
        Icon pic = new ImageIcon(getClass().getResource("pic.png"));
        rLabel = new RotateLabel(pic);
        add(rLabel);

    }
    private class RotateLabel extends JLabel {
        private int angle;
        private int newAngle;
        public RotateLabel(Icon pic) {
            super(pic);
            angle = 0;
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
            angle=newAngle;
        }//
    }
    private class ActionHandler implements ActionListener {
        /**
         * Dete
         */
        private int angle = 0;

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            angle = Integer.parseInt(actionField.getText());
            rLabel.setAngle(angle);
            rLabel.repaint();
            repaint();
        }
    }
    /*
    for(i=angle;i<=newAngle;i++){
        rLabel.paintComponent
     */
}
