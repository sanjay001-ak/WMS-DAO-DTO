package DTO;
public class Plastic_details {
    
    private int id;
    private String name;
    private int amount;

    public Plastic_details(){}

    
    public Plastic_details(int id, String name, int amount){
        this.id=id;
        this.name=name;
        this.amount=amount;
    }

    public void setname(String name){
        this.name=name;
    }

    public String getname(){
        return name;
    }
    public void setid(int id){
        this.id=id;
    }

    public int getid(){
        return id;
    }
    public void setamount(int amount){
        this.amount=amount;
    }
    public int getamount(){
        return amount;
    }
}
