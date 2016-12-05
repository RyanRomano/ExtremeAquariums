package v2;
/**
 * Salt water fish subclass of Fish.
 * Contains all properties that salt water fish have.
 */
public class SaltwaterFish extends Fish {
    private boolean freshWater;

    /**
     * 7-argument constructor for Fresh water fish
     *
     * @param volume - size of fish from 0-10, 10 being largest, 0 being smallest.
     * @param aggressionLevel - number from 0-2 that represents how aggressive a fish is,
     * 								2 being most aggressive, 0 being the least.
     * @param swimmingLevel - number from 0-2 that represents where the fish likes to swim in the tank,
     * 								2 being the top of the tank, 0 being the bottom of the tank.
     * @param o2DecreaseFactor - number from 0-10 that represents how much a fish decreases the o2 in the tank,
     * 									10 being the highest decrease, 0 being no decrease.
     * @param co2IncreaseFactor - number from 0-10 that represents how much a fish increases the co2 in the tank,
     * 									10 being highest increase, 0 being no decrease.
     * @param nh4IncreaseFactor - number from 0-10 that represents how much a fish increases the nh4 in the tank,
     * 									10 being highest increase, 0 being no decrease.
     * @param name - String for the name of a fish.
     */
    public SaltwaterFish(int volume, int aggressionLevel, int swimmingLevel,
                         int o2DecreaseFactor, int co2IncreaseFactor, int nh4IncreaseFactor, String name){
        super(volume, aggressionLevel, swimmingLevel, o2DecreaseFactor, co2IncreaseFactor,
                nh4IncreaseFactor, name);
        this.freshWater = false;
    }
    /**
     * Boolean to test if fish belongs in fresh water or salt water
     * @return freshWater - if false fish belongs in salt water
     */
    public boolean isFreshWater() {
        return freshWater;
    }
    /**
     * Mutator method
     * Sets water type of fish
     * @param freshWater - if false fish belongs in salt water
     */
    public void setFreshWater(boolean freshWater) {
        this.freshWater = freshWater;
    }
}