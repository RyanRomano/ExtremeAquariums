package v1;

/**
 * Created by ryan on 11/8/16.
 */
public abstract class Fish implements Behavior{
    private int volume;
    private int aggressionLevel;
    private int swimmingLevel;
    private int o2DecreaseFactor;
    private int co2IncreaseFactor;
    private int nh4IncreaseFactor;

    public Fish(int volume, int aggressionLevel, int swimmingLevel, int o2DecreaseFactor, int co2IncreaseFactor,
                int nh4IncreaseFactor){
        this.volume = volume;
        this.aggressionLevel = aggressionLevel;
        this.swimmingLevel = swimmingLevel;
        this.o2DecreaseFactor = o2DecreaseFactor;
        this.co2IncreaseFactor = co2IncreaseFactor;
        this.nh4IncreaseFactor = nh4IncreaseFactor;
    }

    public void decreaseO2(){
        if (Water.o2 - this.o2DecreaseFactor >= Water.MIN_O2) {
            Water.o2 -= this.o2DecreaseFactor;
        }
        else {
            Water.o2 = Water.MIN_O2;
        }
    }

    public void increaseCO2() {
        if(Water.co2 + this.co2IncreaseFactor <= Water.MAX_CO2) {
            Water.co2 += this.co2IncreaseFactor;
        }
        else {
            Water.co2 = Water.MAX_CO2;
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

    public int getVolume() {
        return this.volume;
    }

    public void setAggressionLevel(int aggressionLevel){
        this.aggressionLevel = aggressionLevel;
    }

    public void setSwimmingLevel(int swimmingLevel){
        this.swimmingLevel = swimmingLevel;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getAggressionLevel() {
        return aggressionLevel;
    }

    public int getSwimmingLevel() {
        return swimmingLevel;
    }

    public int getO2DecreaseFactor() {
        return o2DecreaseFactor;
    }

    public void setO2DecreaseFactor(int o2DecreaseFactor) {
        this.o2DecreaseFactor = o2DecreaseFactor;
    }

    public int getCo2IncreaseFactor() {
        return co2IncreaseFactor;
    }

    public void setCo2IncreaseFactor(int co2IncreaseFactor) {
        this.co2IncreaseFactor = co2IncreaseFactor;
    }

    public int getNh4IncreaseFactor() {
        return nh4IncreaseFactor;
    }

    public void setNh4IncreaseFactor(int nh4IncreaseFactor) {
        this.nh4IncreaseFactor = nh4IncreaseFactor;
    }
}
