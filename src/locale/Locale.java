package locale;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author loganrooper
 *
 */
public class Locale {
	static ResourceBundle locale;
	
	public static String getString(String s) {
		try {
			FileInputStream fis = new FileInputStream("en_US.properties");
			locale = new PropertyResourceBundle(fis);
			return locale.getString(s);
		} catch (IOException e) {
			System.err.println("No language bundle found!");
			return null;
		}
	}
}
