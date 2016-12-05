package v2;
/**
 * Air pump is a subclass of Tank Component
 * Contains method that controls oxygen level
 * based on the tank conditions
 */
public class Airpump extends TankComponent {
    private int o2IncreaseFactor;
    /**
     * 2-argument constructor for Air pump
     * takes an int for o2 increase factor &
     * a String for the name.
     * Also, calls the superclass.
     *
     * @param o2IncreaseFactor
     * @param name
     */
    public Airpump(int o2IncreaseFactor, String name){
        super(5, name);
        this.o2IncreaseFactor = o2IncreaseFactor;
    }

    /**
     * Method to control the the o2 in the water when an air pump is added to the tank.
     *
     * If the airpump is added to the tank and the o2 level in the water + the o2 increase factor
     * of the airpump is less than the maximum o2 for the tank, then the airpump can be added.
     *
     * If the airpump is removed from the tank and the o2 level in the water - the o2 increase factor
     * of the airpump is greater than the minimum o2 for the tank, then the airpump can be removed.
     */
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