import java.awt.*;

/**
 * Extends Ball class to define the more specific type, planet
 * @author Konnor Sommer
 */
public class Planet extends Ball{
    /**
     * Number of moons this planet has
     */
    private int moons = 0;
    /**
     * Array of possible planet colors
     */
    private static final Color[] colors = new Color[]{Color.blue,Color.green,Color.PINK,Color.red,Color.cyan,Color.magenta,Color.orange};
    /**
     * This planet's color
     */
    private final Color color;
    /**
     * Constructs a planet
     * @param r radius
     * @param x x position
     * @param y y position
     * @param w width
     * @param sun sun that this orbits
     */
    Planet(int r, int x, int y, int w, Ball sun){
        super(r,x,y,w,sun);
        setxCenter(sun.getX() + sun.getWidth());
        setyCenter(sun.getY() + sun.getWidth());
        int rand = (int) (Math.random() * 6);
        color = colors[rand];
    }

    /**
     * Returns this plant's color
     * @return color
     */
    @Override
    public Color getColor(){
        return color;
    }

    /**
     * Returns the number of moons this planet has
     * @return number of moons
     */
    @Override
    public int getMoons(){
        return moons;
    }

    /**
     * Adds a new moon to this planet
     */
    @Override
    public void addMoon(){
        moons++;
    }

    /**
     * Returns the type of orb (planet = 1)
     * @return 1
     */
    @Override
    public int getType(){
        return 1;
    }
}
