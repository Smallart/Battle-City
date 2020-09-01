package small.com.major.Decorate;

import small.com.major.GameObject;

import java.awt.*;

public class GoDecorator extends GameObject {

    private GameObject go;
    public GoDecorator(GameObject go){
        this.go=go;
    }

    public GameObject getGo() {
        return go;
    }

    @Override
    public void paint(Graphics g) {
        go.paint(g);
    }

    @Override
    public int getHeight() {
        return go.getHeight();
    }

    @Override
    public int getWidth() {
        return go.getWidth();
    }
}
