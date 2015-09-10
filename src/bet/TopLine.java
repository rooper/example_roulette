package bet;

import java.util.ArrayList;
import java.util.Arrays;

import roulette.Wheel;
import util.ConsoleReader;

public class TopLine extends BetObject implements Bet {

	public TopLine() {
		myDescription = "A bet on 0, 00, 1, 2, 3";
		myOdds = 7;
	}

	public Bet prompt(Wheel myWheel) {
		betChoice = ConsoleReader.promptOneOf("Pick your number");
		return this;
	}

	@Override
	public int makeBetAndPrint(Wheel myWheel) {
		ArrayList<String> num = new ArrayList<String>(Arrays.asList("0", "00", "1", "2", "3"));
		return checkWinAndReturnScore(num.contains(betChoice));
	}
}