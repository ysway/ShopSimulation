package com.Group11android;

import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
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


public class PhoneDetailActivity extends AppCompatActivity {

    private ImageView ivPhoneCover;
    private TextView tvPhMk;
    private TextView tvSold;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_detail);

        ivPhoneCover = (ImageView) findViewById(R.id.ivPhoneCover);
        tvPhMk = (TextView) findViewById(R.id.tvPhMk);
        tvSold = (TextView) findViewById(R.id.tvSold);
        button = (Button) findViewById(R.id.button);

        Intent thisIntent = getIntent();
        // Use the phone to populate the data into our views
        final Phone phone = (Phone) thisIntent.getSerializableExtra(BrandDetailActivity.PHONE_DETAIL_KEY);
        loadPhone(phone);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!phone.getId().equals("null")) {
                    phone.buy();
                    MainActivity.soldList[Integer.parseInt(phone.getId())] = MainActivity.soldList[Integer.parseInt(phone.getId())] + 1;
                    tvSold.setText(String.valueOf(MainActivity.soldList[Integer.parseInt(phone.getId())]));
                    MainActivity.BuyClick += 1;
                }
            }
        });
    }

    private void loadPhone(Phone phone) {
        //change activity title

        this.setTitle(phone.getPhMk());

        tvPhMk.setText(phone.getPhMk());

        if(!phone.getId().equals("null")) {
            tvSold.setText(String.valueOf(MainActivity.soldList[Integer.parseInt(phone.getId())]));
        } else {tvSold.setText("0");}

        //String mDrawableName = phone.getCover();
        //int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());
        int resID = phone.getCover();
        ivPhoneCover.setImageResource(resID);
    }
}