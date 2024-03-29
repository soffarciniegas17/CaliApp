package com.caliatumano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        int images[] = {
                R.drawable.img2,
                R.drawable.img4,
                R.drawable.img5,
                R.drawable.img6,
                R.drawable.img7
        };

        ViewFlipper viewFlipper = findViewById(R.id.view_flipper);

        for (int img : images) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(img);

            viewFlipper.addView(imageView);
            viewFlipper.setFlipInterval(3000);
            viewFlipper.setAutoStart(true);
            viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
            viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
        }

    }

    public void inicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        switch (view.getId()) {
            case R.id.iniciar_s:
                intent.putExtra("crud", "inicar");
                break;
            case R.id.crear_c:
                intent.putExtra("crud", "crear");
                break;
        }

        startActivity(intent);

    }
}
