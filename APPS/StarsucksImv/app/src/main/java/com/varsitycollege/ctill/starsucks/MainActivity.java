package com.varsitycollege.ctill.starsucks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declaring Variables widgets/ Views)
    ImageView img_sb1,img_sb2,img_sb3,img_sb4,img_sb5,img_sb6 ;
    TextView tv_Order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialising variables by connecting
        // to the correct xml view through the R class
        tv_Order = findViewById(R.id.tv_Order);
        img_sb1= findViewById(R.id.img_sb1);
        img_sb2= findViewById(R.id.img_sb2);
        img_sb3= findViewById(R.id.img_sb3);
        img_sb4= findViewById(R.id.img_sb4);
        img_sb5= findViewById(R.id.img_sb5);
        img_sb6= findViewById(R.id.img_sb6);


        //Setting an onClick Listener on the first ImageView.
        img_sb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //creating a Toast that will pop up when the image is tapped on the screen.
                Toast.makeText(getApplicationContext(), "MMM Soy Latte", Toast.LENGTH_SHORT).show();
            }
        });


        img_sb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "MMM Chocco Frapp", Toast.LENGTH_SHORT).show();
            }
        });

        img_sb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "MMM Bottled Americano", Toast.LENGTH_SHORT).show();
            }
        });


        img_sb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "MMM Rainbow Frapp", Toast.LENGTH_SHORT).show();
            }
        });

        img_sb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "MMM Caramel Frapp", Toast.LENGTH_SHORT).show();
            }
        });


        img_sb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "MMM Black Forest Frapp", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
