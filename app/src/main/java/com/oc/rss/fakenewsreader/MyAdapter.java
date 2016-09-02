package com.oc.rss.fakenewsreader;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by rmollon on 30/08/16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    // load the list
    List<FakeNews> list = FakeNewsList.all;

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // send the cells in the view holder
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fakelist_cell, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // display content of a cell according to the position in the list
        holder.display(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private int currentPosition;

        public MyViewHolder(final View itemView) {
            super(itemView);

            // get the current cell textview
            title = ((TextView) itemView.findViewById(R.id.title));

            // set a click event on the current cell
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // generate an intent to start another activity
                    Intent myIntent = new Intent(view.getContext(), DetailsActivity.class);
                    // add the data (title and content)
                    myIntent.putExtra("title", list.get(currentPosition).title);
                    myIntent.putExtra("htmlContent", list.get(currentPosition).htmlContent);
                    // start the activity (DetailsActivity)
                    view.getContext().startActivity(myIntent);
                }
            });
        }

        public void display(int position) {
            // save the current position for details part
            currentPosition = position;
            // set the title of the news to the textview of the current cell
            title.setText(list.get(currentPosition).title);
        }
    }
}
