package DTO;

import java.sql.Date;
import java.sql.Time;

public class Withdraw {
    
    private String email_id;
    private Date date;
    private Time time;
    private int amount;

    public Withdraw(){}
    
    public Withdraw(String email_id, Date date, Time time, int amount){
        this.email_id=email_id;
        this.date=date;
        this.time=time;
        this.amount=amount;
    }

    public void setemail_id(String email_id){
        this.email_id=email_id;
    }

    public String getemail_id(){
        return email_id;
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
    public void setamount(int amount){
        this.amount=amount;
    }
    public int getamount(){
        return amount;
    }
}
