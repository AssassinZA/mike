package com.varsitycollege.ctill.starsucksv3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    ImageView img_Sb1,img_Sb2,img_Sb3,img_Sb4,img_Sb5,img_Sb6;
    IntentHelper intentHelper;
    Order order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentHelper = new IntentHelper();
        order = new Order();

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
                order.setProductName("Soy Frappe");
                intentHelper.openIntent(this,order.getProductName(),OrderDetails.class);
                break;

            case R.id.img_sb2:
                Toast.makeText(this, "Chocolate Frappe", Toast.LENGTH_SHORT).show();
                order.setProductName("Chocolate Frappe");
                intentHelper.openIntent(this,order.getProductName(), OrderDetails.class);
                break;

            case R.id.img_sb3:
                Toast.makeText(this, "Bottled Frappe", Toast.LENGTH_SHORT).show();
                order.setProductName("Bottled Frappe");
                intentHelper.openIntent(this,order.getProductName(),OrderDetails.class);
                break;

            case R.id.img_sb4:
                Toast.makeText(this, "Rainbow Frappe", Toast.LENGTH_SHORT).show();
                order.setProductName("Rainbow");
                intentHelper.openIntent(this,order.getProductName(),OrderDetails.class);
                break;

            case R.id.img_sb5:
                Toast.makeText(this, "Black Forest Frappe", Toast.LENGTH_SHORT).show();
                order.setProductName("Black Forest Frappe");
                intentHelper.openIntent(this,order.getProductName(),OrderDetails.class);
                break;

            case R.id.img_sb6:
                Toast.makeText(this, "Christmas Frappe", Toast.LENGTH_SHORT).show();
                order.setProductName("Christmas Frappe");
                intentHelper.openIntent(this,order.getProductName(),OrderDetails.class);
                break;
        }

    }
}
