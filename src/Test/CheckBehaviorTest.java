package Test;

import v1.Fish;
import v1.FreshwaterFish;
import v1.Tank;

import java.util.ArrayList;

/**
 * Created by ryan on 11/20/16.
 */
public class CheckBehaviorTest {

    public static void main(String[] args) {
        Fish fish1 = new FreshwaterFish(2, 1, 2, 0, 0, 0, "A");
        Fish fish2 = new FreshwaterFish(2, 0, 2, 0, 0, 0, "A");
        Fish fish3 = new FreshwaterFish(2, 1, 1, 0, 0, 0, "A");
        Fish fish4 = new FreshwaterFish(2, 1, 1, 0, 0, 0, "A");
        Fish fish5 = new FreshwaterFish(2, 1, 2, 0, 0, 0, "A");



        Fish fish6 = new FreshwaterFish(2, 2, 2, 0, 0, 0, "A");



        ArrayList<Fish> fishes = new ArrayList<>();
        fishes.add(fish1);
        fishes.add(fish2);
        fishes.add(fish3);
        fishes.add(fish4);
        fishes.add(fish5);


        boolean compatible = false;
        ArrayList<Fish> fishTemp = new ArrayList<>();
        if (!fishes.isEmpty()) {
            for (Fish fishAlreadyInTank : fishes) {
                if (fishAlreadyInTank.getSwimmingLevel() == fish6.getSwimmingLevel()) {
                    if (fishAlreadyInTank.getAggressionLevel() == fish6.getAggressionLevel()) {
                        System.out.println("Compatible - same aggression, same level");
                        compatible = true;
                    } else {
                        System.out.println("Not Compatible - different aggression");
                        compatible = false;
                    }
                }
                else {
                    System.out.println("Compatible - different level");
                    compatible = true;
                }
            }
        }
        else {
            System.out.println("Compatible - Tank empty");
//            fishTemp.add(fish6);
            compatible = true;
        }

        if(compatible) {
            System.out.println("Fish 6 added");
            fishes.add(fish6);
        }
        else {
            System.out.println("Fish 6 not added");
        }

    }
}
