package com.Group11android;


import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;


public class Book implements Serializable {
    private String id;
    private String author;
    private String title;
    private int CoverAddr;



    public Book(String id, String author, String title, int CoverAddr){

        this.id = id;
        this.author = author;
        this.title = title;
        this.CoverAddr = CoverAddr;
    }

    public String getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public int getCover(){
        return CoverAddr;
    }



}
