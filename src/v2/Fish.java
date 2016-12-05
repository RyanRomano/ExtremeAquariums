package v2;
/**
 * Abstract Fish class thats contains all properties of Fish
 * including volume, aggression level, swimming level, o2 decrease factor,
 * co2 increase factor, nh4 increase factor, pH increase factor, & fish name
 */
public abstract class Fish implements Behavior{
    private int volume;
    private int aggressionLevel;
    private int swimmingLevel;
    private int o2DecreaseFactor;
    private int co2IncreaseFactor;
    private int nh4IncreaseFactor;
    private int pHIncreaseFactor;
    private String fishName;

    /**
     * 7-argument constructor for Fish class
     * contains all properties that fish have
     * also sets pHIncreaseFactor to 1
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
     * @param fishName - String for the name of a fish.
     */
    public Fish(int volume, int aggressionLevel, int swimmingLevel, int o2DecreaseFactor, int co2IncreaseFactor,
                int nh4IncreaseFactor, String fishName){
        this.volume = volume;
        this.aggressionLevel = aggressionLevel;
        this.swimmingLevel = swimmingLevel;
        this.o2DecreaseFactor = o2DecreaseFactor;
        this.co2IncreaseFactor = co2IncreaseFactor;
        this.nh4IncreaseFactor = nh4IncreaseFactor;
        this.fishName = fishName;
        this.pHIncreaseFactor = 1;
    }
    /**
     * Accessor method.
     * Gets pH increase factor for a fish.
     * @return pHIncreaseFactor
     */
    public int getpHIncreaseFactor() {
        return pHIncreaseFactor;
    }
    /**
     * Mutator method.
     * Sets pH increase factor for a fish.
     * @param pHIncreaseFactor
     */
    public void setpHIncreaseFactor(int pHIncreaseFactor) {
        this.pHIncreaseFactor = pHIncreaseFactor;
    }
    /**
     * Accessor method.
     * Gets name of fish species.
     * @return fishName
     */
    public String getFishName() {
        return fishName;
    }
    /**
     * Mutator method.
     * Sets name of fish species.
     * @param fishName
     */
    public void setFishName(String fishName) {
        this.fishName = fishName;
    }
    /**
     * Method for exchanging chemicals so that
     * tank conditions remain ideal for the fish
     * Sets o2 to decrease because fish take in o2
     * Sets co2 & nh4 to increase because fish let out co2 & nh4
     */
    public void exchangeChemicals(){
        Water.o2 -= this.o2DecreaseFactor;
        Water.co2 += this.co2IncreaseFactor;
        Water.nh4 += this.nh4IncreaseFactor;
    }
    /**
     * Accessor method.
     * Gets the volume of a fish
     * @return this.volume
     */
    public int getVolume() {
        return this.volume;
    }
    /**
     * Mutator method.
     * Sets aggression level of a fish.
     * @param aggressionLevel
     */
    public void setAggressionLevel(int aggressionLevel){
        this.aggressionLevel = aggressionLevel;
    }
    /**
     * Mutator method.
     * Sets swimming level of a fish
     * @param swimmingLevel
     */
    public void setSwimmingLevel(int swimmingLevel){
        this.swimmingLevel = swimmingLevel;
    }
    /**
     * Mutator method.
     * Sets the volume of a fish
     * @param volume
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }
    /**
     * Accessor method.
     * Gets the aggression level of a fish.
     * @return aggressionLevel
     */
    public int getAggressionLevel() {
        return aggressionLevel;
    }
    /**
     * Accessor method.
     * Gets the swimming level of a fish.
     * @return swimmingLevel
     */
    public int getSwimmingLevel() {
        return swimmingLevel;
    }
    /**
     * Accessor method.
     * Gets the o2 decrease factor for a fish.
     * @return o2DecreaseFactor
     */
    public int getO2DecreaseFactor() {
        return o2DecreaseFactor;
    }
    /**
     * Mutator method.
     * Sets the o2 decrease factor for a fish.
     * @param o2DecreaseFactor
     */
    public void setO2DecreaseFactor(int o2DecreaseFactor) {
        this.o2DecreaseFactor = o2DecreaseFactor;
    }
    /**
     * Accessor method.
     * Gets the co2 increase factor for a fish.
     * @return co2IncreaseFactor
     */
    public int getCo2IncreaseFactor() {
        return co2IncreaseFactor;
    }
    /**
     * Mutator method.
     * Sets the co2 increase factor for a fish
     * @param co2IncreaseFactor
     */
    public void setCo2IncreaseFactor(int co2IncreaseFactor) {
        this.co2IncreaseFactor = co2IncreaseFactor;
    }
    /**
     * Accessor method.
     * Gets the nh4 increase factor for a fish
     * @return nh4IncreaseFactor
     */
    public int getNh4IncreaseFactor() {
        return nh4IncreaseFactor;
    }
    /**
     * Mutator method.
     * Sets the nh4 increase factor for a fish
     * @param nh4IncreaseFactor
     */
    public void setNh4IncreaseFactor(int nh4IncreaseFactor) {
        this.nh4IncreaseFactor = nh4IncreaseFactor;
    }
}