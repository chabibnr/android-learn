package net.chabibnr.latihan.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.chabibnr.latihan.Models.GithubModel;
import net.chabibnr.latihan.R;

import java.util.ArrayList;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.ViewHolder> {

    private ArrayList<GithubModel> mDataset = new ArrayList<GithubModel>();
    //private static GithubModel mModel;

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

    public GithubAdapter(GithubModel m){
        //mModel = m;
        //this.addModel(m.all());
    }

    public GithubAdapter addModel(ArrayList<GithubModel> item){
        if(mDataset == null){
            mDataset = new ArrayList<GithubModel>();
        }
        int pos = mDataset.size();
        mDataset.addAll(item);

        notifyItemRangeInserted(pos, item.size());
        return this;
    }

    @Override
    public GithubAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        /* Versi Text
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_recyclerview_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        */

        /* Versi View */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_recyclerview_item2, parent, false);
        GithubAdapter.ViewHolder vh = new GithubAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        //holder.mTextView.setText(mDataset[position]);
        GithubModel item = mDataset.get(position);
        TextView textTitle = (TextView) holder.mView.findViewById(R.id.text_title);
        TextView textId = (TextView) holder.mView.findViewById(R.id.text_description);
        //ImageView imageView = (ImageView) holder.mView.findViewById(R.id.imageView);
        textTitle.setText(item.getName());
        textId.setText(item.getId());
        //imageView.setImageDrawable(item.getIcon());
    }

    @Override
    public int getItemCount(){
        return mDataset.size();
    }
}
