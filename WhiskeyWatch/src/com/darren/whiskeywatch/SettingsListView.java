package com.darren.whiskeywatch;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsListView extends ListActivity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		List<String> settings = new ArrayList<String>();

		String document = null;
		try {
			document = (Jsoup.connect("http://www.whiskeymilitia.com").get().toString());
			Pattern p = Pattern.compile(".*WMTimer.*");
			Matcher m = p.matcher(document);
			int b = m.end();
			
			String WMTimer = m.toString();
//			System.out.println(document);
			System.out.println(b);
	        Toast.makeText(getApplicationContext(), "OK!", Toast.LENGTH_LONG).show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

/*		ArrayAdapter<String> newAdapter = new ArrayAdapter<String>(this, R.layout.list_item, settings);

		setListAdapter(newAdapter);
   	
		getListView().setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// When clicked, show a toast with the TextView text
				Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			};
		});*/
	}
}