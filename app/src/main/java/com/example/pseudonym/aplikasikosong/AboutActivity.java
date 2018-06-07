package com.example.pseudonym.aplikasikosong;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button devname = (Button) findViewById(R.id.devname);
        devname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = "https://www.facebook.com/yagami.raito.5074";
                Uri webaddress = Uri.parse(link);

                Intent openlink = new Intent(Intent.ACTION_VIEW, webaddress);
                if (openlink.resolveActivity(getPackageManager()) != null) {
                    startActivity(openlink);
                }
            }
        });

    }
}
