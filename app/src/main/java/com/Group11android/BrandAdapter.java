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

public class BrandAdapter extends ArrayAdapter<Brand> {


    private static class ViewHolder{

        public ImageView ivCover;
        public TextView  tvBrand;

    }


    public BrandAdapter(Context context, ArrayList<Brand> aBrands){

        super(context, 0, aBrands);

    }

    //translates a particular 'Brand' given a position
    //into a relevant row within an AdapterView

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //get the data item for this position
        final Brand brand = getItem(position);

        //check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_brand,parent,false);
            viewHolder.ivCover = (ImageView)convertView.findViewById(R.id.ivBrandCover);
            viewHolder.tvBrand = (TextView)convertView.findViewById(R.id.tvBrand);
            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Populate the data into the template view using the data object
        viewHolder.tvBrand.setText(brand.getBrand());

        int resID = brand.getCover();

        viewHolder.ivCover.setImageResource(resID);

        //viewHolder.ivCover.setImageResource(R.drawable.b002);

        return convertView;
    }

}


