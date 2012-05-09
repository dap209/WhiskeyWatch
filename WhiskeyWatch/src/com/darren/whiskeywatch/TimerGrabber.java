package com.darren.whiskeywatch;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;

public class TimerGrabber {
	/** This class still needs to be implemented into the project as a method.
	 * The method should return both the time remaining in the deal (TimeLeft), 
	 * as well as the total time the deal had in the first place (TimeFull) 
	 * IN SECONDS. I'm guessing this should be done with a getter object, not a 
	 * return line...
	 * 
	 * Also, I'm planning on adding the capability to use this method on any
	 * backcountry.com one-deal-at-a-time website (chainlove, whiskeymilitia,
	 * steepandcheap) by passing the web address as a String parameter.
	 * @param args
	 */
	
	private static Integer TimeLeft;
	private static Integer TimeFull;
	private static Integer NextTime;
	private static String WebHtml;
	private static String url = "http://www.whiskeymilitia.com";
	
	public String getWebHtml() {
		return WebHtml;
	}
	
	// getter method for the time left in the ODAT deal (TimeLeft)
	public static Integer getTimeLeft() {
		return TimeLeft;
	}
	
	// getter method for the total time the deal had from the start (TimeFull)
	public static Integer getTimeFull() {
		return TimeFull;
	}
	
	public static Integer getNextTime() {
		return NextTime;
	}

	public static void main() {
		try {
//			String document = DownloaderService.getHtml("http://www.whiskeymilitia.com");
			WebHtml = (Jsoup.connect(url).get().toString());
			// Set up the regex pattern to expect, as well as the corresponding matcher object
			Pattern p = Pattern.compile("TimerBar.\\d+,\\d+");
			Matcher m = p.matcher(WebHtml);
			
			// This loop finds the occurrence of the regex from the Pattern p (defined above)
			while (m.find()) {
				String TimerString = m.group();
				String TimerSplit = TimerString.replaceFirst(".*\\(", "");
				
				// This line will grab the time left in the deal
				TimeLeft = Integer.parseInt(TimerSplit.replaceFirst(",.*", ""));
				
				// This line will grab the total time the deal had from the start
				TimeFull = Integer.parseInt(TimerSplit.replaceFirst(".*,", ""));
				System.out.println(TimeLeft);
				Date date = new Date();
				NextTime = (int) (date.getTime()/1000+TimeLeft);
				System.out.println(TimeFull);
			}

		} catch (IOException e) {
			// Error handling...
			e.printStackTrace();
		}
	}

}