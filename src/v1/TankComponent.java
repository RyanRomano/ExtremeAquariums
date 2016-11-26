package v1;

/**
 * Created by ryan on 11/8/16.
 */
public abstract class TankComponent {
    private int volume;
    private String componentName;
//TODO : getVolume , with a volume field variable

    public TankComponent(int volume, String componentName){
        this.volume = volume;
        this.componentName = componentName;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public int getVolume(){
        return this.volume;
    }

    public abstract void affectEnvironment(boolean isAdded);
}
