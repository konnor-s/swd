import java.awt.*;


/**
 * Defines characteristics and methods of celestial balls
 * @author Konnor Sommer
 */
public abstract class Ball implements Runnable{
    /**
     * Current x position
     */
    private int xPos;
    /**
     * current y position
     */
    private int yPos;
    /**
     * Current x center of rotation
     */
    private int xCenter;
    /**
     * Current y center of rotation
     */
    private  int yCenter;
    /**
     * Radius of rotation
     */
    private final int radius;
    /**
     * Width/radius of this ball
     */
    private final int width;
    /**
     * Angular speed of theis ball
     */
    private double speed;
    /**
     * Current angle of this ball
     */
    private double theta = 0;
    /**
     * Ball that this ball orbits
     */
    private Ball biggerOrb;


    /**
     * Constructs a ball that doesn't rotate around another ball (Sun)
     * @param r radius
     * @param x x position
     * @param y y position
     * @param w width
     */
    Ball(int r,int x, int y,int w){
        radius = r;
        xPos = x;
        yPos = y;
        width = w;
    }

    /**
     * Constructs a ball that rotates around another ball (planet or moon)
     * @param r radius
     * @param x x position
     * @param y y position
     * @param w width
     * @param orb orb that it orbits
     */
    Ball(int r,int x, int y,int w,Ball orb){
        radius = r;
        xPos = x;
        yPos = y;
        width = w;
        biggerOrb = orb;
    }

    /**
     * Returns color of ball
     * @return
     */
    public abstract Color getColor();
    /**
     * Returns type of ball
     * @return
     */
    public abstract int getType();

    /**
     * Returns current x position
     * @return x position
     */
    public int getX(){
        return xPos;
    }

    /**
     * Sets the speed of this ball
     * @param s speed
     */
    public void setSpeed(double s){
        speed = s;
    }
    /**
     * Returns current y position
     * @return y position
     */
    public int getY(){
        return yPos;
    }

    /**
     * Returns width of this ball
     * @return width
     */
    public int getWidth(){
        return width;
    }

    /**
     * Sets the x center of rotation
     * @param x new x center of rotation
     */
    public void setxCenter(int x){
        xCenter = x;
    }

    /**
     * Sets the y center of rotation
     * @param y new y center of rotation
     */
    public void setyCenter(int y){
        yCenter = y;
    }

    /**
     * Returns number of moons of this ball
     * Overriden in planet class.
     * @return 0
     */
    public int getMoons(){
        return 0;
    }

    /**
     * Adds new moon to this ball.
     * Overriden in planet class
     */
    public void addMoon(){}

    /**
     * Run method for this orb's thread which contiunuously updates its position and center of rotation
     */
    public void run(){
        while(true) {
            theta = theta + speed * 2 * Math.PI / 360;
            //Update new center based on the position of the bigger orb
            xCenter = biggerOrb.getX()+biggerOrb.getWidth();
            yCenter = biggerOrb.getY()+biggerOrb.getWidth();
            //Update position based on the center of rotation and this planet's radius and angle from that center
            xPos = (int)(xCenter + radius *  Math.cos(theta) - width);
            yPos = (int)(yCenter - radius *  Math.sin(theta) - width);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
