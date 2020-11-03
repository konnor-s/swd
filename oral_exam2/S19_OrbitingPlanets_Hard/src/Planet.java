

public class Planet extends Ball{

    Planet(int r, int x, int y, int w, Ball sun){
        super(r,x,y,w);
        setxCenter(sun.getX() + sun.getWidth());
        setyCenter(sun.getY() + sun.getWidth());
    }

    @Override
    public int getType(){
        return 1;
    }
}
