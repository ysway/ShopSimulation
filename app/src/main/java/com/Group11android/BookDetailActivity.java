package com.Group11android;

import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import android.os.Bundle;
import android.os.Environment;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class BookDetailActivity extends AppCompatActivity {

    private ImageView ivBookCover;
    private TextView tvTitle;
    private TextView tvAuthor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        ivBookCover = (ImageView) findViewById(R.id.ivBookCover);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvAuthor = (TextView) findViewById(R.id.tvAuthor);

        Intent thisIntent = getIntent();
        // Use the book to populate the data into our views
        //Book book = (Book) thisIntent.getSerializableExtra(MainActivity.BOOK_DETAIL_KEY);
        //loadBook(book);
    }


    private void loadBook(Book book) {
        //change activity title

        this.setTitle(book.getTitle());

        tvTitle.setText(book.getTitle());
        tvAuthor.setText(book.getAuthor());

        //String mDrawableName = book.getCover();
        //int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        int resID = book.getCover();
        ivBookCover.setImageResource(resID);


    }




}