package v2;
import java.util.ArrayList;
/**
 * Driver class that runs the Extreme Aquarium Program
 * Contains 2 Polymorphic Array Lists one for tank components & one for fish
 * Also has the GUI for building your own tank
 */
public class Driver {
    /**
     * Main method that runs the aquarium builder program.
     * Contains a tank, an array list for fish,
     * an array list for tank components, and a tank GUI
     */
    public static void main(String[] args) {
        Tank tank = new Tank(125, true);
        ArrayList<Fish> fishes = createFishList();
        ArrayList<TankComponent> tankComponents = createComponentList();
        TankGUI tankGUI = new TankGUI(tank, tankComponents,fishes);
    }
    /**
     * Array List of tank components is created, populated, and then returned.
     * @return tankComponents
     */
    public static ArrayList<TankComponent> createComponentList(){
        ArrayList<TankComponent> tankComponents = new ArrayList<>();
        /**
         * Filters that can be put into the tank.
         */
        TankComponent smallFilter = new Filter(30, "ACME Mini Filter");
        TankComponent averageFilter = new Filter(50, "ACME Filter");
        TankComponent largeFilter = new Filter(70, "ACME 5000 Filter");

        /**
         * Air pumps that can be put into the tank.
         */
        TankComponent smallAirPump = new Airpump(30, "ACME Mini Airpump");
        TankComponent averageAirPump = new Airpump(50, "ACME Airpump");
        TankComponent largeAirPump = new Airpump(70, "ACME 5000 Airpump");

        /**
         * Live plants that can be put into the tank.
         */
        TankComponent seaWeedPlant = new LivePlant(10, "Sea Weed (Live Plant)", 15, 15, 5);
        TankComponent bambooPlant = new LivePlant(30, "Bamboo (Live Plant)", 30, 30, 10);
        TankComponent frillPlant = new LivePlant(20, "Frill Plant (Live Plant)", 20, 20, 5);
        TankComponent javaPlant = new LivePlant(10, "Java Fern (Live Plant)", 10, 10, 5);

        /**
         * Decorations that can be put into the tank.
         */
        TankComponent decorationRock = new Decoration(10, "Rock");
        TankComponent cherryPlant = new Decoration(15, "Cherry Blossom Tree (Artificial Plant)");
        TankComponent calypsoPlant = new Decoration(20, "Calypso Plant (Artificial Plant)");
        TankComponent dragonDeco = new Decoration(30, "Dragon Ornament");
        TankComponent treeRootDeco = new Decoration(15, "Tree Root Ornament");
        TankComponent volcanoDeco = new Decoration(20, "Volcano Bubbler Ornament");
        TankComponent shipDeco = new Decoration(25, "Ship Wreck Ornament");
        TankComponent coralCaveDeco = new Decoration(30, "Coral Reef Cave Ornament");

        /**
         * All tanks components are then added to the tankComponenets list.
         */

        /**
         * Filters
         */
        tankComponents.add(smallFilter);
        tankComponents.add(averageFilter);
        tankComponents.add(largeFilter);
        /**
         * Air pumps
         */
        tankComponents.add(smallAirPump);
        tankComponents.add(averageAirPump);
        tankComponents.add(largeAirPump);
        /**
         * Live Plants
         */
        tankComponents.add(seaWeedPlant);
        tankComponents.add(bambooPlant);
        tankComponents.add(frillPlant);
        tankComponents.add(javaPlant);
        /**
         * Decorations
         */
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
    /**
     * ArrayList of fish is created, populated, and then returned.
     * @return fishList
     */
    public static ArrayList<Fish> createFishList(){
        ArrayList<Fish> fishList = new ArrayList<>();

        /**
         * Fish template for creating a new Fresh/SaltwaterFish
         * ( volume - int size,
         * 	aggroLevel - int aggression lvl of fish,
         * 	swimLevel - int swimming lvl of fish,
         * 	o2Dec - int oxygen decrease factor of fish
         * 	co2Inc - int carbon dioxide increase factor of fish,
         * 	nh4Inc - int ammonia increase factor of fish,
         * 	fishName - String for the name of the fish)
         */

        /**
         * Fresh water fish options that can be added to the fish tank.
         */
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

        /**
         * Salt water fish options that can be added to the fish tank.
         */
        Fish clownFish = new SaltwaterFish(5, 0, 1, 10, 10, 10, "Clown Fish");
        Fish pufferFish = new SaltwaterFish(10, 2, 1, 10, 10, 10, "Puffer Fish");
        Fish squirrelFish = new SaltwaterFish(5, 0, 2, 8, 8, 8, "Stripped Squirrelfish");
        Fish butterflyFish = new SaltwaterFish(10, 0, 1, 10, 10, 8, "Raccoon Butterflyfish");
        Fish lionFish = new SaltwaterFish(5, 1, 0, 8, 8, 8, "Fuzzy Dwarf Lionfish");
        Fish eel = new SaltwaterFish(35, 2, 0, 20, 20, 20, "Jeweled Moray Eel");
        Fish triggerFish = new SaltwaterFish(25, 2, 1, 15, 15, 15, "Pinktail Triggerfish");
        /**
         * All species of fish are then added to the fishList.
         */

        /**
         * Fresh water fish options available.
         */
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

        /**
         * Salt water fish options available.
         */
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