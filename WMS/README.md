## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).




 /* System.out.println("bal is " + bal);
        int wsate=user_imp.tot_waste( us);
        System.out.println("waste is " + wsate); */
        
        //withdraw
        
        /* us.setemail_id("y@gmail.com");
        int bal=user_imp.check_bal( us);
        withdraw.setemail_id("y@gmail.com");
        System.out.print("\nEnter amount to Withdraw : ");
        int amount = sc.nextInt();
        withdraw.setamount(amount);
        int w=user_imp.withdraw(us, amount);
        if(w==1){
            System.out.println(w);
            bal=user_imp.check_bal( us);
            System.out.println("bal is " + bal); 

            //in withdraw imp and dao
            System.out.println("Add withdrwa " +withdraw_imp.addwithdraw(withdraw));
            
            List a=withdraw_imp.getwithdrawList(withdraw);
            System.out.println(((Withdraw) a.get(0)).getamount());
        }
        else{
            System.out.println("Insuffecient bal");
        }
        
        //deposit 

        System.out.print("\nEnter  Email-ID : ");
        String email = sc.next();
        System.out.print("Enter Waste Id : ");
        int w_id=sc.nextInt();
        System.out.print("Enter Waste Weight : ");
        int weight=sc.nextInt();
        deposit.setemail_id(email);
        deposit.setwaste_id(w_id);
        //to get amount in plastic 
        plastic.setid(w_id);
        amount=plastic_imp.getamount(plastic);
        deposit.setamount(amount);
        deposit.setwaste_quantity(weight);
        deposit.setstaff_id(1);
        System.out.println(deposit_imp.addtransaction(deposit));
        System.out.println( user_imp.deposit(deposit));
        //deposit history
        deposit.setemail_id(email);
        List al=deposit_imp.getHistory(deposit);
        System.out.println(((Deposit) al.get(0)).getamount()); */

        //add staff


        //staff list
       /*  List al=staff_imp.show_staff(staff);
        System.out.println(((Staff_details) al.get(0)).getname());

        System.out.println("name : ");
        String name=sc.next();
        System.out.println("email_id : ");
        String email_id=sc.next();
        System.out.println("password : ");
        String password=sc.next();
        System.out.println("admin_id : ");
        int admin_id=sc.nextInt();
        System.out.println("phone : ");
        String phone=sc.next();
        System.out.println("aadhar : ");
        String aadhar=sc.next();
        System.out.println("branch : ");
        String branch=sc.next();

        staff.setname(name);
        staff.setemail_id(email_id);
        staff.setpassword(password);
        staff.setadmin_id(admin_id);
        staff.setphone(phone);
        staff.setaadhar(aadhar);
        staff.setbranch(branch);

        System.out.println("Staff Added : "+staff_imp.add_staff(staff)); */


        //change plastic rates
       /*  System.out.println("Enter plastic Id");
        int id=sc.nextInt();
        System.out.println("Enter amount to change");
        int amount=sc.nextInt();
        plastic.setid(id);
        plastic.setamount(amount);

        System.out.println("Chnage plastic " +plastic_imp.change_rate(plastic)); */

        //add plastic rates
        
        
        /* System.out.println("Enter plastic Nmae");
        String name=sc.next();
        System.out.println("Enter amount to change");
        int amount=sc.nextInt();
        plastic.setname(name);
        plastic.setamount(amount);
        System.out.println("New  plastic " +plastic_imp.add_plastic(plastic)); */

        //add admin

        /* System.out.println("name : ");
        String name=sc.next();
        System.out.println("email_id : ");
        String email_id=sc.next();
        System.out.println("password : ");
        String password=sc.next();
        System.out.println("phone : ");
        String phone=sc.next();
        System.out.println("aadhar : ");
        String aadhar=sc.next();

        admin.setname(name);
        admin.setemail_id(email_id);
        admin.setpassword(password);
        admin.setphone(phone);
        admin.setaadhar(aadhar);

        System.out.println("Admin aades : "+admin_imp.add_admin(admin)); */
        

        //delete staff

        /* System.out.println("email_id : ");
        String email_id=sc.next();
        staff.setemail_id(email_id);
        System.out.println("Staff removed : "+staff_imp.delete_staff(staff));*/

        //add mrf

       /*  System.out.println("company_name : ");
        String company_name=sc.next();

        System.out.println("company_id : ");
        int company_id=sc.nextInt();
        System.out.println("email_id : ");
        String email_id=sc.next();
        System.out.println("password : ");
        String password=sc.next();
        System.out.println("phone : ");
        String phone=sc.next();
        System.out.println("incharge_name : ");
        String incharge_name=sc.next();
        System.out.println("address : ");
        String address=sc.next();

        mrf.setcompany_name(company_name);
        mrf.setcompany_id(company_id);
        mrf.setemail_id(email_id);
        mrf.setpassword(password);
        mrf.setphone(phone);
        mrf.setincharge_name(incharge_name);
        mrf.setaddress(address);

        System.out.println("MRF Added : "+mrf_imp.add_mrf(mrf)); */

        //show inventory

        //deposit 

        /* System.out.print("\nEnter  Email-ID : ");
        String email = sc.next();
        System.out.print("Enter Waste Id : ");
        int w_id=sc.nextInt();
        System.out.print("Enter Waste Weight : ");
        int weight=sc.nextInt();
        deposit.setemail_id(email);
        deposit.setwaste_id(w_id);
        //to get amount in plastic 
        plastic.setid(w_id);
        int amount=plastic_imp.getamount(plastic);
        deposit.setamount(amount);
        deposit.setwaste_quantity(weight);
        deposit.setstaff_id(1);
        System.out.println(deposit_imp.addtransaction(deposit));
        System.out.println( user_imp.deposit(deposit));
        //deposit history
        deposit.setemail_id(email);
        List al=deposit_imp.getHistory(deposit);
        System.out.println(((Deposit) al.get(0)).getamount());
        
        //add in inventory
        inventory.setwaste_id(w_id);
        inventory.setwaste_income(weight);
        
        System.out.println("Add inventory"+inventory_imp.add_inventory(inventory)); */

        //show plastic

        /* List al=plastic_imp.show_plastic(plastic);
        System.out.println(((Plastic_details) al.get(0)).getname());
        System.out.println(((Plastic_details) al.get(1)).getname()); */

       /*  //show invan
        List al=inventory_imp.show_inventory(inventory, 1);
        System.out.println(((Inventory) al.get(0)).getname()); */

        //mrf buying waste

        
       /*  System.out.println("Enter plastic Id");
        int id=sc.nextInt();
        System.out.println("Enter quantity");
        int weight=sc.nextInt();

        inventory.setwaste_id(id);
        inventory.setwaste_sold(weight);
        if(inventory_imp.buy_waste(inventory)){
            System.out.println("update success");
        //add in mrf_transaction
        plastic.setid(id);
        int amount = plastic_imp.getamount(plastic)*weight;
        mrf_t.setamountpaid(amount);
        mrf_t.setc_id(1);
        mrf_t.setwaste_id(id);
        mrf_t.setwaste_quantity(weight);
        System.out.println("MRF_Transaction added "+mrft_imp.add_mrf_t(mrf_t));
        }
        else{
            System.out.println("Upadate faild");
        }
 */
        //login

        System.out.println("Enter role :");
        int role=sc.nextInt();
        System.out.println("Enter email :");
        String email=sc.next();
        System.out.println("Enter pass :");
        String pass=sc.next();
        if(role==1){
            admin.setemail_id(email);
            admin.setpassword(pass);
            System.out.println(admin_imp.admin_login(admin));
        }
        if(role==2){
            staff.setemail_id(email);
            staff.setpassword(pass);
            System.out.println(staff_imp.staff_login(staff));
        }
        if(role==3){
            us.setemail_id(email);
            us.setpassword(pass);
            System.out.println(user_imp.user_login(us));
        }
        if(role==4){
            mrf.setemail_id(email);
            mrf.setpassword(pass);
            System.out.println(mrf_imp.mrf_login(mrf));
        }
