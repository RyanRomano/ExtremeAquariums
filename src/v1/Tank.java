package v1;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;

public class Tank {

    private int tankVolume;
    private static int currentVolume;
    private ArrayList<Fish> fishList;
    private ArrayList<TankComponent> componentsList;
    private Water water;
    public Tank(int volume, boolean waterType){

        this.currentVolume = 0;
        this.tankVolume = volume;
        this.water = new Water(waterType);
        this.fishList = new ArrayList<>();
        this.componentsList = new ArrayList<>();
    }

    public int getTankVolume() {
        return tankVolume;
    }

    public ArrayList<Fish> getFishList() {
        return fishList;
    }

    public ArrayList<TankComponent> getComponentsList() {
        return componentsList;
    }

    public boolean isWaterType() {
        return water.isFreshWater();
    }

    public Water getWater() {
        return water;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int volume) {
        this.currentVolume = volume;
    }

    public void setTankVolume(int tankVolume) {
        this.tankVolume = tankVolume;
    }

    public void setFishList(ArrayList<Fish> fishList) {
        this.fishList = fishList;
    }

    public void setComponentsList(ArrayList<TankComponent> componentsList) {
        this.componentsList = componentsList;
    }

    public void setWaterType(boolean waterType) {
        this.water.setFreshWater(waterType);
    }

    public void setWater(Water water) {
        this.water = water;
    }

    public boolean addFish(Fish fish){
        if (checkRoomLeft(fish) && checkWaterCompatability(fish)
                && checkWaterChemicals(fish) && checkBehaviorCompatability(fish)){
            fishList.add(fish);
            this.currentVolume += fish.getVolume();
            Water.nh4 += fish.getNh4IncreaseFactor();
            Water.co2 += fish.getCo2IncreaseFactor();
            Water.o2 -= fish.getO2DecreaseFactor();
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkRoomLeft(Fish fish){
        if (fish.getVolume() + currentVolume <= this.tankVolume){
            return true;
        }
        else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Not enough space left in the tank.");
            return false;

        }
    }
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

    public void removeFish(Fish fish){
        if(fishList.contains(fish)){
            fishList.remove(fish);
            currentVolume -= fish.getVolume();
            Water.nh4 -= fish.getNh4IncreaseFactor();
            Water.co2 -= fish.getCo2IncreaseFactor();
            Water.o2 += fish.getO2DecreaseFactor();
        }else{
            //TODO tell user fish doesn't exist
        }
    }

    public void addComponent(TankComponent component){
        if(component.getVolume() + currentVolume <= tankVolume){
            componentsList.add(component);
            currentVolume += component.getVolume();
        }else{
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Not enough space left in the tank.");
        }
    }

    public void removeComponent(TankComponent component){
        if(componentsList.contains(component)){
            componentsList.remove(component);
            currentVolume -= component.getVolume();
        }else{
            //TODO tell user component doesn't exist
        }
    }

}