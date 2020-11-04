import javax.swing.*;

public abstract class Ball implements Runnable{
    private int xPos;
    private int yPos;
    private int xCenter;
    private int yCenter;
    private int radius;
    private int width;
    private double speed = Math.random() * (2 - .2 + 1) + .2;
    private double theta = 0;
    private Ball biggerOrb;
    Ball(int r,int x, int y,int w){
        radius = r;
        xPos = x;
        yPos = y;
        width = w;
    }
    Ball(int r,int x, int y,int w,Ball orb){
        radius = r;
        xPos = x;
        yPos = y;
        width = w;
        biggerOrb = orb;
    }
    public abstract int getType();
    public int getX(){
        return xPos;
    }
    public int getY(){
        return yPos;
    }
    public int getRadius(){
        return radius;
    }
    public int getWidth(){
        return width;
    }
    public void setxCenter(int x){
        xCenter = x;
    }
    public void setyCenter(int y){
        yCenter = y;
    }
    public int getMoons(){
        return 0;
    }
    public void addMoon(){}
    public void run(){

        while(true) {
            theta = theta + speed * 2 * Math.PI / 360;
            xCenter = biggerOrb.getX()+biggerOrb.getWidth();
            yCenter = biggerOrb.getY()+biggerOrb.getWidth();
            xPos = (int)(xCenter + radius *  Math.cos(theta) - width);
            yPos = (int)(yCenter - radius *  Math.sin(theta) - width);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
