package v1;

/**
 * Created by ryan on 11/8/16.
 */
public class TankComponent {
    private int volume;
//TODO : getVolume , with a volume field variable

    public TankComponent(int volume){
        this.volume = volume;
    }

    public int getVolume(){
        return this.volume;
    }
}
