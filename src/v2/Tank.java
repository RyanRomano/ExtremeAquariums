package v2;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Tank class for the Extreme Aquarium Builder.
 * This class contains many variables & methods that control everything in the tank.
 * This includes keeping the chemicals balanced whenever tank components or fish are
 * added to the tank, keeping track of the volume of the tank to make sure it does not
 * exceed the maximum volume allowed, and making sure that fresh and salt water fish do
 * not get placed in a tank of the wrong water type.
 */
public class Tank {
    /**
     * Uses tank volume and current volume to make sure the current volume does not exceed the tank volume,
     * contains 2 array lists one for Fish and the other for Tank Components,
     * contains water to check the water type of the tank.
     */
    private int tankVolume;
    private static int currentVolume;
    private ArrayList<Fish> fishList;
    private ArrayList<TankComponent> componentsList;
    private Water water;

    /**
     * 2-argument constructor for Tank.
     * takes in an int for the volume of the tank &
     * a boolean for the water type of the tank.
     *
     * Sets currentVolume to 0,
     * water to a new Water object with a waterType parameter
     * fishList to an array list
     * componentsList to an array list
     *
     * @param volume
     * @param waterType
     */
    public Tank(int volume, boolean waterType){
        this.currentVolume = 0;
        this.tankVolume = volume;
        this.water = new Water(waterType);
        this.fishList = new ArrayList<>();
        this.componentsList = new ArrayList<>();
    }
    /**
     * Accessor method.
     * Gets the volume of the tank.
     * @return tankVolume
     */
    public int getTankVolume() {
        return tankVolume;
    }
    /**
     * Accessor method.
     * Gets the array list of fish in the tank.
     * @return fishList
     */
    public ArrayList<Fish> getFishList() {
        return fishList;
    }
    /**
     * Accessor method.
     * Gets the array list of tank components in the tank.
     * @return componentList
     */
    public ArrayList<TankComponent> getComponentsList() {
        return componentsList;
    }
    /**
     * isWaterType method
     * @return water.isFreshWater();
     * boolean checks if water isFreshwater
     * if true - fresh water,
     * if false - saltwater
     */
    public boolean isWaterType() {
        return water.isFreshWater();
    }
    /**
     * Accessor method.
     * Gets the water of the tank.
     * @return water
     */
    public Water getWater() {
        return water;
    }
    /**
     * Accessor method.
     * Gets the current volume of the tank.
     * @return currentVolume
     */
    public int getCurrentVolume() {
        return currentVolume;
    }
    /**
     * Mutator method.
     * Sets the current volume of the tank.
     * @param volume
     */
    public void setCurrentVolume(int volume) {
        this.currentVolume = volume;
    }
    /**
     * Mutator method.
     * Sets the volume of the tank.
     * @param tankVolume
     */
    public void setTankVolume(int tankVolume) {
        this.tankVolume = tankVolume;
    }
    /**
     * Mutator method.
     * Sets the fish list of the tank.
     * @param fishList
     */
    public void setFishList(ArrayList<Fish> fishList) {
        this.fishList = fishList;
    }
    /**
     * Mutator method.
     * Sets the component list of the tank.
     * @param componentsList
     */
    public void setComponentsList(ArrayList<TankComponent> componentsList) {
        this.componentsList = componentsList;
    }
    /**
     * Mutator method.
     * Sets the water type of the tank.
     * @param waterType
     */
    public void setWaterType(boolean waterType) {
        this.water.setFreshWater(waterType);
    }
    /**
     * Mutator method.
     * Sets the water of the tank.
     * @param water
     */

    public void setWater(Water water) {
        this.water = water;
    }
    /**
     * Method for addFish.
     * Boolean that uses an if statement to make sure that when a fish is added to the tank
     * the volume remaining in the tank, the water type, the chemical levels, the behavior,
     * and the pH levels are all ideal and the fish can be safely added to the tank.
     * @param fish
     * @return boolean true - if fish can be added without a problem and all levels add up correctly.
     * @return boolean false - if the fish cannot be added because of an issue with one of the factors in the tank.
     */
    public boolean addFish(Fish fish){
        if (checkRoomLeft(fish) && checkWaterCompatability(fish)
                && checkWaterChemicals(fish) && checkBehaviorCompatability(fish) && checkPH(fish)){
            fishList.add(fish);
            this.currentVolume += fish.getVolume();
            Water.nh4 += fish.getNh4IncreaseFactor();
            Water.co2 += fish.getCo2IncreaseFactor();
            Water.o2 -= fish.getO2DecreaseFactor();
            Water.pH += fish.getpHIncreaseFactor();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Method for checkPH.
     * Boolean that uses an if statement to make sure that the fish's pH increase factor
     * does not exceed the maximum pH for the tank,
     * then it adds the pH of the water with the fish's pH increase factor.
     * @param fish
     * @return boolean true - if fish can be added without exceeding the maximum pH of the tank.
     * @return boolean false - if fish cannot be added
     */
    public boolean checkPH(Fish fish){
        if (Water.pH + fish.getpHIncreaseFactor() <= Water.MAX_PH){
            return true;
        }
        else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "pH level too high.");
            return false;
        }
    }

    /**
     * Method for checkRoomLeft.
     * Boolean that uses an if statement to check that there is enough room
     * available in the tank to add the fish selected.
     * @param fish
     * @return boolean true - if volume of fish + volume of tank does not exceed the tanks volume.
     * @return boolean false - if the fish cannot be added, display JOptionPane: "Not enough space left in the tank."
     */
    public boolean checkRoomLeft(Fish fish){
        if (fish.getVolume() + currentVolume <= this.tankVolume){
            return true;
        }
        else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Not enough space left in the tank.");
            return false;
        }
    }

    /**
     * Method for checkWaterCompatability.
     * Uses booleans and if statements along with isCompatable to make sure that
     * a fresh water fish is added to a fresh water tank &
     * a salt water fish is added to a salt water tank.
     * If they do not match then a JOptionPane is displayed: "Fish incompatible with water type."
     * @param fish
     * @return boolean isCompatable
     */
    public boolean checkWaterCompatability(Fish fish){
        boolean isCompatible = false;
        if (fish instanceof FreshwaterFish && water.isFreshWater()){
            isCompatible = true;
        }
        else if (fish instanceof SaltwaterFish && !water.isFreshWater()){
            isCompatible = true;
        }
        else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Fish incompatible with water type.");
        }
        return isCompatible;
    }
    /**
     * Method for checkWaterChemicals.
     * Uses an if statement to make sure that the fish added does not
     * exceed the maximum nh4 & co2 levels and does not go below the minimum o2 level.
     * @param fish
     * @return boolean true - if fish does not violate any max or min for chemicals
     * @return boolean false - if fish violates max or min chemical levels,
     * 							display JOptionPane: "Water chemicals out of balance."
     */
    public boolean checkWaterChemicals(Fish fish){
        int nh4 = fish.getNh4IncreaseFactor();
        int co2 = fish.getCo2IncreaseFactor();
        int o2 = fish.getO2DecreaseFactor();
        if ((nh4 + Water.nh4 <= Water.MAX_NH4) &&
                (co2 + Water.co2 <= Water.MAX_CO2) &&
                (Water.o2 - o2 > Water.MIN_O2)){
            return true;
        }
        else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Water chemicals out of balance.");

            return false;

        }
    }
    /**
     * Method for checkBehaviorCompatability.
     * Uses if and for statements along with compatible to make sure that
     * fish in the same swimming level do not have very high aggression levels.
     *
     * if compatible is true - fish in the same swimming lvl are not very aggressive and they get along.
     * if compatible is false - fish in same swimming lvl are very aggressive and do not get along,
     * 								display JOptionPane: "Incompatible behavior type."
     * @param fish
     * @return compatible
     */
    public boolean checkBehaviorCompatability(Fish fish){
        boolean compatible = false;
        if (!fishList.isEmpty()) {
            for (Fish fishAlreadyInTank : fishList) {
                if (fishAlreadyInTank.getSwimmingLevel() == fish.getSwimmingLevel()) {
                    if (fishAlreadyInTank.getAggressionLevel() == fish.getAggressionLevel()) {
                        compatible = true;
                    } else {
                        compatible = false;
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Incompatible behavior type.");
                        break;
                    }
                }
                else {
                    compatible = true;
                }
            }
        }
        else {
            compatible = true;
        }
        return compatible;
    }
    /**
     * Method for removeFish.
     * If the fish list has a fish and it is removed from that list,
     * then the volume, nh4, co2, & pH levels must be subtracted from
     * the current tank and the o2 levels must be added back to the tank.
     *
     * If the fish list does not contain that fish, display JOptionPane: "That fish is not in the tank."
     * @param fish
     */
    public void removeFish(Fish fish){
        if(fishList.contains(fish)){
            fishList.remove(fish);
            currentVolume -= fish.getVolume();
            Water.nh4 -= fish.getNh4IncreaseFactor();
            Water.co2 -= fish.getCo2IncreaseFactor();
            Water.o2 += fish.getO2DecreaseFactor();
            Water.pH -= fish.getpHIncreaseFactor();
        }
    }
    /**
     * Method for addComponent.
     * Uses an if statement to check if the added components volume +
     * the current volume of the tank does not exceed the tanks volume limit.
     *
     * If there the volume exceeds the limit, display JOptionPane: "Not enough space left in the tank."
     *
     * @param component
     */
    public void addComponent(TankComponent component){
        if(component.getVolume() + currentVolume <= tankVolume){
            componentsList.add(component);
            currentVolume += component.getVolume();
        }else{
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Not enough space left in the tank.");
        }
    }
    /**
     * Method for removeComponent
     * If the components list has a component and it is removed from that list,
     * then the component's volume must be subtracted from the current tank volume.
     *
     * If the components list does not contain that component, display JOptionPane: "That component is not in the tank."
     *
     * * @param TankComponent component
     */
    public void removeComponent(TankComponent component){
        if(componentsList.contains(component)){
            componentsList.remove(component);
            currentVolume -= component.getVolume();
        }
    }
}