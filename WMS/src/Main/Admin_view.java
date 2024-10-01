package Main;

import java.sql.SQLException;
import java.util.*;

import DAO.admin_detailsDAO;
import DAO.admin_detailsImp;
import DAO.user_detailsDAO;
import DAO.user_detailsImp;
import DTO.Admin_details;
import DTO.User_details;

public class Admin_view {

    
    static admin_detailsDAO admin_imp     = new admin_detailsImp();
    static Admin_details admin     = new Admin_details();
    static user_detailsDAO user_imp = new user_detailsImp();


    public void admin_function() throws SQLException{
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\nEnter Email-ID : ");
        String email=sc.next();
        System.out.print("Enter Password : ");
        String pass=sc.next();
        admin.setemail_id(email);
        admin.setpassword(pass);
        boolean b=admin_imp.admin_login(admin)  ;
        if(b){
            System.out.println("\n------------------------------------------------------------");
            System.out.println("\n\nInvalid Email_ID or Password");
            System.out.println("\n------------------------------------------------------------\n");
        }
        else{
            System.out.println("\n-----------------Welcome Admin !!-----------------\n");
            int user_choice;
            do{
                System.out.println("1 --> Show user Details\n2 --> Show Staff Details\n3 --> Show Transaction List\n4 --> Change plastic Rate\n5 --> Add New Plastic item\n6 --> Add Member\n7 --> Fire a Staff\n8 --> Add a MRF Company\n9 --> Show Invantory\n10 --> Log-Out\n11 --> Exit");
                System.out.print("\nEnter your choice : ");
                user_choice=sc.nextInt();
                if(user_choice==1){
                    List<User_details> al=user_imp.retrieveAll();
                    for (User_details element : al) {
                        System.out.println("\n------------------------------------------------------------\n\n");
                        System.out.println("Name : "+element.getname());
                        System.out.println("Email -ID : "+element.getemail_id());
                        System.out.println("Adhar Number : "+element.getaadhar());
                        System.out.println("Phone Number : "+element.getphone());
                        System.out.println("Total Balance : "+element.gettot_bal());
                        System.out.println("Total Waste : "+element.gettot_waste());

                    }
                }
                else if(user_choice==2){
                    //c.staff_list();
                }
                else if(user_choice==3){
                   // c.transaction_list();
                }
                else if(user_choice==4){
                    //change_rate();
                }
                else if(user_choice==5){
                    //add_item();
                }
                else if(user_choice==6){
                    //add_member();
                }
                else if(user_choice==7){
                    //delete_worker();
                }
                else if(user_choice==8){
                    //add_mrf();
                }
                else if(user_choice==9){
                    //c.show_invan(1);
                }
                else if(user_choice==10){
                    //login(email);
                }
                System.out.println("\n------------------------------------------------------------\n");
            }while(user_choice!=10);
        }

    }
}
