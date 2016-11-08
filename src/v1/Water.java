package v1;

/**
 * Created by ryan on 11/8/16.
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

    public Water(boolean freshWater){
        this.freshWater = freshWater;
        this.temperature = 75;
        this.co2 = 50;
        this.o2 = 50;
        this.nh4 = 50;
        this.pH = 7;
        this.hardness = 50;
    }

    public boolean isFreshWater() {
        return freshWater;
    }

    public void setFreshWater(boolean freshWater) {
        this.freshWater = freshWater;
    }

    public static int getTemperature() {
        return temperature;
    }

    public static void setTemperature(int temperature) {
        if (temperature <= MAX_TEMPERATURE && temperature >= MIN_TEMPERATURE) {
            Water.temperature = temperature;
        }
    }

    public static int getCo2() {
        return co2;
    }

    public static void setCo2(int co2) {
        if ( co2 <= MAX_CO2 && co2 >= MIN_CO2) {
            Water.co2 = co2;
        }
    }

    public static int getO2() {
        return o2;
    }

    public static void setO2(int o2) {
        if (o2 <= MAX_O2 && o2 >= MIN_O2){
            Water.o2 = o2;
        }
    }

    public static int getNh4() {
        return nh4;
    }

    public static void setNh4(int nh4) {
        if (nh4 <= MAX_NH4 && nh4 >= MIN_NH4) {
            Water.nh4 = nh4;
        }
    }

    public static int getpH() {
        return pH;
    }

    public static void setpH(int pH) {
        if (pH <= MAX_PH && pH >= MIN_PH) {
            Water.pH = pH;
        }
    }

    public static int getHardness() {
        return hardness;
    }

    public static void setHardness(int hardness) {
        if (hardness <= MAX_HARDNESS && hardness >= MIN_HARDNESS) {
            Water.hardness = hardness;
        }
    }
}
