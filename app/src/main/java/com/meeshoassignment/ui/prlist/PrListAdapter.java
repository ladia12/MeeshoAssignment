package com.meeshoassignment.ui.prlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.meeshoassignment.R;
import com.meeshoassignment.data.retrofit.PullRequest;

import java.util.ArrayList;

/**
 * Created by root on 10/14/17.
 */

public class PrListAdapter extends RecyclerView.Adapter {

    private ArrayList<PullRequest> mData;
    private Context mContext;

    public PrListAdapter(ArrayList<PullRequest> data, Context context) {
        mData = data;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pr_list_item, parent, false);
        return new PrViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PrViewHolder viewHolder = (PrViewHolder) holder;
        viewHolder.body.setText(mData.get(position).getTitle());
        viewHolder.number.setText("#" + mData.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    private class PrViewHolder extends RecyclerView.ViewHolder {

        TextView body;
        TextView number;


        PrViewHolder(View itemView) {
            super(itemView);
            body =  (TextView) itemView.findViewById(R.id.body);
            number =  (TextView) itemView.findViewById(R.id.number);
        }
    }
}
