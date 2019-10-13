package com.varsitycollege.ctill.starsucksv3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class OrderDetails extends AppCompatActivity
{
    TextView placedOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        placedOrder = findViewById(R.id.tv_placedOrder);

        placedOrder.setText(getIntent().getStringExtra("order"));
    }
}
