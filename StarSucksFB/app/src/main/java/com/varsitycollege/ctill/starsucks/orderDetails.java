package com.varsitycollege.ctill.starsucks;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class orderDetails extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Orders");

    private DatePickerDialog.OnDateSetListener datepickerlistner;
    String product,date,size,time;
    ImageView calander ;
    TextView tv_product,tv_date;
    Button clickMe;

    Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        tv_product = findViewById(R.id.tv_Product);
        tv_date = findViewById(R.id.tv_Size);
        calander = findViewById(R.id.img_calendar);
        clickMe = findViewById(R.id.clickButton);

        order = new Order();
        product = getIntent().getStringExtra("Product");

        order.setProductdescription(product);
        tv_product.setText(order.productdescription);



        calander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(orderDetails.this, "clicked", Toast.LENGTH_SHORT).show();
                // Access the calendar
                Calendar datpickerCal = Calendar.getInstance();
                int year = datpickerCal.get(Calendar.YEAR);
                int month  = datpickerCal.get(Calendar.MONTH);
                int day = datpickerCal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog ordersDatePicker = new DatePickerDialog(orderDetails.this,
                        android.R.style.Theme_Light_Panel,datepickerlistner,year,month,day);

                ordersDatePicker.show();

            }
        });

        datepickerlistner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {

                date = year+" "+month+" "+day ;
                tv_date.setText(date);
                order.setDate(date);

            }
        };

        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                myRef.push().setValue(order);
                Intent processOrder = new Intent(orderDetails.this,ProcessOrder.class);
                startActivity(processOrder);

            }
        });








    }
}
