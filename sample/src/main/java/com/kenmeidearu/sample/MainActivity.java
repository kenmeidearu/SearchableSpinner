package com.kenmeidearu.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kenmeidearu.searchablespinnerlibrary.SearchableSpinner;
import com.kenmeidearu.searchablespinnerlibrary.mListString;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] customerNama = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SearchableSpinner sp = (SearchableSpinner) findViewById(R.id.spinner);

        ArrayList<mListString> StringIsi = new ArrayList<>();//must crete this to generate data there are n1-n4
        customerNama = getResources().getStringArray(R.array.planets);
        int id = 0;
        for (String s : customerNama) {
            StringIsi.add(new mListString(id, s, s, s, s));
            id++;
        }
        assert sp != null;
        sp.setTitleList("--Select Customer--");//use this to create initial search first
        sp.setAdapter(StringIsi, 2, 1);// type spinner 1-4, searh option 1-4

    }

}
