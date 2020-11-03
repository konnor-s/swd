import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Planet extends Ball{


    Planet(int r, float s,int x,int y){
        super(r,s,x,y);

    }

    private class TimerHandler implements ActionListener {
        /**
         * Detects when the timer ticks and moves the angle 2 degrees.
         * @param actionEvent
         */
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    }
}
