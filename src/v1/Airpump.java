package v1;

/**
 * Created by ryan on 11/8/16.
 */
public class Airpump extends TankComponent {
    int o2IncreaseFactor;

    public Airpump(int o2IncreaseFactor, String name){
        super(1, name);
        this.o2IncreaseFactor = o2IncreaseFactor;
    }


    @Override
    public void affectEnvironment(boolean isAdded) {
        if (isAdded){
            if (Water.o2 + this.o2IncreaseFactor <= Water.MAX_O2) {
                Water.o2 += this.o2IncreaseFactor;
            }
            else {
                Water.o2 = Water.MAX_O2;
            }
        }
        else {
            if (Water.o2 - this.o2IncreaseFactor >= Water.MIN_O2) {
                Water.o2 -= this.o2IncreaseFactor;
            }
            else {
                Water.o2 = Water.MIN_O2;
            }
        }
    }
}
