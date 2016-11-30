package v2;

public class EmptyTankException extends Exception{

    public EmptyTankException(){
        super();
    }

    public EmptyTankException(String message){
        super(message);
    }

}