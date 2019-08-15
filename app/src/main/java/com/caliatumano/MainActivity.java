package com.caliatumano;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int images[] = {
                R.drawable.img2,
                R.drawable.img4,
                R.drawable.img5,
                R.drawable.img6,
                R.drawable.img7
        };

        ViewFlipper viewFlipper= findViewById(R.id.view_flipper);

        for (int img :images) {
            ImageView imageView= new ImageView(this);
            imageView.setBackgroundResource(img);
            
            viewFlipper.addView(imageView);
            viewFlipper.setFlipInterval(3000);
            viewFlipper.setAutoStart(true);
            viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
            viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
        }


    }
}
