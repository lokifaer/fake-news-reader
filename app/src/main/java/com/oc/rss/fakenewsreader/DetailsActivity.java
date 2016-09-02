package com.oc.rss.fakenewsreader;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by rmollon on 02/09/16.
 */
public class DetailsActivity extends AppCompatActivity {

    private WebView textContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // set the title to the actionbar
        setTitle(getIntent().getStringExtra("title"));

        // get the webview
        textContent = (WebView) findViewById(R.id.webView);
        // load the content
        textContent.loadData(getIntent().getStringExtra("htmlContent"), "text/html;charset=UTF-8", null);
    }
}
