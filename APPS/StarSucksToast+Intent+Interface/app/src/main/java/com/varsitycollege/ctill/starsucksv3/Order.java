package com.varsitycollege.ctill.starsucksv3;

public class Order
{

    //getters and Setters: Firebase
    private String productName;
    private String customerName;
    private String customerCell;
    private String orderDate;

    //Default Constructor
    public Order() { }

    /*Constructor : minimum requirements for an oder
    * No order should be created without a productName,
    * customerName, and orderDate
    * This avoids Null values :-)*/
    public Order(String productName, String customerName, String orderDate) {
        this.productName = productName;
        this.customerName = customerName;
        this.orderDate = orderDate;
    }

    /*Overloaded constructor to allow an order to be created with
    * an added Cellphone Number*/
    public Order(String productName, String customerName,
                 String customerCell, String orderDate) {
        this.productName = productName;
        this.customerName = customerName;
        this.customerCell = customerCell;
        this.orderDate = orderDate;
    }


    /*Getter and Setter methods for each property to provide
    * flexibility (might seem redundant but wait... We will need
    * for Firebase*/
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCell() {
        return customerCell;
    }

    public void setCustomerCell(String customerCell) {
        this.customerCell = customerCell;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

}
