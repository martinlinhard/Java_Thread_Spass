/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;

/**
 *
 * @author martin
 */
public class TimerLabel extends JLabel implements Runnable{

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            this.setText(dtf.format(LocalDateTime.now()));
            try {
                Thread.sleep(750);
            } catch (InterruptedException ex) {
                break; //interrupt while sleep --> cancel (interrupts are resetted while in sleep)
            }
        }
        this.setText("00:00:00");
    }
    
}
