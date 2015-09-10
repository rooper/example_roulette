package roulette;
import bet.*;
import util.ConsoleReader;


/**
 * Plays a game of roulette.
 * 
 * @author Robert C. Duvall
 */
public class Game {
    // name of the game
    private static final String DEFAULT_NAME = "Roulette";
    // bets player can make
    private Bet[] myPossibleBets = { 
        new BlackRedBet(),
        new EvenOddBet(),
        new ThreeBet()
    };
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
		int amount = ConsoleReader.promptRange("How much do you want to bet", 0, player.getBankroll());
		int whichBet = promptForBet();
	
		Bet myBet = myPossibleBets[whichBet].prompt(myWheel);
		player.updateBankroll(myBet.makeBetAndPrint(myWheel));
    }

    /**
     * Prompt the user to make a bet from a menu of choices.
     */
    private int promptForBet () {
        System.out.println("You can make one of the following types of bets:");
        for (int k = 0; k < myPossibleBets.length; k++) {
            System.out.println(String.format("%d) %s", (k + 1), ((BetObject) myPossibleBets[k]).getDescription()));
        }
        return ConsoleReader.promptRange("Please make a choice", 1, myPossibleBets.length) - 1;
    }
}
