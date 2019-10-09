package com.varsitycollege.ctill.starsucks;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ProcessOrder  extends AppCompatActivity
{

    final static String TAG = "Pulled from DB";
    ListView lstViewPlacedOrders;
    List<String> lstPlacedOrders;
    Button btnView;

    ArrayAdapter<String> orderArrayAdapter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Orders");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_order);

        lstViewPlacedOrders = findViewById(R.id.lstViewOrder);
        btnView = findViewById(R.id.btnview);
        lstPlacedOrders = new ArrayList<String>();

        myRef.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {

               Iterable<DataSnapshot> children = dataSnapshot.getChildren();

               for(DataSnapshot child  :children)
               {
                  Log.i(TAG, "Chidren in Datasnapshot : " + child);
                   Order order = child.getValue(Order.class);
                   Log.i(TAG, "Added to order : "+child.getValue());
                   Log.i(TAG, "Data in order object: "+order);
                   lstPlacedOrders.add(order.toString());
               }


                orderArrayAdapter = new ArrayAdapter<String>(ProcessOrder.this,
                        android.R.layout.simple_list_item_1,lstPlacedOrders);

                lstViewPlacedOrders.setAdapter(orderArrayAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    btnView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(),OrderTextbox.class);
            startActivity(i);
        }
    });



    }
}
