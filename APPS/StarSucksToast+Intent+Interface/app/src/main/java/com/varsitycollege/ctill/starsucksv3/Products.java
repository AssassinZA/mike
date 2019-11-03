package com.varsitycollege.ctill.starsucksv3;

import java.util.List;

public class Products
{

    private String productName;
    private String productDescription;
    List<Products> products;


    public Products() { }

    public Products(String productName, String productDescription) {
        this.productName = productName;
        this.productDescription = productDescription;
    }


    public String  getProducts(String orderdValue)
    {
        String returnValue=null;
        products.add(new Products("Soy Frappe",
                "StarSucks Soy based Frap"));
        products.add(new Products("Chocolate Frappe",
                "StarSucks Choc based Frap"));
        products.add(new Products("Bottled Frappe",
                "StarSucks bottled based Frap"));
        products.add(new Products("Rainbow",
                "StarSucks rainbow based Frap"));
        products.add(new Products("Black Forest Frappe",
                "StarSucks rainbow based Frap"));
        products.add(new Products("Christmas Frappe",
                "Merry Chirstmas"));


        for (Products productName: products)
        {

            if (productName.equals(orderdValue))
            {
                returnValue = orderdValue;
            }

        }

        return returnValue;
    }



}






