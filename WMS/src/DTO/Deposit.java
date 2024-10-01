package DTO;

import java.sql.Date;
import java.sql.Time;

public class Deposit {
  
    private String email_id;
    private int staff_id;
    private Date date;
    private Time time;
    private int waste_id;
    private int waste_quantity;
    private int amount;
    public Deposit(){}
    public Deposit(String email_id, int staff_id, Date date, Time time, int waste_id, int waste_quantity, int amount){
        this.email_id=email_id;
        this.staff_id=staff_id;
        this.date=date;
        this.time=time;
        this.waste_id=waste_id;
        this.waste_quantity=waste_quantity;
        this.amount=amount;
    }

    public void setemail_id(String email_id){
        this.email_id=email_id;
    }

    public String getemail_id(){
        return email_id;
    }
    public void setstaff_id(int staff_id){
        this.staff_id=staff_id;
    }

    public int getstaff_id(){
        return staff_id;
    }
    public void setdate(Date date){
        this.date=date;
    }
    public Date  getdate(){
        return date;
    }
    public void settime(Time time){
        this.time=time;
    }
    public Time  gettime(){
        return time;
    }
    public void setwaste_id(int waste_id){
        this.waste_id=waste_id;
    }

    public int getwaste_id(){
        return waste_id;
    }
    public void setwaste_quantity(int waste_quantity){
        this.waste_quantity=waste_quantity;
    }

    public int getwaste_quantity(){
        return waste_quantity;
    }
    public void setamount(int amount){
        this.amount=amount;
    }

    public int getamount(){
        return amount;
    }
}
