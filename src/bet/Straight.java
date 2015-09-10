package bet;

import roulette.Wheel;
import util.ConsoleReader;

public class Straight extends BetObject implements Bet {

	public Straight() {
		myDescription = "A Single Number Bet";
		myOdds = 36;
	}

	public Bet prompt(Wheel myWheel) {
		betChoice = ConsoleReader.promptOneOf("Pick your number");
		return this;
	}

	@Override
	public int makeBetAndPrint(Wheel myWheel) {
		return checkWinAndReturnScore(Integer.parseInt(betChoice) == myWheel.getNumber());
	}
}