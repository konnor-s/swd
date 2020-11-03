import javax.swing.*;

public abstract class Ball implements Runnable{
    int xPos;
    int yPos;
    int radius;
    float speed;
    double theta = 0;
   // JLabel space;
    Ball(int r, float s,int x, int y){
        radius = r;
        speed = s;
        xPos = x;
        yPos = y;
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
    public void run(){
        System.out.println("run");
        while(true) {
            theta = theta + 2 * Math.PI / 360;
            xPos = (int)(300 + radius *  Math.cos(theta ));
            yPos = (int)(300 - radius *  Math.sin(theta ));
            Thread.sleep(10);
        }
    }
}
