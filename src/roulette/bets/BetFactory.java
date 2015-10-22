/**
 * 
 */
package roulette.bets;

import roulette.Bet;

import java.lang.reflect.InvocationTargetException;

import locale.Locale;

/**
 * @author loganrooper
 *
 */
public class BetFactory {	
	public Bet createBet(String betType) {
		String path = "roulette.bets.";
		try {
			String name = locale.Locale.getString(betType).split(",")[0];
			int odds = Integer.parseInt(locale.Locale.getString(betType).split(",")[1]);
			return (Bet) Class.forName(path + betType).getDeclaredConstructor(String.class, Integer.class).newInstance(name, odds);
		} catch(Exception e) {
			System.err.println("Bet class not found: " + path + betType);
			e.printStackTrace();
			return null;
		}
	}
}