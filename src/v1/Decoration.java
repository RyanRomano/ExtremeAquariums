package v1;

/**
 * Created by ryan on 11/8/16.
 */
public class Decoration extends TankComponent {
    private String decorationName;
    public Decoration(int volume, String decorationName){
        super(volume, decorationName);
        this.decorationName = decorationName;
    }
}
