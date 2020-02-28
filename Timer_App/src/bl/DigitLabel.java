/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package bl;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author martin
 */
public class DigitLabel extends JLabel {

	private List<List<Integer>> xCoords;
	private List<List<Integer>> yCoords;

	private int currentNumber;

	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
		this.repaint();
	}

	public DigitLabel() {
		try {
			HashMap<String, List<List<Integer>>> res = IO_Handler.getValues();
			this.xCoords = res.get("xVal");
			this.yCoords = res.get("yVal");
			this.setCurrentNumber(-1);
			this.setOpaque(true);
		} catch (IOException ex) {
		}
	}

	@Override
	public void paint(Graphics grphcs) {
		super.paint(grphcs); //To change body of generated methods, choose Tools | Templates.
		Graphics2D g2 = (Graphics2D) grphcs;
		double scaleX = this.getWidth() / 11.;
		double scaleY = this.getHeight() / 18.;

		AffineTransform atrans = new AffineTransform();
		atrans.scale(scaleX, scaleY);
		g2.transform(atrans);

		g2.setStroke(new BasicStroke(0.2f));

		for (int seg : this.getSegmentsForDigit(this.currentNumber)) {
			g2.setColor(Color.RED);
			int[] x = this.getXCoordinatesForSegment(seg);
			int[] y = this.getYCoordinatesForSegment(seg);
			g2.fillPolygon(x, y, x.length);
			g2.setColor(Color.BLACK);
			g2.drawPolygon(x, y, x.length);
		}
	}

	private int[] getXCoordinatesForSegment(int n) {
		return this.xCoords.get(n).stream().mapToInt(val -> val).toArray();
	}

	private int[] getYCoordinatesForSegment(int n) {
		return this.yCoords.get(n).stream().mapToInt(val -> val).toArray();
	}

	private int[] getSegmentsForDigit(int number) {
		switch (number) {
			case 0:
				return new int[]{
					0, 1, 2, 3, 4, 5
				};
			case 1:
				return new int[]{
					1, 2
				};
			case 2:
				return new int[]{
					0, 1, 6, 4, 3
				};
			case 3:
				return new int[]{
					0, 1, 6, 2, 3
				};
			case 4:
				return new int[]{
					5, 6, 2, 1
				};
			case 5:
				return new int[]{
					0, 5, 6, 2, 3
				};
			case 6:
				return new int[]{
					0, 5, 6, 4, 3, 2
				};
			case 7:
				return new int[]{
					0, 1, 2
				};
			case 8:
				return new int[]{
					0, 1, 2, 3, 4, 5, 6
				};
			case 9:
				return new int[]{
					0, 1, 5, 6, 2, 3
				};
			case -1:
				return new int[]{
					7,8
				};
			default:
				return null;
		}
	}

	@Override
	public String toString() {
		return "DigitLabel{" + "currentNumber=" + currentNumber + '}';
	}

}
