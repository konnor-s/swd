import javax.swing.*;

public abstract class Ball implements Runnable{
    int xPos;
    int yPos;
    int xCenter;
    int yCenter;
    int radius;
    int width;
    double speed = Math.random() * (4 - .5 + 1) + .5;
    double theta = 0;
   // JLabel space;
    Ball(int r,int x, int y,int w){
        radius = r;
        xPos = x;
        yPos = y;
        width = w;
        //this.space = space;
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
