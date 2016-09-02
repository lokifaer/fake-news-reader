package com.oc.rss.fakenewsreader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by rmollon on 02/09/16.
 */
public class DetailsActivity extends Activity {

    private TextView textTitle;
    private WebView textContent;
    private String title;
    private String htmlContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Log.i("mylogs", "step 3.1");

        title = getIntent().getStringExtra("title");
        htmlContent = getIntent().getStringExtra("htmlContent");

        Log.i("mylogs", "step 3.2");

        textTitle = (TextView) findViewById(R.id.textView);
        textTitle.setText(title);
        Log.i("mylogs", "step 3.2.bis");

        textContent = (WebView) findViewById(R.id.webView);
        textContent.loadData(htmlContent, "text/html", "UTF8");

        Log.i("mylogs", "step 3.3");
    }
}
