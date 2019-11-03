package com.varsitycollege.ctill.starsucksv3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OrderDetails extends AppCompatActivity
{
    EditText et_customerName, et_customerCell;
    TextView placedOrder;
    String orderedValue;
    ImageView img_OrderedBeverage;
    FloatingActionButton fab;
    IntentHelper intentHelper;
    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        intentHelper = new IntentHelper();
        order = new Order();
        fab = findViewById(R.id.fab);
        placedOrder = findViewById(R.id.tv_placedOrder);
        et_customerName = findViewById(R.id.et_customerName);
        et_customerCell =findViewById(R.id.et_customerCell);
        img_OrderedBeverage = findViewById(R.id.img_OrderedBeverage);
        orderedValue =  getIntent().getStringExtra("order");
        placedOrder.setText(orderedValue);



        switch(orderedValue)
        {
            case "Soy Frappe":
                img_OrderedBeverage.setImageResource(R.drawable.sb1);
                break;
            case "Chocolate Frappe":
                img_OrderedBeverage.setImageResource(R.drawable.sb2);
                break;
            case "Bottled Frappe":
                img_OrderedBeverage.setImageResource(R.drawable.sb3);
                break;
            case "Rainbow":
                img_OrderedBeverage.setImageResource(R.drawable.sb4);
                break;
            case "Black Forest Frappe":
                img_OrderedBeverage.setImageResource(R.drawable.sb5);
                break;
            case "Christmas Frappe":
                img_OrderedBeverage.setImageResource(R.drawable.sb6);

            default:
                Toast.makeText(this, "Hmmm Gary messed up Again.. GARY!!!",
                        Toast.LENGTH_SHORT).show();
        }


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                intentHelper.shareIntent(OrderDetails.this,orderedValue);

            }
        });


    }
}
