package com.varsitycollege.ctill.starsucks;

import android.widget.ImageView;

public class Function
{

    public boolean imageClicked (ImageView img)
    {

        if (!img.isSelected())
        {
            return false;
        }

        else
        {
            return true ;
        }

    }

    public String displayImgMessage(String message)
    {
        return message;
    }


}
