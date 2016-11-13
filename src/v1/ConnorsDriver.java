package v1;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by ryan on 11/8/16.
 */
public class ConnorsDriver {
    public static void main(String[] args) {
        Tank tank = new Tank(100, true);
        ArrayList<Fish> fishes = createFishList();
        ArrayList<TankComponent> tankComponents = createComponentList();
        TankGUI tankGUI = new TankGUI(tank, tankComponents,fishes);
    }

    public static ArrayList<TankComponent> createComponentList(){
        ArrayList<TankComponent> tankComponents = new ArrayList<>();
        TankComponent heater = new Heater("Average Heater");
        TankComponent filter = new Filter(40, "Average Filter");
        TankComponent airPump = new Airpump(40, "Average Airpump");
        TankComponent decorationRock = new Decoration(10, "Rock");
        TankComponent seaWeedPlant = new LivePlant(10, "Sea Weed", 30, 20, 20);
        tankComponents.add(heater);
        tankComponents.add(filter);
        tankComponents.add(airPump);
        tankComponents.add(decorationRock);
        tankComponents.add(seaWeedPlant);
        tankComponents.add(heater);
        tankComponents.add(filter);
        tankComponents.add(airPump);
        tankComponents.add(decorationRock);
        tankComponents.add(seaWeedPlant);
        tankComponents.add(heater);
        tankComponents.add(filter);
        tankComponents.add(airPump);
        tankComponents.add(decorationRock);
        tankComponents.add(seaWeedPlant);

        return tankComponents;
    }

    public static ArrayList<Fish> createFishList(){
        ArrayList<Fish> fishList = new ArrayList<>();
        Fish goldfish = new FreshwaterFish(10, 0, 0, 15, 15, 15, "Goldfish");
        Fish betaFish = new FreshwaterFish(5, 2, 1, 20, 20, 20, "Beta Fish");
        Fish catFish = new FreshwaterFish(15, 1, 1, 25, 25, 25, "Cat Fish");
        Fish clownFish = new SaltwaterFish(5, 0, 0, 15, 15, 15, "Clown Fish");
        Fish pufferFish = new SaltwaterFish(10, 2, 1, 20, 20, 20, "Puffer Fish");
        Fish sardineFish = new SaltwaterFish(15, 1, 0, 10, 10, 10, "Sardine");
        fishList.add(goldfish);
        fishList.add(betaFish);
        fishList.add(catFish);
        fishList.add(clownFish);
        fishList.add(pufferFish);
        fishList.add(sardineFish);
        fishList.add(goldfish);
        fishList.add(betaFish);
        fishList.add(catFish);
        fishList.add(clownFish);
        fishList.add(pufferFish);
        fishList.add(sardineFish);
        return fishList;
    }
}

