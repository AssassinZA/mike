package com.varsitycollege.ctill.starsucksv4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class OrderDetails extends AppCompatActivity {

    EditText name;
    TextView placedOrder;
    Button btn_placeOrder,btn_shareOrder;
    String order,date, userName;
    ImageView img_date;
    Order firebaseOrder;
    private DatePickerDialog.OnDateSetListener datepickerlistner;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");


    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "I have started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        firebaseOrder = new Order();
        name = findViewById(R.id.et_name);
        placedOrder = findViewById(R.id.tv_placedOrder);
        btn_shareOrder = findViewById(R.id.btn_shareOrder);
        btn_placeOrder = findViewById(R.id.btn_placeOrder);
        img_date = findViewById(R.id.img_date);

        order = getIntent().getStringExtra("order");


        placedOrder.setText(order);
        firebaseOrder.setPlacedOrder(order);



        img_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Calendar datpickerCal = Calendar.getInstance();
                int year = datpickerCal.get(Calendar.YEAR);
                int month  = datpickerCal.get(Calendar.MONTH);
                int day = datpickerCal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog ordersDatePicker = new DatePickerDialog(OrderDetails.this,
                        android.R.style.Theme_Light_Panel,datepickerlistner,year,month,day);

                ordersDatePicker.show();
            }
        });

        datepickerlistner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year,
                                  int month, int day)
            {

                date = year+" "+ (month +1) +" "+day ;
                firebaseOrder.setDate(date);

            }
        };

        btn_shareOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, order);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

            }
        });


        btn_placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                userName = name.getText().toString();
                Toast.makeText(OrderDetails.this, userName, Toast.LENGTH_SHORT).show();
                firebaseOrder.setUserName(userName);
                myRef.push().setValue(firebaseOrder);
            }
        });





    }
}
