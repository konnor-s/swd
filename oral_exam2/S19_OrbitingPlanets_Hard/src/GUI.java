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
    private Sun sun= new Sun(0,300,300,15);
    private Timer timer;
    private static ArrayList<Ball> orbs = new ArrayList<Ball>();

    GUI(){
        space = new Space();
        space.setBackground(Color.BLACK);
        add(space);
        orbs.add(sun);

        timer = new Timer(1000, new TimerHandler());
        timer.start();
        space.addMouseListener(new MouseHandler());

    }


    private class Space extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);


            for (Ball i : orbs) {
                if (i.getType()==0) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(i.getX(), i.getY(), i.getWidth()*2, i.getWidth()*2);
                }
                else if (i.getType() == 1){
                    g.setColor(Color.RED);
                    g.fillOval(i.getX(), i.getY(), i.getWidth()*2, i.getWidth()*2);
                }
                else if (i.getType() == 2){
                    g.setColor(Color.white);
                    g.fillOval(i.getX(),i.getY(),i.getWidth()*2, i.getWidth()*2);
                }
            }
            repaint();
        }
    }


    private class MouseHandler implements MouseListener{
        int numPlanets = 0;
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if (numPlanets<8){
                numPlanets++;
                orbs.add(new Planet(numPlanets*40,numPlanets*40+ orbs.get(0).getX(), orbs.get(0).getY(),10, sun));
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
