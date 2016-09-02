package com.oc.rss.fakenewsreader;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init the recyclerview
        final RecyclerView rv = (RecyclerView) findViewById(R.id.fakelist);
        // load it in a linearlayout
        rv.setLayoutManager(new LinearLayoutManager(this));
        // add the data
        rv.setAdapter(new MyAdapter());
    }
}
