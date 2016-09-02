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

    List<FakeNews> list = FakeNewsList.all;
    int currentPosition;

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fakelist_cell, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String newsTitle = list.get(position).title;
        currentPosition = position;
        holder.display(newsTitle);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;

        public MyViewHolder(final View itemView) {
            super(itemView);

            title = ((TextView) itemView.findViewById(R.id.title));
            //content = ((WebView) itemView.findViewById(R.id.content));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
/*                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle(title.getText())
                            .show();
*/
                    Log.i("mylogs", "step 1");
                    Intent myIntent = new Intent(view.getContext(), DetailsActivity.class);
                    myIntent.putExtra("title", list.get(currentPosition).title);
                    myIntent.putExtra("htmlContent", list.get(currentPosition).htmlContent);
                    Log.i("mylogs", "step 2 (currentPosition="+currentPosition+")");
                    view.getContext().startActivity(myIntent);
                    Log.i("mylogs", "step 3");
                }
            });
        }

        public void display(String t) {
            title.setText(t);
        }
    }
}
