package small.com.major.tanks;

import small.com.major.GameObject;

public class TankFireEvent {

    private GameObject source;

    public TankFireEvent(GameObject source) {
        this.source = source;
    }

    public GameObject getSource() {
        return source;
    }
}
