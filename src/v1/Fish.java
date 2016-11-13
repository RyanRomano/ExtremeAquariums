package v1;
public class Fish implements Behavior{
    private int volume;
    private int aggressionLevel;
    private int swimmingLevel;
    private int o2DecreaseFactor;
    private int co2IncreaseFactor;
    private int nh4IncreaseFactor;
    private String fishName;

    public Fish(int volume, int aggressionLevel, int swimmingLevel, int o2DecreaseFactor, int co2IncreaseFactor,
                int nh4IncreaseFactor, String fishName){
        this.volume = volume;
        this.aggressionLevel = aggressionLevel;
        this.swimmingLevel = swimmingLevel;
        this.o2DecreaseFactor = o2DecreaseFactor;
        this.co2IncreaseFactor = co2IncreaseFactor;
        this.nh4IncreaseFactor = nh4IncreaseFactor;
        this.fishName = fishName;
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public void exchangeChemicals(){
        Water.o2 -= this.o2DecreaseFactor;
        Water.co2 += this.co2IncreaseFactor;
        Water.nh4 += this.nh4IncreaseFactor;
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
