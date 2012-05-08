package testpkg;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;

public class WMTimerGrabber {
	/** This class still needs to be implemented into the project as a method.
	 * The method should return both the time remaining in the deal (WMTimeLeft), 
	 * as well as the total time the deal had in the first place (WMTimeFull) 
	 * IN SECONDS. I'm guessing this should be done with a getter object, not a 
	 * return line...
	 * @param args
	 */

	public static void main(String[] args) {
		try {
			// Download the html source of whiskeymilitia.com
			String document = (Jsoup.connect("http://www.whiskeymilitia.com").get().toString());
			
			// Set up the regex pattern to expect, as well as the corresponding matcher object
			Pattern p = Pattern.compile("WMTimerBar.\\d+,\\d+");
			Matcher m = p.matcher(document);
			
			// This loop finds the occurrence of the regex from the Pattern p (defined above)
			while (m.find()) {
				String WMTimerString = m.group();
				String WMTimerSplit = WMTimerString.replaceFirst(".*\\(", "");
				
				// This line will grab the time left in the deal
				Integer WMTimeLeft = Integer.parseInt(WMTimerSplit.replaceFirst(",.*", ""));
				
				// This line will grab the total time the deal had from the start
				Integer WMTimeFull = Integer.parseInt(WMTimerSplit.replaceFirst(".*,", ""));
				System.out.println(WMTimeLeft);
				System.out.println(WMTimeFull);
			}

		} catch (IOException e) {
			// Error handling...
			e.printStackTrace();
		}
	}

}
