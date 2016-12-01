package v2;

import java.util.ArrayList;

/**
 * Created by ryan on 11/8/16.
 */
public class Driver {
    public static void main(String[] args) {
        Tank tank = new Tank(125, true);
        ArrayList<Fish> fishes = createFishList();
        ArrayList<TankComponent> tankComponents = createComponentList();
        TankGUI tankGUI = new TankGUI(tank, tankComponents,fishes);


    }

    public static ArrayList<TankComponent> createComponentList(){
        ArrayList<TankComponent> tankComponents = new ArrayList<>();

        //Filters
        TankComponent smallFilter = new Filter(30, "ACME Mini Filter");
        TankComponent averageFilter = new Filter(50, "ACME Filter");
        TankComponent largeFilter = new Filter(70, "ACME 5000 Filter");

        //Airpumps
        TankComponent smallAirPump = new Airpump(30, "ACME Mini Airpump");
        TankComponent averageAirPump = new Airpump(50, "ACME Airpump");
        TankComponent largeAirPump = new Airpump(70, "ACME 5000 Airpump");

        //Live plants
        TankComponent seaWeedPlant = new LivePlant(10, "Sea Weed (Live Plant)", 15, 15, 5);
        TankComponent bambooPlant = new LivePlant(30, "Bamboo (Live Plant)", 30, 30, 10);
        TankComponent frillPlant = new LivePlant(20, "Frill Plant (Live Plant)", 20, 20, 5);
        TankComponent javaPlant = new LivePlant(10, "Java Fern (Live Plant)", 10, 10, 5);

        //Decorations
        TankComponent decorationRock = new Decoration(10, "Rock");
        TankComponent cherryPlant = new Decoration(15, "Cherry Blossom Tree (Artificial Plant)");
        TankComponent calypsoPlant = new Decoration(20, "Calypso Plant (Artificial Plant)");
        TankComponent dragonDeco = new Decoration(30, "Dragon Ornament");
        TankComponent treeRootDeco = new Decoration(15, "Tree Root Ornament");
        TankComponent volcanoDeco = new Decoration(20, "Volcano Bubbler Ornament");
        TankComponent shipDeco = new Decoration(25, "Ship Wreck Ornament");
        TankComponent coralCaveDeco = new Decoration(30, "Coral Reef Cave Ornament");

        //Add components to list
        //filters
        tankComponents.add(smallFilter);
        tankComponents.add(averageFilter);
        tankComponents.add(largeFilter);
        //airpumps
        tankComponents.add(smallAirPump);
        tankComponents.add(averageAirPump);
        tankComponents.add(largeAirPump);
        //live plants
        tankComponents.add(seaWeedPlant);
        tankComponents.add(bambooPlant);
        tankComponents.add(frillPlant);
        tankComponents.add(javaPlant);
        //decorations
        tankComponents.add(decorationRock);
        tankComponents.add(cherryPlant);
        tankComponents.add(calypsoPlant);
        tankComponents.add(dragonDeco);
        tankComponents.add(treeRootDeco);
        tankComponents.add(volcanoDeco);
        tankComponents.add(shipDeco);
        tankComponents.add(coralCaveDeco);


        return tankComponents;
    }

    public static ArrayList<Fish> createFishList(){
        ArrayList<Fish> fishList = new ArrayList<>();

        //Fish template new Fresh/SaltwaterFish(volume, aggroLevel, swimLevel, o2Dec, co2Inc, nh4Inc, fishName)
        //Freshwater fish options
        Fish goldFish = new FreshwaterFish(10, 0, 1, 10, 10, 10, "Goldfish");
        Fish coryCatFish = new FreshwaterFish(5, 0, 0, 10, 8, 8, "Albino Cory Catfish");
        Fish algaeEater = new FreshwaterFish(15, 0, 0, 10, 8, 10, "Algae Eater");
        Fish rainbowShark = new FreshwaterFish(10, 2, 0, 0, 10, 10, "Rainbow Shark");
        Fish angelFish = new FreshwaterFish(10, 1, 1, 8, 10, 10, "Angel Fish");
        Fish aussieRainbow = new FreshwaterFish(12, 0, 1, 10, 10, 10, "Australian Rainbowfish");
        Fish tetra = new FreshwaterFish(3, 0, 1, 5, 5, 5, "Bloodfin Tetra");
        Fish hatchet = new FreshwaterFish(5, 0, 2, 8, 8, 5, "Common Hatchetfish");
        Fish halfBeak = new FreshwaterFish(5, 0, 2, 8, 8, 8, "Half Beak");
        Fish gourami = new FreshwaterFish(5, 0, 2, 5, 5, 5, "Blue Gourami");

        //Saltwater fish options
        Fish clownFish = new SaltwaterFish(5, 0, 1, 15, 15, 15, "Clown Fish");
        Fish pufferFish = new SaltwaterFish(10, 2, 1, 20, 20, 20, "Puffer Fish");
        Fish squirrelFish = new SaltwaterFish(5, 0, 2, 10, 10, 10, "Stripped Squirrelfish");
        Fish butterflyFish = new SaltwaterFish(10, 0, 1, 15, 15, 10, "Raccoon Butterflyfish");
        Fish lionFish = new SaltwaterFish(5, 1, 0, 10, 10, 10, "Fuzzy Dwarf Lionfish");
        Fish eel = new SaltwaterFish(35, 2, 0, 20, 20, 20, "Jeweled Moray Eel");
        Fish triggerFish = new SaltwaterFish(25, 2, 1, 15, 15, 15, "Pinktail Triggerfish");

        //Add fish to list
        fishList.add(goldFish);
        fishList.add(coryCatFish);
        fishList.add(algaeEater);
        fishList.add(rainbowShark);
        fishList.add(angelFish);
        fishList.add(aussieRainbow);
        fishList.add(tetra);
        fishList.add(hatchet);
        fishList.add(halfBeak);
        fishList.add(gourami);

        fishList.add(clownFish);
        fishList.add(pufferFish);
        fishList.add(squirrelFish);
        fishList.add(butterflyFish);
        fishList.add(lionFish);
        fishList.add(eel);
        fishList.add(triggerFish);

        return fishList;
    }
}