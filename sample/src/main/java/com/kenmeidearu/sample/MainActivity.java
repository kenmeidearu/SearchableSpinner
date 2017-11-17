package com.kenmeidearu.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

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
        final SearchableSpinner sp1 = (SearchableSpinner) findViewById(R.id.spinner1);
        SearchableSpinner sp2 = (SearchableSpinner) findViewById(R.id.spinner2);

        //for two data
        ArrayList<mListString> StringIsi = new ArrayList<>();//must crete this to generate data there are n1-n4
        customerNama = getResources().getStringArray(R.array.planets);
        int id = 0;
        for (String s : customerNama) {
            StringIsi.add(new mListString(id, s, s, s, s));
            id++;
        }
        assert sp != null;
        sp.setTitleList("--Select Planet--");//use this to create initial search first
        sp.setAdapter(StringIsi, 2, 1);// type spinner 1-4, search option 1-4

        //for 4 data
        final ArrayList<mListString> listStringsCustomer = new ArrayList<>();
        listStringsCustomer.add(new mListString(1, "Andi", "Ambon Street", "Active", "New"));
        listStringsCustomer.add(new mListString(2, "Budi", "Bandung Street", "Active", "New"));
        listStringsCustomer.add(new mListString(3, "Carli", "Chille Street", "Non Active", "New"));
        listStringsCustomer.add(new mListString(4, "Deni", "Denmark Street", "Active", "New"));
        listStringsCustomer.add(new mListString(5, "Eko", "Estonia Street", "Active", "New"));
        sp1.setTitleList("--Select Customer--");//use this to create initial search first
        sp1.setAdapter(listStringsCustomer, 4, 4);// type spinner 1-4, search option 1-4

        //for immage
        final ArrayList<mListString> listStringsNegara = new ArrayList<>();
        listStringsNegara.add(new mListString(1, "Indonesia", "INA", "https://upload.wikimedia.org/wikipedia/id/2/2d/Bendera_Indonesia_%28Merah_Putih%29_by_Vibriel.jpg", true));
        listStringsNegara.add(new mListString(1, "Amerika Serikat", "USA", "http://2fm.rte.ie/wp-content/uploads/2017/05/american-flag-1459201553ppe-1.jpg", true));
        listStringsNegara.add(new mListString(1, "England", "UK", "http://1.bp.blogspot.com/-G7UhV_i5Rcc/T_15FYC57KI/AAAAAAAAAEc/-Trp7ugfE74/s1600/uk-flag.jpg", true));
        listStringsNegara.add(new mListString(1, "Jepang", "JP", "http://www.id.emb-japan.go.jp/image/expl12_01.jpg", true));
        sp2.setAdapter(listStringsNegara, 0, 2);//type zero for list with image


        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("tes posisi", id + " ," + position + "," + listStringsCustomer.get(position - 1).get_id() + "," + sp1.getSelectedItem().toString());

                mListString layerName = ((mListString) sp1.getSelectedItem());
                Toast.makeText(MainActivity.this, "You choose:" + layerName.getNilai1(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
