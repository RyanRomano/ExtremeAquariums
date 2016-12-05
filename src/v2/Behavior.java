package v2;
/**
 * Interface that sets swimming level &
 * 	aggression level for each fish
 */


public interface Behavior {
    public abstract void setSwimmingLevel(int level);
    public abstract void setAggressionLevel(int level);
}