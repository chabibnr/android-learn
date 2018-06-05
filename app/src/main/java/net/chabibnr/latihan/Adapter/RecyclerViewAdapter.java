package net.chabibnr.latihan.Adapter;


import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.chabibnr.latihan.Models.PackageModel;
import net.chabibnr.latihan.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<PackageModel> mDataset = new ArrayList<PackageModel>();
    //private static PackageModel mModel;

    public static class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        public View mView;
        public TextView mTextView;
        public ViewHolder(TextView v){
            super(v);
            mTextView = v;
        }

        public ViewHolder(View v){
            super(v);
            //v.setOnClickListener(this);
            mView = v;
        }

        @Override
        public void onClick(View v) {

        }
    }

    public RecyclerViewAdapter(PackageModel m){
        //mModel = m;
        this.addModel(m.all());
    }

    public RecyclerViewAdapter addModel(ArrayList<PackageModel> item){
        if(mDataset == null){
            mDataset = new ArrayList<PackageModel>();
        }
        int pos = mDataset.size();
        mDataset.addAll(item);

        notifyItemRangeInserted(pos, item.size());
        return this;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        /* Versi Text
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_recyclerview_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        */

        /* Versi View */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_recyclerview_item_image, parent, false);
        RecyclerViewAdapter.ViewHolder vh = new RecyclerViewAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        //holder.mTextView.setText(mDataset[position]);
        PackageModel item = mDataset.get(position);
        TextView textTitle = (TextView) holder.mView.findViewById(R.id.text_title);
        TextView textId = (TextView) holder.mView.findViewById(R.id.text_description);
        ImageView imageView = (ImageView) holder.mView.findViewById(R.id.imageView);
        textTitle.setText(item.getName());
        textId.setText(item.getId());
        imageView.setImageDrawable(item.getIcon());
    }

    @Override
    public int getItemCount(){
        return mDataset.size();
    }
}
