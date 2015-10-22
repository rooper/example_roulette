package roulette;

import java.util.ArrayList;
import java.util.List;

import roulette.bets.BetFactory;
import roulette.bets.OddEven;
import roulette.bets.RedBlack;
import roulette.bets.ThreeConsecutive;
import util.ConsoleReader;


/**
 * Plays a game of roulette.
 * 
 * @author Robert C. Duvall
 */
public class Game {
    // name of the game
    private static final String DEFAULT_NAME = "Roulette";
    // add new bet subclasses here
    private ArrayList<String> myPossibleBets = new ArrayList<String>() {{
    	add("RedBlack");
    	add("OddEven");
    	add("ThreeConsecutive");
    }};
    
    private Wheel myWheel;

    /**
     * Construct the game.
     */
    public Game () {
        myWheel = new Wheel();
    }

    /**
     * @return name of the game
     */
    public String getName () {
        return DEFAULT_NAME;
    }

    /**
     * Play a round of roulette.
     *
     * Prompt player to make a bet, then spin the roulette wheel, and then verify 
     * that the bet is won or lost.
     *
     * @param player one that wants to play a round of the game
     */
    public void play (Gambler player) {
        int amount = ConsoleReader.promptRange("How much do you want to bet",
                                               0, player.getBankroll());
        Bet b = promptForBet();
        b.place();

        System.out.print("Spinning ...");
        Wheel.SpinResult spinResult = myWheel.spin();
        System.out.println(String.format("Dropped into %s", spinResult));
        if (b.isMade(spinResult)) {
            System.out.println("*** Congratulations :) You win ***");
            amount = b.payout(amount);
        }
        else {
            System.out.println("*** Sorry :( You lose ***");
            amount *= -1;
        }
        player.updateBankroll(amount);
    }

    /**
     * Prompt the user to make a bet from a menu of choices.
     */
    private Bet promptForBet () {
    	BetFactory bf = new BetFactory();
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myPossibleBets.size(); k++) {
            System.out.println(String.format("%d) %s", (k + 1), bf.createBet(myPossibleBets.get(k)).getDetails()));
        }
        int response = ConsoleReader.promptRange("Please make a choice", 1, myPossibleBets.size());
        
        return bf.createBet(myPossibleBets.get(response-1));
    }
}
