package testpkg;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;

public class WMTimerGrabber {

	public static void main(String[] args) {
		try {
			String document = (Jsoup.connect("http://www.whiskeymilitia.com").get().toString());
			Pattern p = Pattern.compile("WMTimerBar.\\d+,\\d+");
			Matcher m = p.matcher(document);
			//boolean b = m.find();
			
			while (m.find()) {
				String WMTimerString = m.group();
				String WMTimerSplit = WMTimerString.replaceFirst(".*\\(", "");
				Integer WMTimeLeft = Integer.parseInt(WMTimerSplit.replaceFirst(",.*", ""));
				Integer WMTimeFull = Integer.parseInt(WMTimerSplit.replaceFirst(".*,", ""));
				System.out.println(WMTimeLeft);
				System.out.println(WMTimeFull);
			}
			String WMTimer = m.toString();
//			System.out.println(document);
			//System.out.println(b);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
