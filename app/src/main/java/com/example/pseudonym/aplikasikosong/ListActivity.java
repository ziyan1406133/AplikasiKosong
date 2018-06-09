package com.example.pseudonym.aplikasikosong;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class ListActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    private AdView mAdView;
    ListView myList;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //using sample App ID
        //Initialize ad
        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");


        //Interstitial Ad Start
        mInterstitialAd = new InterstitialAd(this);
        //using sample Interstitial ID
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        //Interstitial Ad End

        //Banner Ad Start
        mAdView = findViewById(R.id.BannerAd);
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        //using sample Banner ID
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //Banner Ad End

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

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
        }
        });

    }
}
