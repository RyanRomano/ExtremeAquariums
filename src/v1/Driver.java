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
        ArrayList<Fish> fishes = createFishList();
        ArrayList<TankComponent> tankComponents = createComponentList();
        TankGUI tankGUI = new TankGUI(tank, tankComponents,fishes);
    }

    public static ArrayList<TankComponent> createComponentList(){
        ArrayList<TankComponent> tankComponents = new ArrayList<>();
        TankComponent heater = new Heater();
        TankComponent filter = new Filter(40);
        TankComponent airPump = new Airpump(40);
        TankComponent decorationRock = new Decoration(10, "Rock");
        TankComponent seaWeedPlant = new LivePlant(10, "Sea Weed", 30, 20, 20);
        return tankComponents;
    }

    public static ArrayList<Fish> createFishList(){
        ArrayList<Fish> fishList = new ArrayList<>();
        Fish goldfish = new FreshwaterFish(10, 0, 0, 15, 15, 15);
        Fish betaFish = new FreshwaterFish(5, 2, 1, 20, 20, 20);
        Fish catFish = new FreshwaterFish(15, 1, 1, 25, 25, 25);
        Fish clownFish = new SaltwaterFish(5, 0, 0, 15, 15, 15);
        Fish pufferFish = new SaltwaterFish(10, 2, 1, 20, 20, 20);
        Fish sardineFish = new SaltwaterFish(15, 1, 0, 10, 10, 10);
        fishList.add(goldfish);
        fishList.add(betaFish);
        fishList.add(catFish);
        fishList.add(clownFish);
        fishList.add(pufferFish);
        fishList.add(sardineFish);
        return fishList;
    }
}
