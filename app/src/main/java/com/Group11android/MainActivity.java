package com.Group11android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import android.os.Handler;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    public static final String BRAND_DETAIL_KEY = "brand";

    public static int[] soldList = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // zeros(30)

    public static int BuyClick = 0;
    public static int Mbuyclick = 1;

    public static int pos = 0;

    ListView lvBrands;
    BrandAdapter brandAdapter;
    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        content();
    }

    public void content() {
        if (Mbuyclick != MainActivity.BuyClick) {
            lvBrands = (ListView) findViewById(R.id.lvBrands);
            ArrayList<Brand> aBrands = new ArrayList<Brand>();

            aBrands = BrandProvider.generateData();
            brandAdapter = new BrandAdapter(this, aBrands);

            lvBrands.setAdapter(brandAdapter);

            LinearLayoutManager lm = new LinearLayoutManager(this);

            setupBrandSelectedListener();

            // Find best sold 3
            double[] TsoldList = new double[30];
            for (int index = 0; index < 30; index++) {
                TsoldList[index] = soldList[index];
            }

            final int[] topPhs = maxKIndex(TsoldList, 3);


            button1 = (Button) findViewById(R.id.button1);
            button2 = (Button) findViewById(R.id.button2);
            button3 = (Button) findViewById(R.id.button3);


            Drawable ph1 = getDrawable(PhoneProvider.coveraddrs[topPhs[0]]);
            assert ph1 != null;
            ph1.setBounds(0, 0, 0, 0);

            Drawable ph2 = getDrawable(PhoneProvider.coveraddrs[topPhs[1]]);
            assert ph2 != null;
            ph2.setBounds(0, 0, 0, 0);

            Drawable ph3 = getDrawable(PhoneProvider.coveraddrs[topPhs[2]]);
            assert ph3 != null;
            ph3.setBounds(0, 0, 0, 0);


            button1.setBackground(ph1);
            button2.setBackground(ph2);
            button3.setBackground(ph3);

            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, PhoneDetailActivity.class);
                    intent.putExtra(BrandDetailActivity.PHONE_DETAIL_KEY, new Phone(PhoneProvider.ids[topPhs[0]], MainActivity.soldList[topPhs[0]], PhoneProvider.phmks[topPhs[0]], PhoneProvider.coveraddrs[topPhs[0]]));
                    startActivity(intent);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, PhoneDetailActivity.class);
                    intent.putExtra(BrandDetailActivity.PHONE_DETAIL_KEY, new Phone(PhoneProvider.ids[topPhs[1]], MainActivity.soldList[topPhs[1]], PhoneProvider.phmks[topPhs[1]], PhoneProvider.coveraddrs[topPhs[1]]));
                    startActivity(intent);
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, PhoneDetailActivity.class);
                    intent.putExtra(BrandDetailActivity.PHONE_DETAIL_KEY, new Phone(PhoneProvider.ids[topPhs[2]], MainActivity.soldList[topPhs[2]], PhoneProvider.phmks[topPhs[2]], PhoneProvider.coveraddrs[topPhs[2]]));
                    startActivity(intent);
                }
            });
            Mbuyclick = MainActivity.BuyClick;
        }
        refresh(100);
    }

    public void refresh(int ms) {
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                content();
            }
        };
        handler.postDelayed(runnable, ms);
    }

    public void setupBrandSelectedListener() {
        lvBrands.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing brand as an extra
                Intent intent = new Intent(MainActivity.this, BrandDetailActivity.class);
                intent.putExtra(BRAND_DETAIL_KEY, brandAdapter.getItem(position));
                pos = (int) id;
                BrandDetailActivity.Bbuyclick = -1;
                MainActivity.Mbuyclick = -1;
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_brand_list, menu);
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
                for(int i = 0; i < 30; i++) {
                    if (PhoneProvider.phmks[i].equals(query)) {
                        Intent intent = new Intent(MainActivity.this, PhoneDetailActivity.class);
                        intent.putExtra(BrandDetailActivity.PHONE_DETAIL_KEY, new Phone(PhoneProvider.ids[i], MainActivity.soldList[i], PhoneProvider.phmks[i], PhoneProvider.coveraddrs[i]));
                        startActivity(intent);
                        break;
                    } else if (i == 29) {
                        Intent intent = new Intent(MainActivity.this, PhoneDetailActivity.class);
                        intent.putExtra(BrandDetailActivity.PHONE_DETAIL_KEY, new Phone("null", 0, "NOT FOUND", R.drawable.ic_nocover));
                        startActivity(intent);
                    }
                }

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

    public static int[] maxKIndex(double[] array, int top_k) {
        double[] max = new double[top_k];
        int[] maxIndex = new int[top_k];
        Arrays.fill(max, Double.NEGATIVE_INFINITY);
        Arrays.fill(maxIndex, -1);

        top: for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < top_k; j++) {
                if(array[i] > max[j]) {
                    for(int x = top_k - 1; x > j; x--) {
                        maxIndex[x] = maxIndex[x-1]; max[x] = max[x-1];
                    }
                    maxIndex[j] = i; max[j] = array[i];
                    continue top;
                }
            }
        }
        return maxIndex;
    }
}

