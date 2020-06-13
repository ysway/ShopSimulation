package com.Group11android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    public static final String BRAND_DETAIL_KEY = "brand";

    public static int[] soldList = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; // zeros(30)

    public static int pos = 0;
    ListView lvBrands;
    BrandAdapter brandAdapter;

    private ArrayList<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //private Button Click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildReCyclerView();



        lvBrands = (ListView) findViewById(R.id.lvBrands);
        ArrayList<Brand> aBrands = new ArrayList<Brand>();

        aBrands = BrandProvider.generateData();
        brandAdapter = new BrandAdapter(this, aBrands);

        lvBrands.setAdapter(brandAdapter);

        LinearLayoutManager lm = new LinearLayoutManager(this);

        setupBrandSelectedListener();


    }

    public void SearchForContent(View v){
        Toast.makeText(this,"No matched item has been found",Toast.LENGTH_LONG).show();

    }
    public void changeItem(int position, String text){
        mExampleList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }

    public void createExampleList(){
        mExampleList = new ArrayList<>();

        mExampleList.add(new ExampleItem(R.drawable.b001,"Top1"));
        mExampleList.add(new ExampleItem(R.drawable.b002,"Top2"));
        mExampleList.add(new ExampleItem(R.drawable.b003,"Top3"));
    }
    public void buildReCyclerView(){
        mRecyclerView = findViewById((R.id.recyclerView));
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListerner(new ExampleAdapter.OnItemClickListerner() {
            @Override
            public void onItemClick(int position) {
                changeItem(position,"Clicked");
            }
        });
    }

    public void setupBrandSelectedListener() {
        lvBrands.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Launch the detail view passing brand as an extra
                Intent intent = new Intent(MainActivity.this, BrandDetailActivity.class);
                intent.putExtra(BRAND_DETAIL_KEY, brandAdapter.getItem(position));
                pos = (int) id;
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
}

