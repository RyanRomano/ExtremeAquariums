package v1;

import java.util.ArrayList;

public class Tank {

    private int tankVolume;
    private int currentVolume;
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


    //Getters
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


    //Setters
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

    //Other methods
//	public int checkCapacity(){
//
//	}

    public void addFish(Fish fish){
        boolean addFish = false;
        if (fishList.size() > 0) {
            for (Fish fishInList : fishList) {
//TODO FIGURE OUT THE BEHAVIOR COMBINATIONAL LOGIC

                //                if ((fish.getSwimmingLevel() == fishInList.getSwimmingLevel())
//                        && (fish.getAggressionLevel() == fishInList.getAggressionLevel())) {
//                    addFish = true;
//                }
//                else if (fish.getSwimmingLevel() != fishInList.getSwimmingLevel()) {
//                    addFish = true;
//                }
//                else {
//                    addFish = false;
//                }
            }
        }
        else {
            addFish = true;
        }

        if ((water.isFreshWater() && fish instanceof FreshwaterFish) || (!water.isFreshWater() && fish instanceof SaltwaterFish)
                && (addFish)) {

            if (Water.co2 + fish.getCo2IncreaseFactor() <= Water.MAX_CO2 &&
            Water.o2 - fish.getO2DecreaseFactor() >= Water.MIN_O2 &&
            Water.nh4 + fish.getNh4IncreaseFactor() <= Water.MAX_NH4) {
                if (fish.getVolume() + currentVolume <= tankVolume) {
                    fishList.add(fish);
                    fish.exchangeChemicals();
                    currentVolume+= fish.getVolume();
                }
                else {
                    //TODO tell user tank is full
                    System.out.println("TANK full");
                }
            }
            else {
                System.out.println("water levels funky");

            }
        }
        else {
            //TODO FISH AND TANK NOT SAME WATER TYPE THROW CUSTOM EXCEPTION MAYBE
            String FreshOrSalt;
            if(water.isFreshWater()){
                FreshOrSalt = "Fresh water";
            }
            else {
                FreshOrSalt = "Salt water";
            }
            System.out.println(fish.getClass().getSimpleName() + " fish being added to " + FreshOrSalt);
        }
    }

    public void removeFish(Fish fish){
        if(fishList.contains(fish)){
            fishList.remove(fish);
            currentVolume -= fish.getVolume();
            System.out.println("fish removed");
        }else{
            //TODO tell user fish doesn't exist
        }
    }

    public void addComponent(TankComponent component){

        if(component.getVolume() + currentVolume <= tankVolume){
            componentsList.add(component);
            currentVolume += component.getVolume();
        }else{
            System.out.println("Tank is full");
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