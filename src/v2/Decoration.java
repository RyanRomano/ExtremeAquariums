package v2;
/**
 * Decoration is a subclass of Tank Component that
 * contains name and volume of the decoration added to the tank.
 */
public class Decoration extends TankComponent {

    private String decorationName;

    /**
     * 2-argument constructor for Decoration,
     * takes an int for volume & a String for decoration name.
     * Also calls the superclass.
     *
     * @param volume - how much space the decoration takes up in the tank
     * @param decorationName - name of the decoration
     */
    public Decoration(int volume, String decorationName){
        super(volume, decorationName);
        this.decorationName = decorationName;
    }
    /**
     * Method to control the affect the decoration has on the environment of the tank.
     * Takes in isAdded as a boolean.
     */
    @Override
    public void affectEnvironment(boolean isAdded) {
    }
}