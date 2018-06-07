package com.example.pseudonym.aplikasikosong;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    ListView myList;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Resources res = getResources();
        myList = (ListView) findViewById(R.id.myList);
        items = res.getStringArray(R.array.items);

        ItemAdapter itemAdapter = new ItemAdapter(this, items);
        myList.setAdapter(itemAdapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent showDetail = new Intent(getApplicationContext(), ItemDetailActivity.class);
                showDetail.putExtra("com.example.pseudonym.ITEM_INDEX", i);
                startActivity (showDetail);
            }
        });

    }
}
