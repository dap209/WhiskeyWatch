package com.darren.whiskeywatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.darren.whiskeywatch.SettingsListView;

public class WhiskeyWatchActivity extends Activity {
    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        WebView myWebView = (WebView) findViewById(R.id.webView1);
        myWebView.loadUrl("http://m.whiskeymilitia.com");
        
        // Capture our button from layout
        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {

        	@Override
            public void onClick(View v) {
            	// When clicked, show a toast with the TextView text
            	Toast.makeText(getApplicationContext(), ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
            };
        });
    }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu, menu);
    return true;
}
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle item selection
    switch (item.getItemId()) {
        case R.id.menu_add:
            return true;
        case R.id.menu_settings:
//        	setContentView(R.layout.settings);
        	Intent myIntent = new Intent(WhiskeyWatchActivity.this, SettingsListView.class);
        	WhiskeyWatchActivity.this.startActivity(myIntent);
            return true;
        case R.id.menu_help:
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}}