package v2;
/**
 * Live Plant is a subclass of Tank Component that
 * contains all properties of a live plant &
 * the affect it has on the tanks environment
 */

public class LivePlant extends TankComponent {
    private String plantName;
    private int o2IncreaseFactor;
    private int co2DecreaseFactor;
    private int nh4IncreaseFactor;
    private int hardnessIncreaseFactor;
    /**
     * 5-argument constructor for live plant
     *
     * @param volume - space taken up by the live plant
     * @param plantName - name of the plant put into the tank
     * @param o2IncreaseFactor - measure of how much the o2 levels will increase once a live plant is put into the tank
     * @param co2DecreaseFactor - measure of how much the co2 levels will decrease once a live plant is put into the tank
     * @param nh4IncreaseFactor - measure of how much the nh4 levels will increase once a live plant is put into the tank
     *
     * hardnessIncreaseFactor set to = 10
     */
    public LivePlant(int volume, String plantName, int o2IncreaseFactor, int co2DecreaseFactor,
                     int nh4IncreaseFactor){
        super(volume,plantName);
        this.o2IncreaseFactor = o2IncreaseFactor;
        this.co2DecreaseFactor = co2DecreaseFactor;
        this.nh4IncreaseFactor = nh4IncreaseFactor;
        this.plantName = plantName;
        this.hardnessIncreaseFactor = 10;
    }
    /**
     * Accessor mehtod
     * Gets name of the plant added to the tank
     * @return plantName
     */
    public String getPlantName() {
        return plantName;
    }
    /**
     * Mutator method
     * Sets name of plant added to the tank
     * takes in a String for the plant name
     * @param plantName
     */
    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }
    /**
     * Accessor Method
     * Gets the o2 increase factor for a plant
     * @return o2IncreaseFactor
     */
    public int getO2IncreaseFactor() {
        return o2IncreaseFactor;
    }
    /**
     * Mutator method
     * Sets the o2 increase factor for a plant
     * takes in an int for 02 increase factor
     * @param  o2IncreaseFactor
     */
    public void setO2IncreaseFactor(int o2IncreaseFactor) {
        this.o2IncreaseFactor = o2IncreaseFactor;
    }
    /**
     * Accessor method
     * Get co2 decrease factor for a plant
     * @return co2DecreaseFactor
     */
    public int getCo2DecreaseFactor() {
        return co2DecreaseFactor;
    }
    /**
     * Mutator method
     * Sets the co2 decrease factor for a plant
     * takes in an int for co2 decrease factor
     * @param co2DecreaseFactor
     */
    public void setCo2DecreaseFactor(int co2DecreaseFactor) {
        this.co2DecreaseFactor = co2DecreaseFactor;
    }
    /**
     * Accessor method
     * Gets nh4 increase factor for a plant
     * @return nh4IncreaseFactor
     */
    public int getNh4IncreaseFactor() {
        return nh4IncreaseFactor;
    }
    /**
     * Mutator method
     * Sets the nh4 increase factor for a plant
     * takes in an int for nh4 increase factor
     * @param nh4IncreaseFactor
     */
    public void setNh4IncreaseFactor(int nh4IncreaseFactor) {
        this.nh4IncreaseFactor = nh4IncreaseFactor;
    }
    /**
     * Accessor method
     * Gets the hardness increase factor for a plant
     * @return hardnessIncreaseFactor
     */
    public int getHardnessIncreaseFactor() {
        return hardnessIncreaseFactor;
    }
    /**
     * Mutator method
     * Sets the hardness increase factor for a plant
     * takes in an int for hardness increase factor
     * @param int hardnessIncreaseFactor
     */
    public void setHardnessIncreaseFactor(int hardnessIncreaseFactor) {
        this.hardnessIncreaseFactor = hardnessIncreaseFactor;
    }
    /**
     * Method for increasing o2
     * Uses an if statement to make sure the tanks o2 level does not
     * go above the maximum o2 level when a plant is added to the tank.
     * If o2 lvl goes above max, then the plant cannot be added
     * if o2 lvl is below the max, then the plant can be added &
     * the plants o2 increase factor is added to the current o2 lvl in the water.
     */
    public void increaseO2(){
        if (Water.o2 + this.o2IncreaseFactor <= Water.MAX_O2) {
            Water.o2 += this.o2IncreaseFactor;
        }
        else {
            Water.o2 = Water.MAX_O2;
        }
    }
    /**
     * Method for decreasing co2
     * Uses an if statement to make sure the tanks co2 lvl does not
     * go below the minimum co2 lvl when a plant is added to the tank.
     * If co2 lvl goes below the minimum, then the plant cannot be added
     * if co2 lvl is above the minimum, then the plant can be added &
     * the plants co2 decrease factor is subtracted from the current co2 lvl in the water.
     */
    public void decreaseCO2() {
        if(Water.co2 - this.co2DecreaseFactor >= Water.MIN_CO2) {
            Water.co2 -= this.co2DecreaseFactor;
        }
        else {
            Water.co2 = Water.MIN_CO2;
        }
    }
    /**
     * Method for increasing nh4
     * Uses an if statement to make sure the tanks nh4 lvl does not
     * go above the maximum nh4 lvl when a plant is added to the tank.
     * If nh4 lvl goes above max, then the plant cannot be added
     * if nh4 lvl is below the max, then the plant can be added &
     * the plants nh4 increase factor is added to the current nh4 lvl in the water.
     */
    public void increaseNH4() {
        if (Water.nh4 + this.nh4IncreaseFactor <= Water.MAX_NH4) {
            Water.nh4 += this.nh4IncreaseFactor;
        }
        else {
            Water.nh4 = Water.MAX_NH4;
        }
    }
    /**
     * Method for increasing hardness
     * Adds hardness lvl to the current hardness lvl in the water
     */
    public void increaseHardness(){
        Water.hardness += this.getHardnessIncreaseFactor();
    }
    /**
     * Method to show the affect a live plant has on the tank envirnoment when added
     * Uses if statements to properly add or subtract gas/chemical lvls
     * of the water when a live plant is added to the tank.
     */
    @Override
    public void affectEnvironment(boolean isAdded) {
        if (isAdded) {
            increaseO2();
            increaseNH4();
            decreaseCO2();
            increaseHardness();
        }
        else {
            if(Water.hardness - this.hardnessIncreaseFactor >= Water.MIN_HARDNESS){
                Water.hardness -= this.hardnessIncreaseFactor;
            }
            else {
                Water.hardness = Water.MIN_HARDNESS;
            }

            if (Water.o2 - this.o2IncreaseFactor >= Water.MIN_O2) {
                Water.o2 -= this.o2IncreaseFactor;
            }
            else {
                Water.o2 = Water.MIN_O2;
            }

            if (Water.nh4 - this.nh4IncreaseFactor >= Water.MIN_NH4) {
                Water.nh4 -= this.nh4IncreaseFactor;
            }
            else {
                Water.nh4 = Water.MIN_NH4;
            }

            if(Water.co2 + this.co2DecreaseFactor <= Water.MAX_CO2) {
                Water.co2 += this.co2DecreaseFactor;
            }
            else {
                Water.co2 = Water.MAX_CO2;
            }
        }
    }
}