package com.varsitycollege.ctill.starsucksv4;

public class Order
{
    String userName;
    String date;
    String placedOrder;

    public Order () {}

    public Order (String userName, String date)
    {
        this.userName = userName;
        this.date = date;
    }

    public Order(String userName, String date, String placedOrder) {
        this.userName = userName;
        this.date = date;
        this.placedOrder = placedOrder;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlacedOrder() {
        return placedOrder;
    }

    public void setPlacedOrder(String placedOrder) {
        this.placedOrder = placedOrder;
    }
}
