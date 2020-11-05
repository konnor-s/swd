import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Defines aspects of the GUI which is a JFrame
 * @author Konnor Sommer
 */
public class GUI extends JFrame {
    /**
     * JPanel for displaying planets
     */
    private final Space space;
    /**
     * Manages threads for each planet and moon
     */
    private ExecutorService executor = Executors.newCachedThreadPool();
    /**
     * Sun displayed in the middle of the panel
     */
    private final Sun sun= new Sun(0,450,350,15);
    /**
     * Updates the JPanel periodically to let the planets move
     */
    private Timer timer;
    /**
     * List of orbs which include the sun and the planets
     */
    private ArrayList<Ball> orbs = new ArrayList<Ball>();
    /**
     * List of the moons
     */
    private ArrayList<Moon> moons = new ArrayList<Moon>();

    /**
     * Constructs the GUI and adds event listeners
     */
    GUI(){
        //Create space background
        space = new Space();
        space.setBackground(Color.BLACK);
        add(space);
        //add the sun to the orbs list
        orbs.add(sun);
        //Create and start timer
        //timer = new Timer(100, new TimerHandler());
        //timer.start();
        //Add listeners for the creation of planets and moons
        space.addMouseListener(new MouseHandler());
        addKeyListener(new KeyHandler());

    }

    /**
     * Defines behavior of the space JPanel
     */
    private class Space extends JPanel{
        /**
         * paints the JPanel with updated graphics
         * @param g graphics
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Ball i : orbs) {
                //Paint sun
                if (i.getType()==0) {
                    g.setColor(i.getColor());
                    g.fillOval(i.getX(), i.getY(), i.getWidth()*2, i.getWidth()*2);
                }
                //Paint planets
                else if (i.getType() == 1){

                    g.setColor(i.getColor());
                    g.fillOval(i.getX(), i.getY(), i.getWidth()*2, i.getWidth()*2);
                }
            }
            //Paint moons
            for(Moon i : moons){
                g.setColor(i.getColor());
                g.fillOval(i.getX(),i.getY(),i.getWidth()*2, i.getWidth()*2);
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();

        }
    }

    /**
     * Handles mouse events to allow new planets to be created
     */
    private class MouseHandler implements MouseListener{
        int numPlanets = 0;

        /**
         * Creates a new planet when the mouse is clicked
         * @param mouseEvent mouse click
         */
        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if (numPlanets<8){
                numPlanets++;
                orbs.add(new Planet(20+numPlanets*35,20+numPlanets*35+ orbs.get(0).getX(), orbs.get(0).getY(),10, sun));
                executor.execute(orbs.get(numPlanets));
            }
        }

        /**
         * Unused
         * @param mouseEvent
         */
        @Override
        public void mousePressed(MouseEvent mouseEvent) {        }

        /**
         * Unused
         * @param mouseEvent
         */
        @Override
        public void mouseReleased(MouseEvent mouseEvent) {        }

        /**
         * Unused
         * @param mouseEvent
         */
        @Override
        public void mouseEntered(MouseEvent mouseEvent) {        }

        /**
         * Unused
         * @param mouseEvent
         */
        @Override
        public void mouseExited(MouseEvent mouseEvent) {        }
    }

    /**
     * Handles key events to allow new moons to be created
     */
    private class KeyHandler implements KeyListener{
        /**
         * Creates a new moon for a particular planet
         * @param keyEvent
         */
        @Override
        public void keyPressed(KeyEvent keyEvent) {
            //When a certain number key is pressed, create a new moon for that planet
            for (int i = 1; i < 9; i++) {
                try {
                    if (keyEvent.getKeyChar() == (char) (i+'0') & orbs.get(i).getMoons() < 2) {
                        orbs.get(i).addMoon();
                        moons.add(new Moon(10+orbs.get(i).getMoons() * 10, 10+orbs.get(i).getMoons() * 10 + orbs.get(0).getX(), orbs.get(0).getY(), 3, orbs.get(i)));
                        executor.execute(moons.get(moons.size() - 1));
                    }
                }
                //Ignore the out of bounds exception. Occurs if you try to create a moon for a planet that isn't yet created
                catch (IndexOutOfBoundsException ignored){}
            }
        }
        /**
         * Unused
         * @param keyEvent
         */
        @Override
        public void keyTyped(KeyEvent keyEvent) {
        }
        /**
         * Unused
         * @param keyEvent
         */
        @Override
        public void keyReleased(KeyEvent keyEvent) {        }
    }

    /**
     * Handles action events for the timer
     */
    private class TimerHandler implements ActionListener {
        /**
         * Repaints the JPanel
         * @param actionEvent
         */
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            space.repaint();

        }
    }
}
