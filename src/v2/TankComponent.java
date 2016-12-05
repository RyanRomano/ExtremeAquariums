package v2;
/**
 * Abstract Tank Component class that contains
 * everything that each tank component has in common
 */
public abstract class TankComponent {
    private int volume;
    private String componentName;

    /**
     * 2-argument constructor for tank component
     * takes an int for volume &
     * a string for componentName
     *
     * @param volume - the amount of space a component takes up in the tank.
     * @param componentName - name of the tank component
     */
    public TankComponent(int volume, String componentName){
        this.volume = volume;
        this.componentName = componentName;
    }
    /**
     * Mutator method
     * Sets volume for each tank component
     * @param volume
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }
    /**
     * Accessor method
     * Gets the component name for each tank component
     * @return componentName
     */
    public String getComponentName() {
        return componentName;
    }
    /**
     * Mutator method
     * Sets component name for each tank component
     * @param componentName
     */
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }
    /**
     * Accessor method
     * Gets volume for each tank component
     * @return this.volume
     */
    public int getVolume(){
        return this.volume;
    }
    /**
     * Abstract method, affectEnvironment, to show the affect
     * each tank component has on the environment of the tank.
     * Takes in a boolean to check if the component is added
     * @param isAdded
     */
    public abstract void affectEnvironment(boolean isAdded);
}