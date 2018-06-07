package com.example.pseudonym.aplikasikosong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button MenuBtn1 = (Button) findViewById(R.id.MenuBtn1);
        Button MenuBtn2 = (Button) findViewById(R.id.MenuBtn2);
        Button MenuBtn3 = (Button) findViewById(R.id.MenuBtn3);

        MenuBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ListViewIntent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(ListViewIntent);
            }
        });

        MenuBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AboutIntent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(AboutIntent);
            }
        });

        MenuBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
