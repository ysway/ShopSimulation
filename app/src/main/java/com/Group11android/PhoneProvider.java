package com.Group11android;

import java.util.ArrayList;
import java.util.Random;

public class PhoneProvider {

    static int index = 0;

    public static String[] phmks = {"Huawei P40 pro", "Huawei p40", "Huawei p40 pro+", "Huawei Mate Xs",
            "Huawei Mate30 pro", "Huawei Y6s", "Huawei P30", "Huawei P30 pro",
            "Huawei Nova 5T", "Huawei Y9 Prime","Galaxy A01","Galaxy S20","Galaxy A31", "Galaxy A71",
            "Galaxy Z Flip","Galaxy A80","Galaxy A51","Galaxy Fold","Galaxy A90","Galaxy Note 10",
            "OPPO FindX2 pro","OPPO FindX2 Lite","OPPO FindX",
            "OPPO Reno2","OPPO Reno2z","OPPO Reno10x","OPPO A91","OPPO A9","OPPO AX7","OPPO AX5s"};


    public static String[] ids = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"};


    public static int[] coveraddrs = {R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4,R.drawable.h5,
            R.drawable.h6, R.drawable.h7, R.drawable.h8, R.drawable.h9, R.drawable.h10, R.drawable.s1,
            R.drawable.s2, R.drawable.s3, R.drawable.s4,R.drawable.s5, R.drawable.s6, R.drawable.s7,
            R.drawable.s8, R.drawable.s9, R.drawable.s10, R.drawable.o1, R.drawable.o2, R.drawable.o3,
            R.drawable.o4,R.drawable.o5, R.drawable.o6, R.drawable.o7, R.drawable.o8, R.drawable.o9,
            R.drawable.o10};


    public static ArrayList<Phone> generateData(int pos) {

        ArrayList<Phone> phones = new ArrayList<Phone>();
        if (pos == 0) {index = 0;}
        else if (pos == 1) {index = 10;}
        else {index = 20;}

        for (int i = 0; i < 10; i++) {

            String id = ids[i + index];
            String phmk = phmks[i + index];

            int coveraddr = coveraddrs[i + index];
            Phone aPhone = new Phone(id, MainActivity.soldList[Integer.parseInt(id)],phmk, coveraddr);
            phones.add(aPhone);
        }
        return phones;
    }
}
