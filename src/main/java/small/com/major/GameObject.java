package small.com.major;

import java.awt.*;

public abstract class GameObject {
    protected int positionX,positionY;

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public abstract void paint(Graphics g);
    public abstract int getHeight();
    public abstract int getWidth();
}
