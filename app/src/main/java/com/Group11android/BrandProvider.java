package com.Group11android;

import java.util.ArrayList;
import java.util.Random;

public class BrandProvider {

    static String[] titles = {"Huawei", "Samsung", "Oppo",};

    static String[] ids = {"001", "002", "003"};

    static int[] coveraddrs = {R.drawable.huawei, R.drawable.samsung, R.drawable.oppo};

    public static ArrayList<Brand> generateData() {
        ArrayList<Brand> brands = new ArrayList<Brand>();

        for (int i = 0; i < 3; i++) {

            String id = ids[i];
            String title = titles[i];

            int coveraddr = coveraddrs[i];
            Brand aBrand = new Brand(id,title,coveraddr);
            brands.add(aBrand);
        }
        return brands;
    }
}
