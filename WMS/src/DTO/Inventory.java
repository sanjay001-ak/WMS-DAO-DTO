package DTO;

import java.sql.Date;

public class Inventory {
    
    private Date date;
    private int waste_id;
	private int waste_income;
	private int waste_sold;
	private int waste_instock;
    private String name;
    private int amount;
    
    public Inventory(){}

    public Inventory(java.util.Date date2, int waste_id, String name, int waste_income, int waste_sold, int waste_instock, int amount){
        this.date=(Date) date2;
        this.waste_id=waste_id;
        this.name=name;
        this.waste_income=waste_income;
        this.waste_sold=waste_sold;
        this.waste_instock=waste_instock;
        this.amount=amount;
    }

    public Inventory(int waste_id, int waste_instock, String name, int amount){
        this.waste_id=waste_id;
        this.name=name;
        this.amount=amount;
        this.waste_instock=waste_instock;
    }

    
    public Inventory(Date date, int waste_id, int waste_income, int waste_sold, int waste_instock) {
        this.date = date;
        this.waste_id = waste_id;
        this.waste_income = waste_income;
        this.waste_sold = waste_sold;
        this.waste_instock = waste_instock;
    }
    

    public void setdate(Date date){
        this.date=date;
    }
    public Date  getdate(){
        return date;
    }
    public void setwaste_id(int waste_id){
        this.waste_id=waste_id;
    }

    public int getwaste_id(){
        return waste_id;
    }
    public void setwaste_income(int waste_income){
        this.waste_income=waste_income;
    }

    public int getwaste_income(){
        return waste_income;
    }
    public void setwaste_sold(int waste_sold){
        this.waste_sold=waste_sold;
    }

    public int getwaste_sold(){
        return waste_sold;
    }
    public void setwaste_instock(int waste_instock){
        this.waste_instock=waste_instock;
    }

    public int getwaste_instock(){
        return waste_instock;
    }
    public void setamount(int amount){
        this.amount=amount;
    }

    public int getamount(){
        return amount;
    }
    public void setanme(String name){
        this.name=name;
    }

    public String getname(){
        return name;
    }
}
