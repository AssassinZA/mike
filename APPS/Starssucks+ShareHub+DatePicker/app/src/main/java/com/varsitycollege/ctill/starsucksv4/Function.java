package com.varsitycollege.ctill.starsucksv4;

import android.content.Context;
import android.content.Intent;

public class Function
{

    public void openIntent(Context context,String order)
    {
        Intent i = new Intent(context,OrderDetails.class);
        i.putExtra("order",order);
        context.startActivity(i);
    }


}
