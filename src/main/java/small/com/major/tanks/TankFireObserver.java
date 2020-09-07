package small.com.major.tanks;

import small.com.major.bullets.FireStrategy.Impl.CommonFire;

public class TankFireObserver {
    public void actionOnfire(TankFireEvent tankFireEvent){
        Tank source = (Tank) tankFireEvent.getSource();
        source.fire(CommonFire.getInstance());
    }
}
