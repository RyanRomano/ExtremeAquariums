package v2;
/**
 * Empty Tank Exception class that displays a message
 * 	if a user tries to build an empty tank.
 */
public class EmptyTankException extends Exception{

    /**
     * No argument constructor,
     * calls functions of the super class
     */
    public EmptyTankException(){
        super();
    }
    /**
     * 1-argument constructor,
     * takes in a String for message
     *
     * @param message
     *
     * Calls message from buildListener in the tankGUI class
     */
    public EmptyTankException(String message){
        super(message);
    }

}