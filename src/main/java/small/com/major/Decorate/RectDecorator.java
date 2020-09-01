package small.com.major.Decorate;

import small.com.major.Collider;
import small.com.major.GameObject;

import java.awt.*;

public class  RectDecorator extends GoDecorator {
    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Color color = g.getColor();
        g.setColor(Color.red);
        g.drawRect(super.getGo().getPositionX(),super.getGo().getPositionY(),getWidth(),getHeight());
        g.setColor(color);
    }
}
