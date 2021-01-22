import acm.graphics.GRect;

import java.awt.*;

public class GSquare extends GRect {
    private boolean notSize;
    private double maxSize;
    private double minSize;

    public GSquare(double x, double y, double size){
        super(x,y, size,size);
        this.maxSize = size;
        this.minSize = size / 2;
        this.notSize = false;

    }

    public void setSize(double size) {
        if (!notSize) setSize(size, size);
    }

    public void setNotSize(boolean notSize) {
        this.notSize = notSize;
    }

    public boolean isNotSize() {
        return notSize;
    }

    public void setColor(Color color) {
        super.setFilled(true);
        super.setColor(color);
        super.setColor(color);
    }


}
