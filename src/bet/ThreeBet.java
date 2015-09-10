package bet;
import roulette.Wheel;
import util.ConsoleReader;

public class ThreeBet extends BetObject implements Bet{
	int betChoice;
	
    public ThreeBet () {
        myDescription = "Three in a Row";
        myOdds = 11;
        betChoice = 0;
    }
	public Bet prompt(Wheel myWheel){
		betChoice = ConsoleReader.promptRange("Enter first of three consecutive numbers",
                1, Wheel.NUM_SPOTS - 3);
		return this;
	}
	
	@Override
	public int makeBetAndPrint(Wheel myWheel) {
		return checkWinAndReturnScore(betChoice <= myWheel.getNumber() && myWheel.getNumber() < betChoice + 3);
	}
}
