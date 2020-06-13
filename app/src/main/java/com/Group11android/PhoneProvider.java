package com.Group11android;

import java.util.ArrayList;
import java.util.Random;

public class PhoneProvider {

    static String[] phmks = {"Huawei P40 pro", "Huawei p40", "Huawei p40 pro+", "Huawei Mate Xs",
            "Huawei Mate30 pro", "Huawei Y6s", "Huawei P30", "Huawei P30 pro",
            "Huawei Nova 5T", "Huawei Y9 Prime","Galaxy A01","Galaxy S20","Galaxy A31", "Galaxy A71",
            "Galaxy Z Flip","Galaxy A80","Galaxy A51","Galaxy Fold","Galaxy A90","Galaxy Note 10",
            "OPPO FindX2 pro","OPPO FindX2 Lite","OPPO FindX",
            "OPPO Reno2","OPPO Reno2z","OPPO Reno10x","OPPO A91","OPPO A9","OPPO AX7","OPPO AX5s"};

    static String[] ids = {"H01", "H02", "H03", "H04","H05", "H06", "H07", "H08", "H09", "H10", "S01",
            "S02","S03","S04","S05","S06","S07","S08","S09","S10","O01","O02","O03","O04","O05",
            "O06","O07","O08","O09","O10"};

    static int[] coveraddrs = {R.drawable.h1, R.drawable.h2, R.drawable.h3, R.drawable.h4,R.drawable.h5,
            R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,R.drawable.s1,R.drawable.s2,
            R.drawable.s3,R.drawable.s4,R.drawable.s5,R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,
            R.drawable.s10};


    public static ArrayList<Phone> generateData() {
        ArrayList<Phone> phones = new ArrayList<Phone>();


        for (int i = 0; i < 10; i++) {

            String id = ids[i];
            String phmk = phmks[i];

            int coveraddr = coveraddrs[i];
            Phone aPhone = new Phone(id,phmk,coveraddr);
            phones.add(aPhone);
        }
        return phones;
    }


}
