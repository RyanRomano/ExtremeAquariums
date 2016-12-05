package v2;
/**
 * Filter subclass of Tank Components that contains all filter items
 */
public class Filter extends TankComponent {

    private int nh4ReductionFactor;

    /**
     * 2-argument constructor for Filter
     * takes in an int for nh4 reduction factor &
     * a String for name
     * @param nh4ReductionFactor
     * @param name
     */
    public Filter(int nh4ReductionFactor, String name){
        super(5, name);
        this.nh4ReductionFactor = nh4ReductionFactor;
    }

    /**
     * Method to control & monitor nh4 levels in the tank.
     *
     * Uses if statements to check nh4 levels of the tank, so that the filter can run and
     * keep the nh4 levels in between the maximum and minimum required for fish to live safely
     */
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