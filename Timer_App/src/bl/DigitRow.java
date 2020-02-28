/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 *
 * @author martin
 */
public class DigitRow extends JPanel implements Runnable {

    private DigitLabel[] labels;

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");

    private ZoneId zone;

    public DigitRow(ZoneId zone) {
	this.zone = zone;
        GridLayout gl = new GridLayout(1, 8, 0, 10);
        this.setLayout(gl);

        //skip the :
        DigitLabel[] localLabels = new DigitLabel[6];

        int indexMinus = 0;

        for (int i = 0; i < 8; i++) {
            DigitLabel d = new DigitLabel();
            this.add(d); // add it to the layout

            //skip the :
            if (i == 2 || i == 5) {
                indexMinus++;
                continue;
            }

            localLabels[i - indexMinus] = d;
	    d.setCurrentNumber(PROPERTIES);
        }

        this.labels = localLabels;

    }

    public DigitLabel[] getLabels() {
        return labels;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            this.showTime();
            try {
                Thread.sleep(750);
            } catch (InterruptedException ex) {
                break; //interrupt while sleep --> cancel (interrupts are resetted while in sleep)
            }
        }
    }

    public void showTime() {
        char[] chars = DigitRow.dtf.format(LocalTime.now(zone)).toCharArray();
        for (int i = 0; i < this.labels.length; i++) {
            this.labels[i].setCurrentNumber(Integer.parseInt(chars[i] + ""));
        }
    }

	public void setZone(ZoneId zone) {
		this.zone = zone;
	}
    
}
