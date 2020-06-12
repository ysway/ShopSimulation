package com.Group11android;

import java.util.ArrayList;
import java.util.Random;

public class BookProvider {

    static String[] titles = {"Pride and Prejudice", "Hamlet", "Tempest", "Macbeth", "Romeo and Juliet", "Memories of a Geisha", "Emma", "Hawk: Occupation",
            "Julius Caesar", "The Greatest"};

    static String[] ids = {"001", "002", "003", "004", "005", "006", "007", "008",
            "009", "010"};

    static String[] authors = {"Jane Austen", "William Shakespeare", "William Shakespeare", "William Shakespeare", "William Shakespeare", "Arthur Golden", "Jane Austen", "Tony Hawk",  "William Shakespeare",
            "Walter Dean Myers"};


    static int[] coveraddrs = {R.drawable.b001, R.drawable.b002, R.drawable.b003, R.drawable.b004,R.drawable.b005,R.drawable.b006,R.drawable.b007,
            R.drawable.b008,R.drawable.b009,R.drawable.b010};


    public static ArrayList<Book> generateData() {
        ArrayList<Book> books = new ArrayList<Book>();


        for (int i = 0; i < 10; i++) {

            String id = ids[i];
            String author = authors[i];
            String title = titles[i];

            int coveraddr = coveraddrs[i];
            Book aBook = new Book(id,author,title,coveraddr);
            books.add(aBook);
        }
        return books;
    }


}
