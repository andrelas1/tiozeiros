package br.unifor.poo.tiozeiros;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by andre on 12/11/16.
 */
public class App2 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up");
            }
        }, 60*1000);
    }
}
