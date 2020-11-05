import java.awt.*;

/**
 * Extends class Ball to define more specific type, Sun
 * @author Konnor Sommer
 */
public class Sun extends Ball {
    /**
     * constructs a new sun
     * @param r radius
     * @param x x position
     * @param y y position
     * @param w width
     */
    Sun(int r, int x, int y,int w){
        super(r,x,y,w);
    }

    /**
     * Returns sun color
     * @return yellow
     */
    @Override
    public Color getColor(){
        return Color.yellow;
    }
    /**
     * Returns type of this orb (sun = 0)
     * @return 0
     */
    @Override
    public int getType(){
        return 0;
    }
}
