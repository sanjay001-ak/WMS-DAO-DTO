package DTO;
public class Admin_details {
    private String name;
	private String email_id;
    private String password;
    private int admin_id;
	private String phone;   
	private String aadhar;
    private String doj;
    
    public Admin_details(){}


    public  Admin_details(String name, String email_id,String password, int admin_id, String phone, String aadhar, String doj){
        this.name=name;
        this.email_id=email_id;
        this.password=password;
        this.admin_id=admin_id;
        this.phone=phone;
        this.aadhar=aadhar;
        this.doj=doj;
    }

    public void setname(String name){
        this.name=name;
    }

    public String getname(){
        return name;
    }
    public void setemail_id(String email_id){
        this.email_id=email_id;
    }

    public String getemail_id(){
        return email_id;
    }
    public void setpassword(String password){
        this.password=password;
    }

    public String getpassword(){
        return password;
    }
    public void setadmin_id(int admin_id){
        this.admin_id=admin_id;
    }

    public int getadmin_id(){
        return admin_id;
    }
    public void setphone(String phone){
        this.phone=phone;
    }

    public String getphone(){
        return phone;
    }
    public void setaadhar(String aadhar){
        this.aadhar=aadhar;
    }

    public String getaadhar(){
        return aadhar;
    }
    public void setdoj(String doj){
        this.doj=doj;
    }

    public String  getdoj(){
        return doj;
    }
}
