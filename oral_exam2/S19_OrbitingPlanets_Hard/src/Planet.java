

public class Planet extends Ball{
    private int moons = 0;
    Planet(int r, int x, int y, int w, Ball sun){
        super(r,x,y,w);
        setxCenter(sun.getX() + sun.getWidth());
        setyCenter(sun.getY() + sun.getWidth());
    }
    @Override
    public int getMoons(){
        return moons;
    }
    @Override
    public void addMoon(){
        moons++;
    }
    @Override
    public int getType(){
        return 1;
    }
}
