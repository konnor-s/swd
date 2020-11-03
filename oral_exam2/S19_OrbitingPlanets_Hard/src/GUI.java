import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;

public class GUI extends JFrame {
    private final Space space;
    private ExecutorService executer = Executors.newCachedThreadPool();
    private Sun sun= new Sun(300,300,20,20);

    GUI(){
        space = new Space();
        add(space);

    }


    private class Space extends JLabel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.YELLOW);
            g.fillOval(300,300,20,20);
    }

    }
    private class MouseHandler implements MouseListener{
        int numPlanets = 0;
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if (numPlanets<8){
                executor.execute(new Planet(numPlanets*10,1,sun));
            }
        }
        @Override
        public void mousePressed(MouseEvent mouseEvent) {        }
        @Override
        public void mouseReleased(MouseEvent mouseEvent) {        }
        @Override
        public void mouseEntered(MouseEvent mouseEvent) {        }
        @Override
        public void mouseExited(MouseEvent mouseEvent) {        }
    }
    private class TimerHandler implements ActionListener {
        /**
         * Detects when the timer ticks and moves the angle 2 degrees.
         * @param actionEvent
         */
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
}
