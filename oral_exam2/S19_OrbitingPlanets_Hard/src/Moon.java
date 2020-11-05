import java.awt.*;

/**
 * Extends Planet class to define more specific type, Moon
 * @author Konnor Sommer
 */
public class Moon extends Planet {
    /**
     * Constructs a moon
     * @param r radius
     * @param x x position
     * @param y y position
     * @param w width
     * @param planet planet this orbits
     */
    Moon(int r,int x, int y,int w,Ball planet){
        super(r,x,y,w,planet);
    }

    /**
     * Returns moon color
     * @return white
     */
    @Override
    public Color getColor(){
        return Color.white;
    }
    /**
     * Returns type of this orb (moon = 2)
     * @return 2
     */
    @Override
    public int getType(){
        return 2;
    }

}
