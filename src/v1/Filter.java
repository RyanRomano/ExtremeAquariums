package v1;

import java.awt.*;

/**
 * Created by ryan on 11/8/16.
 */
public class Filter extends TankComponent {

    private int nh4ReductionFactor;

    public Filter(int nh4ReductionFactor, String name){
        super(1, name);
        this.nh4ReductionFactor = nh4ReductionFactor;
    }

    public void affectEnvironment(boolean isAdded){
        if (isAdded) {
            if (Water.nh4 - nh4ReductionFactor >= Water.MIN_NH4) {
                Water.nh4 -= nh4ReductionFactor;
            } else {
                Water.nh4 = Water.MIN_NH4;
            }
        }
        else {
            if (Water.nh4 + nh4ReductionFactor <= Water.MAX_NH4) {
                Water.nh4 += nh4ReductionFactor;
            } else {
                Water.nh4 = Water.MAX_NH4;
            }
        }
    }
}
