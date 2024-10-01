package DTO;

public class MRF_transaction {
    private int c_id;
    private int waste_id;
    private int waste_quantity;
    private int amount_paid;

    public MRF_transaction(){}

    public MRF_transaction(int c_id, int waste_id, int waste_quantity, int amount_paid){
        this.c_id=c_id;
        this.waste_id=waste_id;
        this.waste_quantity=waste_quantity;
        this.amount_paid=amount_paid;
    }

    public void setc_id(int c_id){
        this.c_id=c_id;
    }

    public int getc_id(){
        return c_id;
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
    public void setamountpaid(int amount_paid){
        this.amount_paid=amount_paid;
    }

    public int getamount_paid(){
        return amount_paid;
    }
}
