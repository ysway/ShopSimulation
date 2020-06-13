package com.Group11android;

public class ExampleItem {
    private int mImageResources;
    private String mText;

    public ExampleItem(int imageResource, String text1){
        mImageResources = imageResource;
        mText = text1;

    }
    public void changeText1(String text){
        mText = text;
    }
    public int getImageResources(){
        return mImageResources;
    }
    public String getText1(){
        return mText;
    }
}
