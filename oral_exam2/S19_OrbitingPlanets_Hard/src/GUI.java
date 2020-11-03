import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GUI extends JFrame {
    private final Space space;
    private ExecutorService executor = Executors.newCachedThreadPool();
    private Sun sun= new Sun(300,300,20,20);
    private Timer timer;
    private static ArrayList<Ball> orbs = new ArrayList<Ball>();

    GUI(){
        space = new Space();
        add(space);
        orbs.add(new Sun(0,0,300,300));

        timer = new Timer(1000, new TimerHandler());
        timer.start();
        space.addMouseListener(new MouseHandler());

    }


    private class Space extends JLabel{
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);


            for (Ball i : orbs) {
                if (i.g==0) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(i.getX(), i.getY(), 30, 30);
                }
                else {
                    g.setColor(Color.RED);
                    g.fillOval(i.getX(), i.getY(), 15, 15);
                }
            }
            repaint();
        }
    }


    private class MouseHandler implements MouseListener{
        int numPlanets = 0;
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if (numPlanets<2){
                numPlanets++;
                orbs.add(new Planet(numPlanets*30,1,numPlanets*30+ orbs.get(0).getX(), orbs.get(0).getY()));
                executor.execute(orbs.get(numPlanets));
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
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            space.repaint();

            System.out.println("repaint");
            //set new coordinates
        }
    }
}
