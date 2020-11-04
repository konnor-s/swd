public class Moon extends Planet {
    Moon(int r,int x, int y,int w,Ball planet){

        super(r,x,y,w,planet);
        setxCenter(planet.getX() + planet.getWidth());
        setyCenter(planet.getY() + planet.getWidth());

    }
    @Override
    public int getType(){
        return 2;
    }

}
