package DTO;
/**
 * User_details
 */
public class User_details {

    private String name;
	private String email_id;
    private String password;
	private String phone;
	private String aadhar;
	private int tot_bal;
	private int tot_waste;

    public User_details(){}
    public User_details(String name, String email_id,String password, String phone, String aadhar, int tot_bal, int tot_waste){
        this.name=name;
        this.email_id=email_id;
        this.password=password;
        this.phone=phone;
        this.aadhar=aadhar;
        this.tot_bal=tot_bal;
        this.tot_waste=tot_waste;
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
    public void settot_bal(int tot_bal){
        this.tot_bal=tot_bal;
    }

    public int  gettot_bal(){
        return tot_bal;
    }
    public void settot_waste(int tot_waste){
        this.tot_waste=tot_waste;
    }

    public int gettot_waste(){
        return tot_waste;
    }

}