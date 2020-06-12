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

public class BookAdapter extends ArrayAdapter<Book> {


    private static class ViewHolder{

        public ImageView ivCover;
        public TextView  tvTitle;
        public TextView tvAuthor;

    }


    public BookAdapter(Context context, ArrayList<Book> aBooks){

        super(context, 0, aBooks);

    }

    //translates a particular 'Book' given a position
    //into a relevant row within an AdapterView

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //get the data item for this position
        final Book book = getItem(position);

        //check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_book,parent,false);
            viewHolder.ivCover = (ImageView)convertView.findViewById(R.id.ivBookCover);
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
            viewHolder.tvAuthor = (TextView)convertView.findViewById(R.id.tvAuthor);
            convertView.setTag(viewHolder);
        } else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //Populate the data into the template view using the data object
        viewHolder.tvTitle.setText(book.getTitle());
        viewHolder.tvAuthor.setText(book.getAuthor());

        int resID = book.getCover();

        viewHolder.ivCover.setImageResource(resID);

         //viewHolder.ivCover.setImageResource(R.drawable.b002);


        return convertView;
    }


}


