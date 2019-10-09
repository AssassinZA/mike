package com.varsitycollege.ctill.starsucks;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OrderTextbox extends AppCompatActivity {

    private static final String TAG = "FirebaseDATA";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Orders");
    Button btnPull;
    TextView FirebaseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_textbox);

        FirebaseData= findViewById(R.id.FirebaseData);
        btnPull = findViewById(R.id.btnPullTextbox);



        btnPull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                        for(DataSnapshot child  :children)
                        {

                            Order order = child.getValue(Order.class);
                            String value = order.getProductdescription();
                            FirebaseData.setText(value);


                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

    }


}
