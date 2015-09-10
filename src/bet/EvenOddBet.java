package bet;

import roulette.Wheel;
import util.ConsoleReader;

public class EvenOddBet extends BetObject implements Bet {
	public EvenOddBet() {
		myDescription = "Odd or Even";
		myOdds = 1;
		betChoice = "";
	}

	public Bet prompt(Wheel myWheel) {
		betChoice = ConsoleReader.promptOneOf("Please bet", "even", "odd");
		return this;
	}

	@Override
	public int makeBetAndPrint(Wheel myWheel) {
		return checkWinAndReturnScore((myWheel.getNumber() % 2 == 0 && betChoice.equals("even"))
				|| (myWheel.getNumber() % 2 == 1 && betChoice.equals("odd")));
	}
}
