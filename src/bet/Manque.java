package bet;

import roulette.Wheel;
import util.ConsoleReader;

public class Manque extends BetObject implements Bet {

	public Manque() {
		myDescription = "1 to 18 (Manque)";
		myOdds = 1;
	}

	public Bet prompt(Wheel myWheel) {
		betChoice = ConsoleReader.promptOneOf("Pick your number");
		return this;
	}

	@Override
	public int makeBetAndPrint(Wheel myWheel) {
		return checkWinAndReturnScore(Integer.parseInt(betChoice) <= 18 && Integer.parseInt(betChoice) >= 1);
	}
}