/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ui;

import bl.DigitLabel;
import bl.DigitRow;
import java.time.LocalTime;
import java.time.ZoneId;
import javax.swing.JFrame;

/**
 *
 * @author martin
 */
public class TESt {
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame();
		DigitRow dr =new DigitRow(ZoneId.systemDefault());
		frame.getContentPane().add(dr);
		frame.setSize(800, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		while(true) {
			//set Value
			dr.showTime();
			Thread.sleep(500);
		}
	}
}
