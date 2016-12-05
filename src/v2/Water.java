package v2;
/**
 * Water class that contains everything that
 * needs to be controlled in the water of the tank.
 * Constants are also made for the minimum and maximum
 * temperature, o2, co2, nh4, pH, and hardness.
 */

public class Water {
    private boolean freshWater;
    public static final int MAX_TEMPERATURE = 85;
    public static final int MIN_TEMPERATURE = 70;
    public static final int MAX_CO2 = 100;
    public static final int MIN_CO2 = 0;
    public static final int MAX_O2 = 100;
    public static final int MIN_O2 = 0;
    public static final int MAX_NH4 = 100;
    public static final int MIN_NH4 = 0;
    public static final int MAX_PH = 14;
    public static final int MIN_PH = 0;
    public static final int MAX_HARDNESS = 100;
    public static final int MIN_HARDNESS = 0;

    public static int temperature;
    public static int co2;
    public static int o2;
    public static int nh4;
    public static int pH;
    public static int hardness;

    /**
     * 1-argument constructor
     * takes in a boolean for fresh water
     * @param freshWater - tank is fresh water if true, salt water if false
     * Also sets temperature, co2, o2, nh4, pH, and hardness for fresh water tanks.
     */
    public Water(boolean freshWater){
        this.freshWater = freshWater;
        this.temperature = 75;
        this.co2 = 50;
        this.o2 = 50;
        this.nh4 = 50;
        this.pH = 7;
        this.hardness = 50;
    }
    /**
     * isFreshWater method to check if
     * water in tank is fresh water or salt water
     * @return freshWater
     */
    public boolean isFreshWater() {
        return freshWater;
    }
    /**
     * Mutator method
     * Sets tank to fresh water if true
     * @param freshWater
     */
    public void setFreshWater(boolean freshWater) {
        this.freshWater = freshWater;
    }
    /**
     * Accessor method
     * Gets the temperature of the fish tank
     * @return temperature
     */
    public static int getTemperature() {
        return temperature;
    }
    /**
     * Mutator method
     * Sets temperature of the tank.
     * Uses an if statement to make sure the tank
     * does not exceed the maximum or go below the minimum temperature,
     * so that fish can survive
     * @param temperature
     */
    public static void setTemperature(int temperature) {
        if (temperature <= MAX_TEMPERATURE && temperature >= MIN_TEMPERATURE) {
            Water.temperature = temperature;
        }
    }
    /**
     * Accessor method
     * Gets the co2 level of the tank
     * @return co2
     */
    public static int getCo2() {
        return co2;
    }
    /**
     * Mutator method
     * Sets the co2 level of the tank
     * @param co2
     */
    public static void setCo2(int co2) {
        if ( co2 <= MAX_CO2 && co2 >= MIN_CO2) {
            Water.co2 = co2;
        }
    }
    /**
     * Accessor method
     * Gets the o2 level of the tank
     * @return o2
     */
    public static int getO2() {
        return o2;
    }
    /**
     * Mutator method
     * Sets the o2 level of the tank.
     * Uses an if statement to control the o2 levels in the tank,
     * ensures that the tank does not exceed the maximum or
     * go below the minimum o2 levels so the fish can live safely.
     * @param o2
     */
    public static void setO2(int o2) {
        if (o2 <= MAX_O2 && o2 >= MIN_O2){
            Water.o2 = o2;
        }
    }
    /**
     * Accessor method
     * Gets the nh4 level of the tank
     * @return nh4
     */
    public static int getNh4() {
        return nh4;
    }
    /**
     * Mutator method
     * Sets the nh4 level of the tank.
     * Uses an if statement to control the nh4 levels in the tank
     * to make sure the tank does not exceed the maximum or minimum nh4
     * that the tank requires for the fish to live safely.
     * @param nh4
     */
    public static void setNh4(int nh4) {
        if (nh4 <= MAX_NH4 && nh4 >= MIN_NH4) {
            Water.nh4 = nh4;
        }
    }
    /**
     * Accessor method
     * Gets the pH level of the fish tank.
     * @return pH
     */
    public static int getpH() {
        return pH;
    }
    /**
     * Mutator method
     * Sets the pH level of the fish tank.
     * Uses an if statement to control the pH levels of the tank,
     * ensures that the pH does not go over the maximum or
     * go below the minimum pH level required so that the fish can live safely.
     * @param pH
     */
    public static void setpH(int pH) {
        if (pH <= MAX_PH && pH >= MIN_PH) {
            Water.pH = pH;
        }
    }
    /**
     * Accessor method
     * Gets the hardness level of the tank.
     * @return hardness
     */
    public static int getHardness() {
        return hardness;
    }
    /**
     * Mutator method
     * Sets the hardness level of the fish tank.
     * Uses an if statement to control the hardness levels in the tank,
     * ensures that the hardness level does not go above the maximum or
     * go below the minimum level required for fish to live safely.
     * @param hardness
     */
    public static void setHardness(int hardness) {
        if (hardness <= MAX_HARDNESS && hardness >= MIN_HARDNESS) {
            Water.hardness = hardness;
        }
    }
}