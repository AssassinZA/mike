package com.varsitycollege.ctill.starsucksv3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.List;

public class IntentHelper
{
/*This class assists the application with intents accross all activities
* it has the following functionaliyt:
* 1. It opens new Activities
* 2. It opens the Sharehub to share text via an Intent
* 3. It opens other applications on the device with Intents*/

    public void openIntent(Context context, String order, Class passTo)
    {
        Intent i = new Intent(context, passTo);
        i.putExtra("order", order);
        context.startActivity(i);
    }

    public void shareIntent(Context context, String order)
    {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, order);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        context.startActivity(shareIntent);

    }


    public void shareIntent(Context context, String productName,
                            String customerName, String customerCell)
    {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        Bundle shareOrderDetails = new Bundle();
        shareOrderDetails.putString("productName" ,productName);
        shareOrderDetails.putString("customerName" ,customerName);
        shareOrderDetails.putString("customerCell", customerCell);

        sendIntent.putExtra(Intent.EXTRA_TEXT, shareOrderDetails);
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        context.startActivity(shareIntent);

    }



}


