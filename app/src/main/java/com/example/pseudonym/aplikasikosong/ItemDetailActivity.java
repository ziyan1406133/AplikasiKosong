package com.example.pseudonym.aplikasikosong;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemdetail);

        Intent in = getIntent();
        int index = in.getIntExtra("com.example.pseudonym.ITEM_INDEX", -1);

        if (index > -1) {
            int pic = getImg(index);
            ImageView img = (ImageView) findViewById(R.id.itemimage);
            scaleImg(img, pic);
        }

    }

    private int getImg(int index) {
        switch (index) {
            case 0: return R.drawable.item1;
            case 1: return R.drawable.item2;
            case 2: return R.drawable.item3;
            default: return -1;
        }
    }

    private void scaleImg(ImageView img, int pic) {

        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imgWidth > screenWidth) {
            int ratio = Math.round( (float)imgWidth / (float)screenWidth );
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImg);

    }

}
