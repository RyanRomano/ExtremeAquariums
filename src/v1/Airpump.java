package v1;

/**
 * Created by ryan on 11/8/16.
 */
public class Airpump extends TankComponent {
    int o2IncreaseFactor;

    public Airpump(int o2IncreaseFactor){
        super(1);
        this.o2IncreaseFactor = o2IncreaseFactor;
        increaseO2();
    }

    public void increaseO2(){
        if (Water.o2 + this.o2IncreaseFactor <= Water.MAX_O2) {
            Water.o2 += this.o2IncreaseFactor;
        }
        else {
            Water.o2 = Water.MAX_O2;
        }
    }
}
