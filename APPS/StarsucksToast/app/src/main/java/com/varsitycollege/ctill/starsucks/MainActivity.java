package com.varsitycollege.ctill.starsucks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 //instantiating widgets  (controls)
    ImageView img_sb1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // initialising widgets (controls)
        img_sb1= findViewById(R.id.img_sb1);

        //setting an onclick listener to fire a toast message when we click (touch) an image
        
        img_sb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "MMMMMM Cuppuchino!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
