package com.varsitycollege.ctill.starsucksv4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    ImageView img_Sb1,img_Sb2,img_Sb3,img_Sb4,img_Sb5,img_Sb6;
    String order;
    Function function;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        function = new Function();

        img_Sb1 = findViewById(R.id.img_sb1);
        img_Sb2 = findViewById(R.id.img_sb2);
        img_Sb3 = findViewById(R.id.img_sb3);
        img_Sb4 = findViewById(R.id.img_sb4);
        img_Sb5 = findViewById(R.id.img_sb5);
        img_Sb6 = findViewById(R.id.img_sb6);

        img_Sb1.setOnClickListener(this);
        img_Sb2.setOnClickListener(this);
        img_Sb3.setOnClickListener(this);
        img_Sb4.setOnClickListener(this);
        img_Sb5.setOnClickListener(this);
        img_Sb6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.img_sb1:
                Toast.makeText(this, "Soy Frappe", Toast.LENGTH_SHORT).show();
                order="Soy Frappe";
                function.openIntent(this,order);
                break;

            case R.id.img_sb2:
                Toast.makeText(this, "Chocolate Frappe", Toast.LENGTH_SHORT).show();
                order = "Chocolate Frappe";
                function.openIntent(this,order);
                break;

            case R.id.img_sb3:
                Toast.makeText(this, "Bottled Frappe", Toast.LENGTH_SHORT).show();
                order = "Bottled Frappe";
                function.openIntent(this,order);
                break;

            case R.id.img_sb4:
                Toast.makeText(this, "Rainbow Frappe", Toast.LENGTH_SHORT).show();
                order = "Rainbow";
                function.openIntent(this,order);
                break;

            case R.id.img_sb5:
                Toast.makeText(this, "Black Forest Frappe", Toast.LENGTH_SHORT).show();
                order ="Black Forest Frappe";
                function.openIntent(this,order);
                break;

            case R.id.img_sb6:
                Toast.makeText(this, "Christmas Frappe", Toast.LENGTH_SHORT).show();
                order ="Christmas Frappe";
                function.openIntent(this,order);
                break;
        }
    }
}
