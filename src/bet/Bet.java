package bet;

import roulette.Wheel;
import util.ConsoleReader;

/**
 * Represents player's attempt to bet on outcome of the roulette wheel's spin.
 * 
 * @author Robert C. Duvall
 */
public interface Bet {	    
    public abstract Bet prompt(Wheel myWheel);
    
    public int makeBetAndPrint(Wheel myWheel);
}
