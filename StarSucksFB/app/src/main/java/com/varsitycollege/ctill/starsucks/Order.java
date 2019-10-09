package com.varsitycollege.ctill.starsucks;

@SuppressWarnings("MagicConstant")
public class Order
{

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    String productdescription;
    String date;




    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String toString()
    {

        return "Product " + productdescription;
    }




}
