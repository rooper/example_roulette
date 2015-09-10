package bet;

import roulette.Wheel;

public class BetObject {

	protected String myDescription;
	protected int myOdds;
	protected String betChoice;

	/**
	 * Constructs a bet with the given name and odds.
	 * 
	 * @param description
	 *            name of this kind of bet
	 * @param odds
	 *            odds given by the house for this kind of bet
	 */

	/**
	 * @return odds given by the house for this kind of bet
	 */
	public int getOdds() {
		return myOdds;
	}

	/**
	 * @return name of this kind of bet
	 */
	public String getDescription() {
		return myDescription;
	}

	public void print(Wheel myWheel) {
		System.out.print("Spinning ...");
		myWheel.spin();
		System.out.println(String.format("Dropped into %s %d", myWheel.getColor(), myWheel.getNumber()));
	}
	
	public int checkWinAndReturnScore(Boolean win) {
		if (win) {
			System.out.println("*** Congratulations :) You win ***");
			return myOdds;
		} else {
			System.out.println("*** Sorry :( You lose ***");
			return -1;
		}
	}
}
