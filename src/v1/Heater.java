package v1;

/**
 * Created by ryan on 11/8/16.
 */
public class Heater extends TankComponent {
    //vol in cubic inches
    public Heater(){
        super(1);
    }

    public void increaseWaterTemp(){
        if (Water.temperature <= Water.MAX_TEMPERATURE) {
            Water.temperature++;
        }
    }

    public void decreaseWaterTemp(){
        if(Water.temperature <= Water.MIN_TEMPERATURE){
            Water.temperature--;
        }
    }

    public void setTempToMax(){
        Water.temperature = Water.MAX_TEMPERATURE;
    }

    public void setTempToMin(){
        Water.temperature = Water.MIN_TEMPERATURE;
    }
}
