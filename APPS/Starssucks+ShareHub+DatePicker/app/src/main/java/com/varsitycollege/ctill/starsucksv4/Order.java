package com.varsitycollege.ctill.starsucksv4;

public class Order
{

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

    String userName;
    String date;
    String placedOrder;

}
