package com.company;

public class Payment {

    private int id;
    private double amount;
    private String category;
    private int month;
    private int year;

    public Payment(int id, double amount, String category, int month, int year) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.month = month;
        this.year = year;
    }
    public  Payment()
    {

    }


    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String displayAmount(){
      return   this.getId() + " [" + this.getAmount() +","+this.getCategory() +","+this.getYear() +","+ this.getMonth()+ "]";

    }


}

