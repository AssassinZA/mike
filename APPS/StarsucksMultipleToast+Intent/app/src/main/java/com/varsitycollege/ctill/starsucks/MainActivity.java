package com.varsitycollege.ctill.starsucks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    ImageView img_sb1,img_sb2,img_sb3,img_sb4,img_sb5,img_sb6 ;
    Function function;
    String message;

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

        function = new Function();
        
        img_sb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                switch(v.getId())
                {
                    case R.id.img_sb1:
                        if (function.imageClicked(img_sb1))
                        {
                            message = function.displayImgMessage("Yeah Soy Latte");
                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.img_sb2:
                        if (function.imageClicked(img_sb2))
                        {
                            message = function.displayImgMessage("MMMM Choco Frapp");
                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                        }
                }

            }
        });
    }
}
