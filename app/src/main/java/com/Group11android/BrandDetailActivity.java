package com.Group11android;

import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import android.os.Bundle;
import android.os.Environment;

import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class BrandDetailActivity extends AppCompatActivity {

    public static final String PHONE_DETAIL_KEY = "phone";

    ListView lvPhones;
    PhoneAdapter phoneAdapter;
    ArrayList<Phone> aphones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);

        lvPhones = (ListView) findViewById(R.id.lvPhones);
        ArrayList<Phone> aPhones = new ArrayList<Phone>();

        aPhones = PhoneProvider.generateData(MainActivity.pos);

        phoneAdapter = new PhoneAdapter(this, aPhones);

        lvPhones.setAdapter(phoneAdapter);

        LinearLayoutManager lm = new LinearLayoutManager(this);

        setupPhoneSelectedListener();

    }

    public void setupPhoneSelectedListener() {
        lvPhones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing phone as an extra
                Intent intent = new Intent(BrandDetailActivity.this, PhoneDetailActivity.class);
                intent.putExtra(PHONE_DETAIL_KEY, phoneAdapter.getItem(position));
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_phone_list, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                // Reset SearchView
                searchView.clearFocus();
                searchView.setQuery("", false);
                searchView.setIconified(true);
                searchItem.collapseActionView();

                //complete SearchActivity by yourself
                Intent intent = new Intent(BrandDetailActivity.this, BrandDetailActivity.class);
                for(int i = 0; i < 10; i++) {
                    if(phoneAdapter.getItem(i).getPhMk().equals(query)) {
                        intent.putExtra(PHONE_DETAIL_KEY, phoneAdapter.getItem(i));
                        break;
                    }
                }
                startActivity(intent);

                /*
                // Set activity title to search query
                MainActivity.this.setTitle(query);
                 */
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}