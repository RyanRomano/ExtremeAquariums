package v1;

import java.util.ArrayList;

public class Tank {

    private int tankVolume;
    private int currentVolume;
    private ArrayList<Fish> fishList;
    private ArrayList<TankComponent> componentsList;
    private Water water;
    private boolean waterType;

    public Tank(int volume, boolean waterType){

        this.currentVolume = 0;
        this.tankVolume = volume;
        this.water = new Water(waterType);
        this.fishList = new ArrayList<Fish>();
        this.componentsList = new ArrayList<TankComponent>();

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
        return waterType;
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
        this.waterType = waterType;
    }

    public void setWater(Water water) {
        this.water = water;
    }

    //Other methods
//	public int checkCapacity(){
//
//	}

    public void addFish(Fish fish){

        if(fish.getSize() + currentVolume <= tankVolume){
            fishList.add(fish);
            currentVolume += fish.getSize();
        }else{
            //TODO tell user tank is full
        }

    }

    public void removeFish(Fish fish){
        if(fishList.contains(fish)){
            fishList.remove(fish);
            currentVolume -= fish.getSize();
        }else{
            //TODO tell user fish doesn't exist
        }

    }

    public void addComponent(TankComponent component){

        if(component.getVolume() + currentVolume <= tankVolume){
            componentsList.add(component);
            currentVolume += component.getVolume();
        }else{
            //TODO tell user tank is full
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