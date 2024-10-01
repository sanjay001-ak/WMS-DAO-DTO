package DTO;
public class MRF {
    private String company_name;
	private int company_id;
	private String email_id;
	private String password;
	private String incharge_name;
	private String phone;
	private String address;

    public MRF(){}

    MRF( String company_name, int company_id, String email_id, String password, String incharge_name, String phone, String address){
        this.company_name=company_name;
        this.company_id=company_id;
        this.email_id=email_id;
        this.password=password;
        this.incharge_name=incharge_name;
        this.phone=phone;
        this.address=address;
    }

    public void setcompany_name(String company_name){
        this.company_name=company_name;
    }
    public String getcompany_name(){
        return company_name;
    }
    public void setcompany_id(int company_id){
        this.company_id=company_id;
    }
    public int getcompany_id(){
        return company_id;
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
    public void setincharge_name(String incharge_name){
        this.incharge_name=incharge_name;
    }
    public String getincharge_name(){
        return incharge_name;
    }
    
    public void setaddress(String address){
        this.address=address;
    }
    public String getaddress(){
        return address;
    }

    
}
