/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JLabel;

/**
 *
 * @author martin
 */
public class DigitLabel extends JLabel implements Runnable {

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2 = (Graphics2D) g;
        double scaleX = this.getWidth() / 11.;
        double scaleY = this.getHeight() / 18.;

        AffineTransform atrans = new AffineTransform();
        atrans.scale(scaleX, scaleY);
        g2.transform(atrans);
    }

    private int[] getXCoordinatesForSegment(int n) {
        switch (n) {
            case 0:
                return new int[]{
                    2, 3, 8, 9, 8, 3
                };
            case 1:
                return new int[]{
                    9, 8, 8, 9, 10, 10
                };
            case 2:
                return new int[]{
                    9, 8, 8, 9, 10, 10
                };
            case 3:
                return new int[]{
                    2, 3, 8, 9, 8, 3
                };
            case 4:
                return new int[]{
                    2, 1, 1, 2, 3, 3
                };
            case 5:
                return new int[]{
                    2, 1, 1, 2, 3, 3
                };
            case 6:
                return new int[]{
                    2, 3, 8, 9, 8, 3
                };
            //oberer dp
            case -1:
                return new int[]{
                    4, 4, 7, 7
                };
                            //unterer dp
            case -2:
                return new int[]{
                    4, 4, 7, 7
                };
            default:
                return null;
        }
    }

    private int[] getYCoordinatesForSegment(int n) {
        switch (n) {
            case 0:
                return new int[]{
                    2, 3, 3, 2, 1, 1
                };
            case 1:
                return new int[]{
                    3, 3, 9, 10, 9, 4
                };
            case 2:
                return new int[]{
                    10, 11, 15, 16, 15, 11
                };
            case 3:
                return new int[]{
                    16, 17, 17, 16, 15, 15
                };
            case 4:
                return new int[]{
                    9, 10, 15, 16, 15, 10
                };
            case 5:
                return new int[]{
                    2, 3, 8, 9, 8, 3
                };
            case 6:
                return new int[]{
                    9, 10, 10, 9, 8, 8
                };
            //oberer dp
            case -1:
                return new int[]{
                    4, 7, 7, 4
                };
            //unterer dp
            case -2:
                return new int[]{
                    11, 14, 14, 11
                };
            default:
                return null;
        }
    }
}
