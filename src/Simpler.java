import acm.graphics.GPoint;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Simpler extends WindowProgram {
    private final static int SIZE_SQUARE = 100;
    boolean flag = true;


    public void run() {
        addSquares();
        addMouseListeners();

    }




    public void mouseMoved(MouseEvent event) {
        GSquare obj = (GSquare) getElementAt(event.getX(), event.getY());
        if (obj == null) return;
        double xCenter = obj.getX() + obj.getWidth() / 2.0;
        double yCenter = obj.getY() + obj.getHeight() / 2.0;
        double maxSize = 100;
        double minSize = 50;
        double x = obj.getX();
        double y = obj.getY();

        if (obj.getColor() == Color.BLACK ) {
            double size = obj.getHeight();
            if (flag) {
                size--;
                if (obj.getHeight() == minSize){
                    flag = !flag;
                    x = x +1;
                    y = y +1;

                }

            }
            else {
                size++;
                if (obj.getHeight() == maxSize) {
                    flag = !flag;
                    x = x -1 ;
                    y = y -1;
                }
            }

            obj.setSize(size);

            obj.setLocation(x, y);

        }
    }

    public void mouseClicked(MouseEvent event) {
        GSquare obj = (GSquare) getElementAt(event.getX(), event.getY());
        if (obj == null) return;
        obj.setNotSize(!obj.isNotSize());
    }

    private void addSquares () {
        int quantityX = getWidth() / SIZE_SQUARE * 2;
        int quantityY = getHeight() / SIZE_SQUARE *2;
        double dx = (getWidth() - quantityX * SIZE_SQUARE * 2) / 2.0;
        double dy = (getHeight() - quantityY * SIZE_SQUARE * 2) / 2.0;
        System.out.println(quantityX + " " + quantityY);

        for (int i = 0; i < quantityY; i++)
            for (int j = 0; j < quantityX; j++) {
                double x = j * SIZE_SQUARE*2 + dx;
                double y = i * SIZE_SQUARE*2 + dy;

                add(new GSquare(x, y , SIZE_SQUARE));
            }
    }


}
