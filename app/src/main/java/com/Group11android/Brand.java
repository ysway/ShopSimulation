package com.Group11android;


import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;


public class Brand implements Serializable {
    private String id;
    private String brand;
    private int CoverAddr;

    public Brand(String id, String brand, int CoverAddr){
        this.id = id;
        this.brand = brand;
        this.CoverAddr = CoverAddr;
    }

    public String getId(){
        return id;
    }

    public String getBrand(){
        return brand;
    }

    public int getCover(){
        return CoverAddr;
    }
}
