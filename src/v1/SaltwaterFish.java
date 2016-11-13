package v1;

/**
 * Created by ryan on 11/8/16.
 */
public class SaltwaterFish extends Fish {
    private boolean freshWater;

    public SaltwaterFish(int volume, int aggressionLevel, int swimmingLevel,
                          int o2DecreaseFactor, int co2IncreaseFactor, int nh4IncreaseFactor, String name){
        super(volume, aggressionLevel, swimmingLevel, o2DecreaseFactor, co2IncreaseFactor,
                nh4IncreaseFactor, name);
        this.freshWater = false;
    }

    public boolean isFreshWater() {
        return freshWater;
    }

    public void setFreshWater(boolean freshWater) {
        this.freshWater = freshWater;
    }
}
