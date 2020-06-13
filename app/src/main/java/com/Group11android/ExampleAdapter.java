package com.Group11android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>{
    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickListerner mListener;

    public interface  OnItemClickListerner{
        void onItemClick(int position);
    }
    public void setOnItemClickListerner(OnItemClickListerner listener){
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView1;


        public ExampleViewHolder(View itemView, final OnItemClickListerner listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.TopPhoneImage);
            mTextView1 = itemView.findViewById(R.id.TopPhoneName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getLayoutPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
    public ExampleAdapter(ArrayList<ExampleItem> exampleList){;
        mExampleList = exampleList;

    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder View_Holder = new ExampleViewHolder(v,mListener);
        return View_Holder;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);
        holder.mImageView.setImageResource(currentItem.getImageResources());
        holder.mTextView1.setText(currentItem.getText1());

    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
