package com.varsitycollege.ctill.starsucks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

//Main activity
public class MainActivity extends AppCompatActivity {
    // instantiate your image views so that we can programaticcally access them.
    //Android Image Views :https://developer.android.com/reference/android/widget/ImageView

    ImageView img_sb1,img_sb2,img_sb3,img_sb4,img_sb5,img_sb6;
    String product ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_sb1= findViewById(R.id.img_sb1);
        img_sb2= findViewById(R.id.img_sb2);
        img_sb3= findViewById(R.id.img_sb3);
        img_sb4= findViewById(R.id.img_sb4);
        img_sb5= findViewById(R.id.img_sb5);
        img_sb6= findViewById(R.id.img_sb6);

        img_sb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product = "Frappe";
                Toast.makeText(MainActivity.this, "yeah Frappe!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this,orderDetails.class);
                i.putExtra("Product",product);
                startActivity(i);
            }
        });

        img_sb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product = "chocoFrappe";
                Toast.makeText(MainActivity.this, "yeah Choco Frappe!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this,orderDetails.class);
                i.putExtra("Product",product);
                startActivity(i);
            }
        });

        img_sb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product = "Bottled Frappe";
                Toast.makeText(MainActivity.this, "yeah Bottled Frappe!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this,orderDetails.class);
                i.putExtra("Product",product);
                startActivity(i);
            }
        });

        img_sb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product = "UnicornFrappe";
                Toast.makeText(MainActivity.this, "yeah Unicorn Frappe!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this,orderDetails.class);
                i.putExtra("Product",product);
                startActivity(i);
            }
        });


        img_sb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product = "BlackForestFrappe";
                Toast.makeText(MainActivity.this, "yeah BlackForest Frappe!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this,orderDetails.class);
                i.putExtra("Product",product);
                startActivity(i);
            }
        });

        img_sb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product = "Extra Large Choc Frappe";
                Toast.makeText(MainActivity.this, "yeah SuperSize me Frappe!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this,orderDetails.class);
                i.putExtra("Product",product);
                startActivity(i);
            }
        });



    }

}
