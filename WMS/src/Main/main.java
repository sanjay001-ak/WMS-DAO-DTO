package Main;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;

import javax.swing.text.StyledEditorKit;

import DAO.*;
import DTO.*;
import Database.DBConnection;


public class main {

    static depositDAO deposit_imp         = new depositImp();
    static plastic_detailsDAO plastic_imp = new plastic_detailsImp();
    static user_detailsDAO user_imp       = new user_detailsImp();
    static withdrawDAO withdraw_imp       = new withdrawImp();
    static staff_detailsDAO staff_imp     = new staff_detailsImp();
    static admin_detailsDAO admin_imp     = new admin_detailsImp();
    static MRFDAO mrf_imp                 = new MRFImp();
    static inventoryDAO inventory_imp     = new inventoryImp();
    static MRF_transactionDAO mrft_imp    = new MRF_transactionImp();

    static Deposit deposit         = new Deposit();
    static User_details us         = new User_details();
    static Plastic_details plastic = new Plastic_details();
    static Withdraw withdraw       = new Withdraw();
    static Staff_details staff     = new Staff_details();
    static Admin_details admin     = new Admin_details();
    static MRF mrf                 = new MRF();
    static Inventory inventory     = new Inventory();
    static MRF_transaction mrf_t   = new MRF_transaction();

    static Admin_view av           = new Admin_view();

    public static void main(String[] args) throws Exception{
        Scanner sc= new Scanner(System.in);
        System.out.println("\n------------------------------------------------------------\n");
        System.out.println("----------  WELCOME  TO WASTE MANAGEMENT SYSTEM  ----------");
        System.out.println("               LET'S MAKE THE EARTH GREEN !!");
        System.out.println("\n------------------------------------------------------------\n");
        System.out.println("Enter any option to proceed forward....\n\n");
        int choice = 0;
        boolean b;
        do{
            do{
                System.out.println("\n1 --> SIGN-UP \n2 --> LOG-IN \n3 --> Exit \n\n");
                System.out.print("Enter your choice : ");
                choice = sc.nextInt();
                if(choice>4){
                    b=true;
                    System.out.println("\n-----------------------INVALID CHOICE-----------------------\n");
                }
                else{b=false;}
            }while(b);

            if(choice ==1){

                System.out.print("\nEnter  Name : ");
                String name =sc.next();
                b=true;
                String email ="";
                do{
                    System.out.print("\nEnter  Email-ID : ");
                    email = sc.next();
                    us.setemail_id(email);
                    b=user_imp.existemail(us);
                    if(!Pattern.matches("^[a-z0-9]{6,}@[a-z]+\\.com$", email)){
                        System.out.println("\n------------------------------------------------------------\n");
                        System.out.println("\n\nInvalid Email-ID\n");
                        System.out.println("\n------------------------------------------------------------\n");
                        b=false;
                    }
                    else if(b){
                        System.out.println("\n------------------------------------------------------------\n");
                        System.out.println("\n\nEmail Already Exists\n");
                        System.out.println("\n------------------------------------------------------------\n");
                        b=false;
                    }else{
                        b=true;
                    }
                }while(!b);
                System.out.print("\nEnter password : ");
                String pass=sc.next();
                String aadhar="";
                do{
                    System.out.print("\nEnter  Aadhar Number : ");
                    aadhar=sc.next();
                    if(!Pattern.matches("^[0-9]{12}", aadhar)){
                        System.out.println("\n------------------------------------------------------------\n");
                        System.out.println("\n\nInvalid Aadhar Number\n");
                        System.out.println("\n------------------------------------------------------------\n");
                        b=true;
                    }
                    else{
                        b=false;
                    }
                }while(b);
                String phone="";
                do{
                    System.out.print("\nEnter  Phone Number : ");
                    phone=sc.next();
                    if(!Pattern.matches("^[0-9]{10}", phone)){
                        System.out.println("\n------------------------------------------------------------\n");
                        System.out.println("\n\nInvalid Phone Number\n");
                        System.out.println("\n------------------------------------------------------------\n");
                        b=true;
                    }
                    else{
                        b=false;
                    }

                }while(b);
                us.setname(name);
                us.setemail_id(email);
                us.setpassword(pass);
                us.setaadhar(aadhar);
                us.setphone(phone);
                if(user_imp.insert(us)){
                    System.out.println("\n------------------------------------------------------------\n");
                    System.out.println("\n\nSuccess Fully Added\n");
                    System.out.println("\n------------------------------------------------------------\n");
                }
                else{
                    System.out.println("\n------------------------------------------------------------\n");
                    System.out.println("\n\nSign up Falied\n");
                    System.out.println("\n------------------------------------------------------------\n");
                }
            }
            if(choice==1 || choice ==2){
                System.out.println("\n------------------------------------------------------------\n");
                System.out.println("Please Log-in to proceed forward !!");
                System.out.println("\n------------------------------------------------------------\n");
                int role;
                do{
                    System.out.println("1 --> Admin \n2 --> Staff\n3 --> User\n4 --> MRF Company\n");
                    System.out.print("Enter your Role : ");
                    role=sc.nextInt();
                    if(role>5 || role<=0){
                         System.out.println("\n-----------------------INVALID CHOICE-----------------------\n");
                         b=true;
                    }
                    else{
                        b=false;
                    }
                }while(b);
                if(role==1){
                    av.admin_function();
                }
                else if(role==2){
                    //staff
                }
                else if(role==3){
                    //user
                }
                else{
                    //mrf
                }
            }
        }while(choice!=3);

    }
}
