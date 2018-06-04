package net.chabibnr.latihan.Content;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import net.chabibnr.latihan.Model;
import net.chabibnr.latihan.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Model.Item> mDataset;
    private static Model mModel;

    public static class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        public View mView;
        public TextView mTextView;
        public ViewHolder(TextView v){
            super(v);
            mTextView = v;
        }

        public ViewHolder(View v){
            super(v);
            v.setOnClickListener(this);
            mView = v;
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION){
                Model.Item item = mModel.get(position);
                //Toast.makeText(v.getContext(), item.getTitle(), Toast.LENGTH_LONG).show();
                Intent i = new Intent(v.getContext(), item.getMainClass());
                v.getContext().startActivity(i);
            }
        }
    }

    public RecyclerViewAdapter(Model m){
        mModel = m;
        mDataset = m.getData();
    }

    public RecyclerViewAdapter addModel(ArrayList<Model.Item> item){
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_recyclerview_item2, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        //holder.mTextView.setText(mDataset[position]);
        Model.Item item = mModel.get(position);
        TextView textTitle = (TextView) holder.mView.findViewById(R.id.text_title);
        TextView textDescription = (TextView) holder.mView.findViewById(R.id.text_description);
        textTitle.setText(item.getTitle());
        textDescription.setText(item.getDescription());
    }

    @Override
    public int getItemCount(){
        return mDataset.size();
    }
}
