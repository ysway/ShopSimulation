package com.Group11android;


import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;


public class Phone implements Serializable {
    private String id;
    private int sold;
    private String PhMk;
    private int CoverAddr;



    public Phone(String id, String PhMk, int CoverAddr){

        this.id = id;
        this.sold = 0;
        this.PhMk = PhMk;
        this.CoverAddr = CoverAddr;
    }

    public String getId(){
        return id;
    }

    public String getPhMk() {
        return PhMk;
    }

    public void buy() {this.sold += 1;}

    public int getSold(){
        return sold;
    }

    public int getCover(){
        return CoverAddr;
    }



}
