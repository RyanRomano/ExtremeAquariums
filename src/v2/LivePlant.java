package v2;
/**
 * Created by ryan on 11/8/16.
 */

public class LivePlant extends TankComponent {
    private String plantName;
    private int o2IncreaseFactor;
    private int co2DecreaseFactor;
    private int nh4IncreaseFactor;
    private int hardnessIncreaseFactor;

    public LivePlant(int volume, String plantName, int o2IncreaseFactor, int co2DecreaseFactor,
                     int nh4IncreaseFactor){
        super(volume,plantName);
        this.o2IncreaseFactor = o2IncreaseFactor;
        this.co2DecreaseFactor = co2DecreaseFactor;
        this.nh4IncreaseFactor = nh4IncreaseFactor;
        this.plantName = plantName;
        this.hardnessIncreaseFactor = 10;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public int getO2IncreaseFactor() {
        return o2IncreaseFactor;
    }

    public void setO2IncreaseFactor(int o2IncreaseFactor) {
        this.o2IncreaseFactor = o2IncreaseFactor;
    }

    public int getCo2DecreaseFactor() {
        return co2DecreaseFactor;
    }

    public void setCo2DecreaseFactor(int co2DecreaseFactor) {
        this.co2DecreaseFactor = co2DecreaseFactor;
    }

    public int getNh4IncreaseFactor() {
        return nh4IncreaseFactor;
    }

    public void setNh4IncreaseFactor(int nh4IncreaseFactor) {
        this.nh4IncreaseFactor = nh4IncreaseFactor;
    }

    public int getHardnessIncreaseFactor() {
        return hardnessIncreaseFactor;
    }

    public void setHardnessIncreaseFactor(int hardnessIncreaseFactor) {
        this.hardnessIncreaseFactor = hardnessIncreaseFactor;
    }

    public void increaseO2(){
        if (Water.o2 + this.o2IncreaseFactor <= Water.MAX_O2) {
            Water.o2 += this.o2IncreaseFactor;
        }
        else {
            Water.o2 = Water.MAX_O2;
        }
    }

    public void decreaseCO2() {
        if(Water.co2 - this.co2DecreaseFactor >= Water.MIN_CO2) {
            Water.co2 -= this.co2DecreaseFactor;
        }
        else {
            Water.co2 = Water.MIN_CO2;
        }
    }

    public void increaseNH4() {
        if (Water.nh4 + this.nh4IncreaseFactor <= Water.MAX_NH4) {
            Water.nh4 += this.nh4IncreaseFactor;
        }
        else {
            Water.nh4 = Water.MAX_NH4;
        }
    }

    public void increaseHardness(){
        Water.hardness += this.getHardnessIncreaseFactor();
    }

    @Override
    public void affectEnvironment(boolean isAdded) {
        if (isAdded) {
            increaseO2();
            increaseNH4();
            decreaseCO2();
            increaseHardness();
        }
        else {
            if(Water.hardness + this.hardnessIncreaseFactor <= Water.MAX_HARDNESS){
                Water.hardness += this.hardnessIncreaseFactor;
            }
            else {
                Water.hardness = Water.MAX_HARDNESS;
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
