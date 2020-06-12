package com.Group11android;

import java.util.ArrayList;
import java.util.Random;

public class PhoneProvider {

    static String[] phmks = {"Phone0", "Phone1", "Phone2", "Phone3", "Phone4", "Phone5", "Phone6", "Phone7",
            "Phone8", "Phone9"};

    static String[] ids = {"001", "002", "003", "004", "005", "006", "007", "008",
            "009", "010"};

    static int[] coveraddrs = {R.drawable.b001, R.drawable.b002, R.drawable.b003, R.drawable.b004,R.drawable.b005,R.drawable.b006,R.drawable.b007,
            R.drawable.b008,R.drawable.b009,R.drawable.b010};


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
