package small.com.major;

import java.awt.*;

public abstract class GameObject {
    protected int positionX,positionY;
    protected Rectangle rectangle = new Rectangle();

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

    public Rectangle getRectangle() {
        return rectangle;
    }

    public abstract void paint(Graphics g);
}
