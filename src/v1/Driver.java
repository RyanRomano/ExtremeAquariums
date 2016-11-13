package v1;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by ryan on 11/8/16.
 */
public class Driver {
    public static void main(String[] args) {
        Tank tank = new Tank(100, true);
        ArrayList<Fish> fishList = new ArrayList<>();
        Fish goldfish = new FreshwaterFish(10, 0, 0, 15, 15, 15, "Goldfish");
        Fish betaFish = new FreshwaterFish(5, 2, 1, 20, 20, 20, "Betafish");
        Fish catFish = new FreshwaterFish(15, 2, 0, 25, 25, 25, "Catfish");
        Fish clownFish = new SaltwaterFish(5, 0, 0, 15, 15, 15, "Clownfish");
        Fish pufferFish = new SaltwaterFish(10, 2, 1, 20, 20, 20, "Pufferfish");
        Fish sardineFish = new SaltwaterFish(15, 1, 0, 10, 10, 10, "Sardine");
        tank.addFish(goldfish);
        tank.addFish(catFish);
        System.out.println(tank.getFishList().size());

//        tank.addFish(betaFish);
//        tank.addFish(goldfish);
//        tank.addFish(goldfish);
//        tank.addFish(clownFish);


//        tank.addComponent(new Decoration(20, "Rock0"));
//        System.out.println(" ::: Current Volume : " + tank.getCurrentVolume());
//        tank.addComponent(new Decoration(25, "Rock1"));
//        System.out.println(" ::: Current Volume : " + tank.getCurrentVolume());
//        tank.addComponent(new Decoration(25, "Rock2"));
        System.out.println(" ::: Current Volume : " + tank.getCurrentVolume());
        tank.addComponent(new Decoration(25, "Rock3"));
        System.out.println(" ::: Current Volume : " + tank.getCurrentVolume());


        for (TankComponent tC : tank.getComponentsList()) {
            System.out.println("Component volume : " + tC.getVolume());
        }

        TankGUI tankGUI = new TankGUI(tank, tank.getComponentsList(), tank.getFishList());
        System.out.println("nh4: " + Water.nh4 + "\no2: " + Water.o2 + "\nco2: " + Water.co2);
    }

//    public static ArrayList<TankComponent> createComponentList(){
//        ArrayList<TankComponent> tankComponents = new ArrayList<>();
//        TankComponent heater = new Heater();
//        tankComponents.add(heater);
//        TankComponent filter = new Filter(100);
//        tankComponents.add(filter);
//        TankComponent airPump = new Airpump(50);
//        tankComponents.add(airPump);
//        TankComponent decorationRock = new Decoration(10, "Rock");
//        tankComponents.add(decorationRock);
//        TankComponent seaWeedPlant = new LivePlant(10, "Sea Weed", 100, 70, 20);
//        tankComponents.add(seaWeedPlant);
//        return tankComponents;
//    }


}
