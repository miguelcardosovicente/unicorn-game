package org.academiadecodigo.bootcamp22.unicorngame.elements;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.Timer;
import java.util.TimerTask;

public class TimeCounter {

    private Timer timer;
    private int totalSeconds;
    private int secondsLeft;
    private Text timerText;

    public TimeCounter(int totalSeconds) {
        timer = new Timer();
        this.totalSeconds = totalSeconds;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public void start() {

        secondsLeft = totalSeconds;
        timerText = new Text(525, 20, "00 : " + secondsLeft);
        timerText.grow(50, 30);
        timerText.draw();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                secondsLeft--;

                if(secondsLeft < 10) {
                    timerText.setText("00 : 0" + secondsLeft);
                }

                if(secondsLeft >= 10){
                    timerText.setText("00 : " + secondsLeft);
                }

                if(secondsLeft == 0) {
                    //what shows when time ends
                    Rectangle rectangle = new Rectangle(10, 50, 600, 600);
                    rectangle.draw();
                    rectangle.fill();

                    timer.cancel();
                }
            }
        }, 1000, 1000);

    }

}
