package com.Group11android;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import android.graphics.drawable.Drawable;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

public class PhoneAdapter extends ArrayAdapter<Phone> {


    private static class ViewHolder{

        public ImageView ivCover;
        public TextView  tvPhMk;
        public TextView tvSold;

    }


    public PhoneAdapter(Context context, ArrayList<Phone> aPhones){

        super(context, 0, aPhones);

    }

    //translates a particular 'Phone' given a position
    //into a relevant row within an AdapterView

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //get the data item for this position
        final Phone phone = getItem(position);

        //check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_phone,parent,false);
            viewHolder.ivCover = (ImageView)convertView.findViewById(R.id.ivPhoneCover);
            viewHolder.tvPhMk = (TextView)convertView.findViewById(R.id.tvPhMk);
            viewHolder.tvSold = (TextView)convertView.findViewById(R.id.tvSold);
            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Populate the data into the template view using the data object
        viewHolder.tvPhMk.setText(phone.getPhMk());
        viewHolder.tvSold.setText(String.valueOf(phone.getSold()));

        int resID = phone.getCover();

        viewHolder.ivCover.setImageResource(resID);

        //viewHolder.ivCover.setImageResource(R.drawable.b002);


        return convertView;
    }


}


