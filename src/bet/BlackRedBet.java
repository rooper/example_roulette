package bet;

import roulette.Wheel;
import util.ConsoleReader;

public class BlackRedBet extends BetObject implements Bet {
	public BlackRedBet() {
		myDescription = "Red or Black";
		myOdds = 1;
		betChoice = "";
	}

	public Bet prompt(Wheel myWheel) {
		betChoice = ConsoleReader.promptOneOf("Please bet", Wheel.BLACK, Wheel.RED);
		return this;
	}

	@Override
	public int makeBetAndPrint(Wheel myWheel) {
		return checkWinAndReturnScore(myWheel.getColor().equals(betChoice));
	}
}
