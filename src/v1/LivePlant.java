package v1;

import javax.swing.*;

/**
 * Created by ryan on 11/8/16.
 */
//
public class LivePlant extends TankComponent {
    private String plantName;
    private int o2IncreaseFactor;
    private int co2DecreaseFactor;
    private int nh4IncreaseFactor;

    public LivePlant(int volume, String plantName, int o2IncreaseFactor, int co2DecreaseFactor,
                     int nh4IncreaseFactor){
        super(volume);
        this.o2IncreaseFactor = o2IncreaseFactor;
        this.co2DecreaseFactor = co2DecreaseFactor;
        this.nh4IncreaseFactor = nh4IncreaseFactor;
        this.plantName = plantName;
        increaseO2();
        decreaseCO2();
        increaseNH4();
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
}
