import java.util.*;
import java.io.*;
public class App {
    private static ArrayList<Person> person = new ArrayList<Person>();
    private static ArrayList<Person> newPerson = new ArrayList<Person>();
    private static ArrayList<Location> location = new ArrayList<Location>();
    private static ArrayList<Request> requests = new ArrayList<Request>();
    private static boolean login = false;
    private static Person user;
    private static Scanner sc = new Scanner(System.in);

    /*
        FUNCTION NAME   : createObject()
        DESCRIPTION     : create object to insert into array
        SUB-FUNCTION OF : -
        SUB-FUNCTION(s) : -
        AVAILABLE 
        AUTHOR          : Muhammad Naim bin Abdul Jalil
    */
    public static void createObject(){
        newPerson.add(new Contributor("Jamal bin Abdullah", "012342141", "Jamal@gmail.com", "Jamal", "2001", "No 1, Jalan jalan 2", "Johor Bahru", "Johor", 85000));
        newPerson.add(new Volunteer("Vivy A/P Vishalan", "012342143", "Vivy@gmail.com", "Vivy", "2001", "No 1, Jalan jalan 2", "Johor Bahru", "Johor", 85000));
        newPerson.add(new Recipient("Ramli bin Abu", "012342321", "Ramli@gmail.com", "Ramli", "2001", "No 1, Jalan jalan 2", "Johor Bahru", "Johor", 85000));
        Location l1 = new Location("No 2-A, Jalan Delima 2", "Johor Bahru", "Johor", 82100, (Contributor)person.get(1));
        l1.addFoodItem("Pampers", 5, 9, 2, 2025);
        l1.addFoodItem("Maggie", 10, 9, 2, 2025);
        Location l2 = new Location("No 2-A, Jalan Sagu 2", "Johor Bahru", "Johor", 85000, (Contributor)person.get(4));
        l2.addFoodItem("Test kit", 40, 9, 2, 2025);
        l2.addFoodItem("Maggie", 15, 9, 2, 2025);
        location.add(l1);
        location.add(l2);
    }

    /*
        FUNCTION NAME   : main()
        DESCRIPTION     : main
        SUB-FUNCTION OF : -
        SUB-FUNCTION(s) : readFile(), createObject(), startPage(), rMainPage(), vMainPage(), adminMainPage()
        AVAILABLE 
        AUTHOR          : Radin Nazhan Bin Radin Jamzulkomar
    */
    public static void main(String[] args) throws Exception{
        readFile();
        createObject();

        do{
            if(login == false){
                startPage();
            }
            else{
                if(user instanceof Recipient){
                    rMainPage();
                }
                else if(user instanceof Volunteer){
                    vMainPage();
                }
                else if(user instanceof Contributor){
                    cMainPage();
                }
                else if(user instanceof Person){
                    adminMainPage();
                }
                
            }
        }while(true);
    }

    /*
        FUNCTION NAME   : bar()
        DESCRIPTION     : header
        SUB-FUNCTION OF : -
        SUB-FUNCTION(s) : -
        AVAILABLE 
        AUTHOR          : Muhammad Naim Bin Abdul Jalil
    */
    public static void bar(){
        clrscr();
        System.out.println("=======================================================");
        System.out.println("=======================================================");
        System.out.println("=====================  FOOD BANK  =====================");
        System.out.println("=======================================================");
        System.out.println("=======================================================\n\n");
    }

    /*
        FUNCTION NAME   : startPage
        DESCRIPTION     : start page
        SUB-FUNCTION OF : main()
        SUB-FUNCTION(s) : bar(), login(), clrscr(), registerPerson()
        AVAILABLE 
        AUTHOR          : Muhammad Naim Bin Abdul Jalil
    */
    public static void startPage(){
        int choice;
        String username, password;
        bar();
        System.out.println("[1] Login");
        System.out.println("[2] Register");
        System.out.println("\n[0] Exit\n\n\n");

        System.out.print("Option: ");
        choice = sc.nextInt();

        switch(choice){
            case 0:
                sc.close();
                System.exit(0);
                break;
            case 1:
                login();
                break;
            case 2:
                clrscr();
                registerPerson();
                break;
            case 999:
                
                bar();
                System.out.println("<< ADMIN MODE >>\n");
                System.out.print("Username: ");
                username = sc.next();
                System.out.print("Password: ");
                password = sc.next();

                if(username.equals("admin") && password.equals("admin")){
                    login = true;
                    user = new Person();
                }
                break;
            default:
                System.out.print("--- Wrong Option ---");
                pause();
                break;
        }
    }

    /*
        FUNCTION NAME   : rMainPage
        DESCRIPTION     : Recipient main page
        SUB-FUNCTION OF : main()
        SUB-FUNCTION(s) : bar(), clrscr(), requestItem(), checkRequests(), editProfile(), pause()
        AVAILABLE 
        AUTHOR          : Radin Nazhan Bin Radin Jamzulkomar
    */
    public static void rMainPage(){
        int choice;
        bar();
        System.out.println("[1] Request Items");
        System.out.println("[2] Check Requested Items");
        System.out.println("[3] Edit Profile");
        System.out.println("\n[0] Log out\n\n\n");

        System.out.print("Option: ");
        choice = sc.nextInt();

        switch(choice){
            case 0:
                login = false;
                user = null;
                break;
            case 1:
                clrscr();
                requestItem();
                break;
            case 2:
                clrscr();
                checkRequests();
                break;
            case 3:
                clrscr();
                editProfile();
                break;
            default:
                System.out.print("--- Wrong Option ---");
                pause();
                break;
        }
    }

    /*
        FUNCTION NAME   : vMainPage()
        DESCRIPTION     : volunteer main page
        SUB-FUNCTION OF : main()
        SUB-FUNCTION(s) : sendItem(), editProfile()
        AVAILABLE 
        AUTHOR          : Muhammad Aniq Aqil Bin Azrai Fahmi
    */
    public static void vMainPage(){
        int choice;
        bar();
        System.out.println("[1] Send Item Requests ");
        System.out.println("[2] Add Delivery Postal Range");
        System.out.println("[3] Edit Profile");
        System.out.println("\n[0] Log out\n\n\n");

        System.out.print("Option: ");
        choice = sc.nextInt();

        switch(choice){
            case 0:
                login = false;
                user = null;
                break;
            case 1:
                clrscr();
                sendItem();
                break;
            case 2:
                System.out.println("\n");
                System.out.print("Enter the postal code of your delivery range you want to add: ");
                int postal = sc.nextInt();
                ((Volunteer)user).addPostal(postal);
                break;
            case 3:
                clrscr();
                editProfile();
                break;
            default:
                System.out.print("--- Wrong Option ---");
                pause();
                break;
        }
    }

    /*
        FUNCTION NAME   : cMainPage()
        DESCRIPTION     : Contributer Main Page
        SUB-FUNCTION OF : main()
        SUB-FUNCTION(s) : createLocation(), addItem(), editProfile()
        AVAILABLE 
        AUTHOR          : Muhammad Aniq Aqil Bin Azrai Fahmi
    */
    public static void cMainPage(){
        int choice;
        bar();
        System.out.println("[1] Create Location");
        System.out.println("[2] Add New Item ");
        System.out.println("[3] Edit Profile");
        System.out.println("\n[0] Log out\n\n\n");

        System.out.print("Option: ");
        choice = sc.nextInt();

        switch(choice){
            case 0:
                login = false;
                user = null;
                break;
            case 1:
                clrscr();    
                createLocation();
                break;
            case 2:
                clrscr();    
                addItem();
                break;
            case 3:
                clrscr();    
                editProfile();
                break;
            default:
                System.out.print("--- Wrong Option ---");
                pause();
                break;
        }
    }

    /*
        FUNCTION NAME   : editProfile
        DESCRIPTION     : Edit user profile
        SUB-FUNCTION OF : cMainPage(), rMainPage(), vMainPage()
        SUB-FUNCTION(s) : -
        AVAILABLE 
        AUTHOR          : Dzakirin Asyraff Bin Zamsari
    */
    public static void editProfile(){
        //display users' profile
        bar();
        System.out.println("\n\n\n");
        System.out.println("[1] Edit Name");
        System.out.println("[2] Edit Username");
        System.out.println("[3] Edit Password");
        System.out.println("\n[0] Back\n\n\n");
        System.out.print("Option: ");
        int choice = sc.nextInt();
        switch(choice){
            case 0:
                break;
            case 1:
                clrscr();
                System.out.print("Enter new name: ");
                sc.nextLine();
                String name = sc.nextLine();
                user.setFullName(name);
                break;
            case 2:
                clrscr();
                System.out.print("Enter new username: ");
                String username = sc.next();
                user.setUsername(username);
                break;
            case 3:
                clrscr();
                //enter old password first
                System.out.print("Enter old password: ");
                String oldPassword = sc.next();
                if(oldPassword.equals(user.getPassword())){
                    System.out.print("Enter new password: ");
                    String newPassword = sc.next();
                    user.setPassword(newPassword);
                }else{
                    System.out.println("--- Wrong Password ---");
                    pause();
                }
                break;
            default:
                System.out.print("--- Wrong Option ---");
                pause();
                break;
        }

    }

    /*
        FUNCTION NAME   : adminMainPage
        DESCRIPTION     : A menu of functions for the Admin
        SUB-FUNCTION OF : main
        SUB-FUNCTION(s) : approveNewUser, manageRecipient, manageVolunteer, manageContributor, manageLocation
        AVAILABLE 
        AUTHOR          : Dzakirin Asyraff Bin Zamsari
    */
    public static void adminMainPage(){
        int choice;
        bar();
        System.out.println("[1] Approve New User");
        System.out.println("[2] Manage Recipient");
        System.out.println("[3] Manage Volunteer");
        System.out.println("[4] Manage Contributor");
        System.out.println("[5] Manage Location");
        System.out.println("\n[0] Log out\n\n\n");

        System.out.print("Option: ");
        choice = sc.nextInt();

        switch(choice){
            case 0:
                login = false;
                user = null;
                break;
            case 1:
                clrscr();
                approveNewUser();
                break;
            case 2:
                clrscr();
                manageRecipient();
                break;
            case 3:
                clrscr();
                manageVolunteer();
                break;
            case 4:
                clrscr();
                manageContributor();
                break;
            case 5:
                clrscr();
                manageLocation();
                break;
            default:
                System.out.print("--- Wrong Option ---");
                pause();
                break;
        }
    }

    /*
        FUNCTION NAME   : Login
        DESCRIPTION     : login into the system
        SUB-FUNCTION OF : startPage()
        SUB-FUNCTION(s) : -
        AVAILABLE 
        AUTHOR          : Radin Nazhan Bin Radin Jamzulkomar
    */
    public static void login(){
        String username, password;
        bar();

        System.out.print("Username: ");
        username = sc.next();
        System.out.print("Password: ");
        password = sc.next();

        for(int i = 0; i < person.size(); i++){
            if(username.equals(person.get(i).getUsername())){
                if(password.equals(person.get(i).getPassword())){
                    login = true;
                    user = person.get(i);
                }
                else{
                    System.out.print("Wrong password");
                    pause();
                }

                break;
            }
        }

        if(!login){
            System.out.print("Username not found");
            pause();
        }
    }


    /*
        FUNCTION NAME   : registerPerson()
        DESCRIPTION     : Registration for Volunteer, Recipient and Contributor
        SUB-FUNCTION OF : startPage()
        SUB-FUNCTION(s) : None
        AVAILABLE 
        AUTHOR          : Radin Nazhan Bin Radin Jamzulkomar
    */
    public static void registerPerson(){
        String fullName,  phoneNumber,  email,  username,  password , 
                 street,  city,  state ;
        int postalCode, choice;

        
        System.out.println("**********************************************************************");
        System.out.println("*                            Registration                            *");
        System.out.println("**********************************************************************");

        System.out.println("\nDo you want to register as ?");
        System.out.println("[1] Volunteer");
        System.out.println("[2] Recipients");
        System.out.println("[3] Contributor");
        System.out.println("[0] Back");
        
        do {
            System.out.print("Choice : ");
            choice = sc.nextInt();

            if (choice < 0 || choice > 3){
                System.out.println("Please input the right choice!");
            }
        } while (choice < 0 || choice > 3);
        
        if(choice == 0){
            return;
        }

        System.out.println("\n");
        sc.nextLine();

        System.out.println("Please input your details:");
        System.out.print("Name :");
        fullName = sc.nextLine();

        System.out.print("-- Address --\nStreet : ");
        street = sc.nextLine();  
        
        System.out.print("Postal code : ");
        postalCode = sc.nextInt();

        sc.nextLine();

        System.out.print("City : ");
        city= sc.nextLine();  

        System.out.print("State : ");
        state= sc.nextLine();

        System.out.print("Phone number : ");
        phoneNumber = sc.nextLine();

        System.out.print("Email : ");
        email = sc.nextLine();

        System.out.print("Username : ");
        username = sc.nextLine();  

        System.out.print("Password : ");
        password = sc.nextLine();

        if (choice == 1){ //Volunteer
            newPerson.add(new Volunteer(fullName, phoneNumber, email, username, password, street, city, state, postalCode));
        }
        else if (choice == 2){ // Recipient
            newPerson.add(new Recipient(fullName, phoneNumber, email, username, password, street, city, state, postalCode));
        }
        else if (choice == 3){ // Contributor
            newPerson.add(new Contributor(fullName, phoneNumber, email, username, password, street, city, state, postalCode));
        }
        

        System.out.println("-- Registration complete! --");
        pause();
    }
    


     /*
        FUNCTION NAME   : createLocation
        DESCRIPTION     : create Location of food bank
        SUB-FUNCTION OF : cMainPage
        SUB-FUNCTION(s) : -
        AVAILABLE 
        AUTHOR          : Dzakirin Asyraff Bin Zamsari
    */
    public static void createLocation(){
        String street, city, state;
        int zip;

        System.out.println("Input location information:");
        System.out.print("Street: ");
        sc.nextLine();
        street = sc.nextLine();
        System.out.print("Postcode: ");
        zip = sc.nextInt();
        sc.nextLine();
        System.out.print("City: ");
        city = sc.nextLine();
        System.out.print("State: ");
        state = sc.nextLine();
        location.add(new Location(street, city, state, zip, (Contributor) user));
        
        pause();
    }



    /*
        FUNCTION NAME   : addItem()
        DESCRIPTION     : To add item into array that has been created
        SUB-FUNCTION OF : cMainPage()
        SUB-FUNCTION(s) : none
        AVAILABLE 
        AUTHOR          : Muhammad Aniq Aqil Bin Azrai Fahmi
    */
    public static void addItem() {
        ArrayList<Location> templocal = new ArrayList<Location>();
        String name;
        int quantity,day,month,year, locationIndex;

        //display all location
        for(int i = 0; i < location.size(); i++){
            if(location.get(i).getContributor().getUsername().equals(user.getUsername())){
                templocal.add(location.get(i));
            }
        }

        if(templocal.size() == 0){
            System.out.println("No Location. Please add a location");
            pause();
            return;
        }

        for(int i = 0; i < templocal.size(); i++){
            System.out.println("[" + (i+1) + "] " + templocal.get(i).getAddress());
        }
        System.out.println("\n[0] Back\n\n\n");

        //input selected location
        do{
            System.out.print("\nSelect location: ");
            locationIndex = sc.nextInt() - 1;
            if(locationIndex < 0 || locationIndex > templocal.size()){
                System.out.println("Invalid Option");
                pause();
            }
        }while(locationIndex < -1 || locationIndex > templocal.size());
        
        
        if(locationIndex == -1){
            return;
        }

        System.out.println("Input food item information: ");
        System.out.print("Name:");
        sc.nextLine();
        name = sc.nextLine();
        System.out.print("Quantity: ");
        quantity = sc.nextInt();
        System.out.print("Expiration date:\n");
        System.out.print("Day: ");
        day = sc.nextInt();
        System.out.print("Month: ");
        month = sc.nextInt();
        System.out.print("Year: ");
        year = sc.nextInt();
        
        templocal.get(locationIndex).addFoodItem(name, quantity, day, month, year);
       pause();
    }
    
    /*
        FUNCTION NAME   : requestItem
        DESCRIPTION     : Function for recipient to request item food in a location
        SUB-FUNCTION OF : rMainPage
        SUB-FUNCTION(s) : -
        AVAILABLE 
        AUTHOR          : Muhammad Naim Bin Abdul Jalil
    */
    public static void requestItem(){
        int quantity, locationIndex, foodItemIndex, option;
        
        if(location.size() == 0){
            System.out.println("No Location in system");
            return;
        }

        while(true){
            clrscr();
            //display all location
            for(int i = 0; i < location.size(); i++){
                System.out.println( "["+ (i+1) + "] " + location.get(i).getAddress());
            }
            System.out.println("\n[0] Back\n\n");

            do{
                //select a location
                System.out.print("\nSelect location: ");
                locationIndex = sc.nextInt() - 1;
                if(locationIndex < -1 || locationIndex > location.size()){
                    System.out.println("Invalid Option");
                }
                
            }while(locationIndex < -1 || locationIndex > location.size());

            if(locationIndex == -1){
                break;
            }

            System.out.println("[1] Take at the location");
            System.out.println("[2] Delivery");
            
            do{
                System.out.print("\nOption: ");
                option = sc.nextInt();
                if(option < 1 || option > 2)
                    System.out.println("Invalid Option");

            }while(option < 1 || option > 2);

            System.out.println("\nFood list");
            System.out.println("---------");
            //display all food item in the selected location
            for(int i = 0; i < location.get(locationIndex).getFoodItemCount(); i++){
                System.out.println("["+ (i+1) + "] " + location.get(locationIndex).getFoodItems(i).getName() + "  (" + location.get(locationIndex).getFoodItems(i).getQuantity() + ")");
            }

            if(location.get(locationIndex).getFoodItemCount() == 0){
                System.out.println("No Food or Item");
                pause();
                return;
            }

            if(option == 1){
                //add request to the list of request
                requests.add(new Request(location.get(locationIndex), (Recipient) user, "Taken", requests.size()));
            }
            else if (option == 2){
                //add request to the list of request
                requests.add(new Request(location.get(locationIndex), (Recipient) user, "Pending", requests.size()));
            }

            while(true){
                //select a food item
                do{
                    System.out.print("\nSelect food item (0 - Done): ");
                    foodItemIndex = sc.nextInt() - 1;
    
                    if(foodItemIndex < -1 || foodItemIndex > location.get(locationIndex).getFoodItemCount() - 1){
                        System.out.println("Invalid Option");
                    }
    
                }while(foodItemIndex < -1 || foodItemIndex > location.get(locationIndex).getFoodItemCount() - 1);
                
                
                if(foodItemIndex == -1){
                    break;
                }
                
                //input quantity of food item
                //condition to check if the quantity is less than the available quantity
                do{
                    System.out.print("Quantity: ");
                    quantity = sc.nextInt();
                    if(quantity > location.get(locationIndex).getFoodItems(foodItemIndex).getQuantity())
                        System.out.println("Not enough quantity!");
                }while(quantity > location.get(locationIndex).getFoodItems(foodItemIndex).getQuantity());
                //update the available quantity
                location.get(locationIndex).getFoodItems(foodItemIndex).setQuantity(location.get(locationIndex).getFoodItems(foodItemIndex).getQuantity() - quantity);
                requests.get(requests.size() - 1).addRequestItem(location.get(locationIndex).getFoodItems(foodItemIndex), quantity);
            }
            break;
        }
    }

    /*
        FUNCTION NAME   : checkRequests
        DESCRIPTION     : Function for recipient to check their requests
        SUB-FUNCTION OF : rMainPage
        SUB-FUNCTION(s) : -
        AVAILABLE 
        AUTHOR          : Muhammad Naim Bin Abdul Jalil
    */
    public static void checkRequests(){
        String id;
        boolean found = false;
        //display all request
        int count = 1;
        for(int i = 0; i < requests.size(); i++){
            //condition if user is the recipient of the request
            if(requests.get(i).getRecipient().getUsername().equals(user.getUsername())){
                System.out.println((count++) + ". "  + requests.get(i).getRequestID());
                found = true;
            }
        }

        if(found == false){
            System.out.println("No requests found");
            pause();
            return;
        }

        System.out.print("Enter Request ID (0 - Back): ");
        id = sc.next();

        if(id.equals("0")){
            return;
        }
        
        found = false;
        for(int i = 0; i < requests.size(); i++){
            if(requests.get(i).getRequestID().equals(id) && requests.get(i).getRecipient().getUsername().equals(user.getUsername())){
                clrscr();
                requests.get(i).displayRequests();
                pause();
                found = true;
                break;
            }
        }

        if(found == false){
            System.out.println("Request ID not Found!");
            pause();
        }
    }
    

    /*
        FUNCTION NAME   : sendItem
        DESCRIPTION     : Function for volunteer to send item food to recipient
        SUB-FUNCTION OF : vMainPage
        SUB-FUNCTION(s) : -
        AVAILABLE 
        AUTHOR          : Muhammad Naim Bin Abdul Jalil
    */
    public static void sendItem(){
        String id;
        int opt, count;
        boolean found;

        while(true){
            clrscr();
            found = false;
            count = 1;
            for(int i=0; i < requests.size(); i++){
                if(((Volunteer)user).checkPostal(requests.get(i).getRecipient().getAddress().getPostalCode())){
                    if(requests.get(i).getStatus().equals("Pending")){
                        found = true;
                        System.out.println((count++) + ". " +requests.get(i).getRequestID());
                    }
                    
                }
            }

            if(found == false){
                System.out.println("No requests found");
                pause();
                return;
            }
    
            System.out.print("\nEnter Request ID (0 - Back): ");
            id = sc.next();

            if(id.equals("0")){
                return;
            }
            
            found = false;
            for(int i = 0; i < requests.size(); i++){
                if(requests.get(i).getRequestID().equals(id)){
                    requests.get(i).displayRequests();
                    System.out.println("\n[1] Send");
                    System.out.println("[0] Back");
                    System.out.print("Option: ");
                    opt = sc.nextInt();

                    if(opt == 1){
                        requests.get(i).setStatus("Delivered");
                    }
                    
                    found = true;
                    break;
                }
            }
    
            if(found == false){
                System.out.println("Request ID not Found!");
                pause();
            }
        }
        
    }


    /*
        FUNCTION NAME   : approveNewUser
        DESCRIPTION     : Approve new user to the system by admin
        SUB-FUNCTION OF : adminMainPage
        SUB-FUNCTION(s) : -
        AVAILABLE 
        AUTHOR          : Muhammad Naim Bin Abdul Jalil
    */
    //Approve new user - approve (obj newPerson copy to obj person, guna .remove kat newPerson)
    public static void approveNewUser(){
        int opt, temp;
        //approve new user
        while(true){
            clrscr();
            System.out.println("**********************************************************************");
            System.out.println("*                              Approval                              *");
            System.out.println("**********************************************************************");

            System.out.printf("\n\n%2s   %-30s    %-13s    %s\n","No", "Name", "Phone Number", "Email");
            for(int i = 0; i < newPerson.size(); i++){
                System.out.printf("%2d   ",(i+1));
                System.out.println(newPerson.get(i));
            }

            if(newPerson.size() == 0){
                System.out.println("No Request");
                pause();
                return;
            }

            System.out.println("\n");
            System.out.println("[1] Approve");
            System.out.println("[2] Approve All");
            System.out.println("[3] Reject");
            System.out.println("[4] Reject All");
            System.out.println("\n[0] Back\n\n\n");

            System.out.print("Option: ");
            opt = sc.nextInt();

            switch(opt){
                case 1:
                    System.out.print("Approve: ");
                    temp = sc.nextInt();

                    person.add(newPerson.get(temp - 1));
                    newPerson.remove(temp - 1);
                    break;
                case 2:
                    for(int i = newPerson.size() - 1; i >= 0; i--){
                        person.add(newPerson.get(i));
                        newPerson.remove(i);
                    }
                    break;
                case 3:
                    System.out.print("Reject: ");
                    temp = sc.nextInt();
                    newPerson.remove(temp - 1);
                    break;
                case 4:
                    for(int i = newPerson.size() - 1; i >= 0; i--){
                        newPerson.remove(i);
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid Option!");
                    pause();
                    break;
            }
        }
        
    }

    
    
    /*
        FUNCTION NAME   : manageRecipient
        DESCRIPTION     : Function to view, edit and delete recipient
        SUB-FUNCTION OF : adminMainPage
        SUB-FUNCTION(s) : viewPersons, editUsers
        AVAILABLE 
        AUTHOR          : Muhammad Aniq Aqil Bin Azrai Fahmi
    */
    public static void manageRecipient(){
        int opt, temp;
        clrscr();
        System.out.println("********************************");
        System.out.println("*       Manage Recipient       *");
        System.out.println("********************************");
        System.out.println("[1] View All Recipient");
        System.out.println("[2] Edit Recipient");
        System.out.println("[3] Remove Recipient");
        System.out.println("[0] Back");
        System.out.print("Choice : ");
        opt = sc.nextInt();
        switch(opt){
            case 1:
                clrscr();
                viewPersons(1);
                pause();
                break;
            case 2:
                //Edit Recipient
                do{
                    clrscr();
                    temp = editUsers(viewPersons(1));
                    pause();
                }while(temp != 0);
                break;
            case 3:
                //remove Recipient
                clrscr();
                person.remove(viewPersons(1));
                break;
            case 0:
                break;
            default:
                System.out.println("Please input the right choice!");
                pause();
                break;
        }
    }

    /*
        FUNCTION NAME   : manageVolunteer
        DESCRIPTION     : Function to view, edit and delete volunteer
        SUB-FUNCTION OF : adminMainPage
        SUB-FUNCTION(s) : viewPersons, editUsers
        AVAILABLE 
        AUTHOR          : Radin Nazhan Bin Radin Jamzulkomar
    */
    public static void manageVolunteer(){
        int opt, temp;
        clrscr();
        System.out.println("********************************");
        System.out.println("*       Manage Volunteer       *");
        System.out.println("********************************");
        System.out.println("[1] View All Volunteer");
        System.out.println("[2] Edit Volunteer");
        System.out.println("[3] Remove Volunteer");
        System.out.println("[0] Back");
        System.out.print("Choice : ");
        opt = sc.nextInt();
        switch(opt){
            case 1:
                clrscr();
                viewPersons(2);
                pause();
                break;
            case 2:
                //Edit Recipient
                do{
                    clrscr();
                    temp = editUsers(viewPersons(2));
                    pause();
                }while(temp != 0);
                break;
            case 3:
                //remove Recipient
                clrscr();
                person.remove(viewPersons(2));
                break;
            case 0:
                break;
            default:
                System.out.println("Please input the right choice!");
                pause();
                break;
        }
    }

    /*
        FUNCTION NAME   : manageContributor
        DESCRIPTION     : Function to view, edit and delete contributor
        SUB-FUNCTION OF : adminMainPage
        SUB-FUNCTION(s) : viewPersons, editUsers
        AVAILABLE 
        AUTHOR          : Radin Nazhan Bin Radin Jamzulkomar
    */
    public static void manageContributor(){
        int opt, temp;
        clrscr();
        System.out.println("********************************");
        System.out.println("*       Manage Contributor     *");
        System.out.println("********************************");
        System.out.println("[1] View All Contributor");
        System.out.println("[2] Edit Contributor");
        System.out.println("[3] Remove Contributor");
        System.out.println("[0] Back");
        System.out.print("Choice : ");
        opt = sc.nextInt();
        switch(opt){
            case 1:
                clrscr();
                viewPersons(3);
                pause();
                break;
            case 2:
                //Edit Recipient
                do{
                    clrscr();
                    temp = editUsers(viewPersons(3));
                    pause();
                }while(temp != 0);
                
                break;
            case 3:
                //remove Recipient
                clrscr();
                person.remove(viewPersons(3));
                break;
            case 0:
                break;
            default:
                System.out.println("Please input the right choice!");
                pause();
                break;
        }
    }

    /*
        FUNCTION NAME   : viewPersons
        DESCRIPTION     : Function to view all persons
        SUB-FUNCTION OF : manageRecipient, manageVolunteer, manageContributor
        SUB-FUNCTION(s) : displayUsers
        AVAILABLE 
        AUTHOR          : Muhammad Aniq Aqil Bin Azrai Fahmi
    */
    public static int viewPersons(int u){
        ArrayList<Person> tempP = new ArrayList<Person>();
        //this arraylist is used to store all user of selected type in a single arraylist
        //otherwise the index will be all over the place in the original person arraylist
        int opt;
        clrscr();
        System.out.println("********************************");
        System.out.println("*          View Users          *");
        System.out.println("********************************");
        System.out.printf("\n\n%2s   %-30s    %-13s    %s\n","No", "Name", "Phone Number", "Email");
        int count = 1;
        for(int i = 0; i < person.size(); i++){
            if(u==1){
                if(person.get(i) instanceof Recipient){
                    System.out.printf("%2d   ", count++);
                    System.out.println(person.get(i));
                    tempP.add(person.get(i));
                }
            }
            else if(u==2){
                if(person.get(i) instanceof Volunteer){
                    System.out.printf("%2d   ", count++);
                    System.out.println(person.get(i));
                    tempP.add(person.get(i));
                }
            }
            else if(u==3){
                if(person.get(i) instanceof Contributor){
                    System.out.printf("%2d   ", count++);
                    System.out.println(person.get(i));
                    tempP.add(person.get(i));
                }
            }
        }
        
        System.out.println("\n0 - Back");
        do{
            System.out.print("Choose: ");
            opt = sc.nextInt();
            if(opt < 0 || opt > tempP.size()){
                System.out.println("Invalid Option!");
                pause();
            }
        }while(opt < 0 || opt > tempP.size());
        
        if(opt == 0){
            return -1;
        }
        System.out.println();
        displayUsers(person.indexOf(tempP.get(opt-1)));

        return person.indexOf(tempP.get(opt-1));
    }

    /*
        FUNCTION NAME   : displayUsers
        DESCRIPTION     : Function to display all users' details
        SUB-FUNCTION OF : viewPersons(1=Recipient, 2=Volunteer, 3=Contributor)
        SUB-FUNCTION(s) : -
        AVAILABLE
        AUTHOR          : Dzakirin Asyraff Bin Zamsari
    */
    public static void displayUsers(int index){
        clrscr();
        System.out.println("Name        : " + person.get(index).getFullName());
        System.out.println("Phone number: " + person.get(index).getPhoneNumber());
        System.out.println("Email       : " + person.get(index).getEmail());
        System.out.println("Username    : " + person.get(index).getUsername());
        System.out.println("Password    : " + person.get(index).getPassword());
        System.out.println("Street      : " + person.get(index).getAddress().getStreet());
        System.out.println("City        : " + person.get(index).getAddress().getCity());
        System.out.println("State       : " + person.get(index).getAddress().getState());
        System.out.println("Postal code : " + person.get(index).getAddress().getPostalCode());

        int count = 1;
        if(person.get(index) instanceof Contributor){
            System.out.println("\nList of Location:");
            for(int i = 0; i < location.size(); i++){
                if(location.get(i).getContributor() == person.get(index))
                    System.out.println((count++) + ". " + location.get(i).getAddress());
            }
        }
    }

    /*
        FUNCTION NAME   : editUsers
        DESCRIPTION     : Function to edit users' details
        SUB-FUNCTION OF : manageRecipient, manageVolunteer, manageContributor
        SUB-FUNCTION(s) : -
        AVAILABLE
        AUTHOR          : Muhammad Aniq Aqil Bin Azrai Fahmi
    */
    public static int editUsers(int index){
        if(index == -1){
            return 0;
        }
        System.out.println("********************************");
        System.out.println("*          Edit Users          *");
        System.out.println("********************************");
        System.out.println("\n\n[1] Edit Name");
        System.out.println("[2] Edit Phone Number");
        System.out.println("[3] Edit Email");
        System.out.println("[4] Edit Username");
        System.out.println("[5] Edit Password");
        System.out.println("[6] Edit Address");
        System.out.println("[0] Back");
        System.out.print("Choice : ");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.print("Input new name: ");
                sc.nextLine();
                String name = sc.nextLine();
                person.get(index).setFullName(name);
                break;
            case 2:
                System.out.print("Input new phone number: ");
                String phoneNumber = sc.next();
                person.get(index).setPhoneNumber(phoneNumber);
                break;
            case 3:
                System.out.print("Input new email: ");
                String email = sc.next();
                person.get(index).setEmail(email);
                break;
            case 4:
                System.out.print("Input new username: ");
                String username = sc.next();
                person.get(index).setUsername(username);
                break;
            case 5:
                System.out.print("Input new password: ");
                String password = sc.next();
                person.get(index).setPassword(password);
                break;
            case 6:
                System.out.print("Input new street: ");
                sc.nextLine();
                String street = sc.nextLine();
                System.out.print("Input new city: ");
                System.out.print("Input new postal code: ");
                int postalCode = sc.nextInt();
                sc.nextLine();
                String city = sc.nextLine();
                System.out.print("Input new state: ");
                String state = sc.nextLine();
                
                person.get(index).getAddress().setStreet(street);
                person.get(index).getAddress().setCity(city);
                person.get(index).getAddress().setState(state);
                person.get(index).getAddress().setPostalCode(postalCode);
                break;
            case 0:
                break;
            default:
                System.out.println("Please input the right choice!");
                pause();
                break;
        }
            return choice;
    }
    
    /*
        FUNCTION NAME   : manageLocation
        DESCRIPTION     : Function to view, add, edit, and remove location
        SUB-FUNCTION OF : adminMainPage
        SUB-FUNCTION(s) : addLocation, editLocation 
        AVAILABLE
        AUTHOR          : Muhammad Aniq Aqil Bin Azrai Fahmi
    */
    public static void manageLocation(){
        int opt;
        //display options to do in this function
        clrscr();
        System.out.println("********************************");
        System.out.println("*       Manage Location        *");
        System.out.println("********************************");
        System.out.println("\n\n[1] Display all locations");
        System.out.println("[2] Add new location");
        System.out.println("[3] Edit location");
        System.out.println("[4] Delete location");
        System.out.println("[0] Back");
        System.out.print("Option: ");
        opt = sc.nextInt();

        switch(opt){
            case 1:
                clrscr();
                System.out.println();
                System.out.println("********************************");
                System.out.println("*       View Location          *");
                System.out.println("********************************");
                for(int i = 0; i < location.size(); i++){
                    System.out.println((i+1) + ". " + location.get(i).getAddress());
                }
                pause();
                manageLocation();
                break;
            case 2:
                clrscr();
                addLocation();
                break;
            case 3:
                clrscr();
                editLocation(opt);
                break;
            case 4:
                //delete a location in the list
                for(int i = 0; i < location.size(); i++){
                    System.out.println((i+1) + ". " + location.get(i).getAddress());
                }
                System.out.print("Select a location to delete: ");
                int index = sc.nextInt() - 1;
                location.remove(index);
                break;
            case 0:
                //back to main menu
                break;
            default:
                System.out.print("--- Wrong Option ---");
                pause();
                break;
        }
           
    }

    /*
        FUNCTION NAME   : addLocation
        DESCRIPTION     : Function to add a new location for contributor
        SUB-FUNCTION OF : manageLocation
        SUB-FUNCTION(s) : -
        AVAILABLE
        AUTHOR : Dzakirin Asyraff Bin Zamsari
    */
    public static void addLocation(){
        String street, city, state;
        int zip;
        ArrayList<Person> tempP = new ArrayList<Person>();

        System.out.println("Input location information:");
        System.out.print("Street: ");
        sc.nextLine();
        street = sc.nextLine();
        System.out.print("Postcode: ");
        zip = sc.nextInt();
        sc.nextLine();
        System.out.print("City: ");
        city = sc.nextLine();
        System.out.print("State: ");
        state = sc.nextLine();
        
        
        //display all contributors name only
        System.out.println("\nList of contributors:");
        int count = 1, index;
        do{
            for(int i = 0; i < person.size(); i++){
                if(person.get(i) instanceof Contributor){
                    System.out.println(count++ + ". " + person.get(i).getFullName() + " (" + person.get(i).getPhoneNumber() + ")");
                    tempP.add(person.get(i));
                }
            }
            System.out.print("\nSelect a contributor: ");
            index = sc.nextInt() - 1;
            //condition if user select a contributor that is not in the list
            if(index < 0 || index >= tempP.size()){
                System.out.println("Please select a contributor from the list!");
                pause();
                clrscr();
                index = -1;
                count = 1;
            }
        }while(index < 0 || index >= tempP.size());
        //create new location in the list
        location.add(new Location(street, city, state, zip, (Contributor) tempP.get(index)));
        System.out.println("Location added successfully!");
        pause();
        
    }

    /*
        FUNCTION NAME   : editLocation
        DESCRIPTION     : Function to edit a location details
        SUB-FUNCTION OF : manageLocation
        SUB-FUNCTION(s) : manageFoodItems
        AVAILABLE
        AUTHOR : Dzakirin Asyraff Bin Zamsari
    */
    public static void editLocation(int o){
        int detail, count = 1, locationIndex;
        ArrayList<Person> tempP = new ArrayList<Person>();
        //display all locations
        for(int i = 0; i < location.size(); i++){
            System.out.println((i+1) + ". " + location.get(i).getAddress());
        }

        //input selected location
        do{
            System.out.print("\nSelect location: ");
            locationIndex = sc.nextInt() - 1;
            //condition if user select a location that is not in the list
            if(locationIndex < 0 || locationIndex >= location.size()){
                System.out.println("Please select a location from the list!");
                pause();
                clrscr();
                locationIndex = -1;
            }
        }while(locationIndex < 0 || locationIndex >= location.size());
        
        //display selected location information
        System.out.println("\nAddress: " + location.get(locationIndex).getAddress());
        System.out.println("Contributor: " + location.get(locationIndex).getContributor().getFullName());
        System.out.println("             " + location.get(locationIndex).getContributor().getPhoneNumber());
        System.out.println("             " + location.get(locationIndex).getContributor().getEmail());
        System.out.println("Food items: ");
        for(int i = 0; i < location.get(locationIndex).getFoodItemCount(); i++){
            System.out.println((i+1) + ". " + location.get(locationIndex).getFoodItems(i).getName() + " " + location.get(locationIndex).getFoodItems(i).getQuantity());
        }

        if(location.get(locationIndex).getFoodItemCount() == 0){
            System.out.println("No Food Item Found");
        }

        System.out.println("\nSelect a detail to edit: ");
        System.out.println("[1] Address");
        System.out.println("[2] Contributor");
        System.out.println("[3] Food items");
        System.out.println("[0] Back");
        System.out.print("Option: ");
        detail = sc.nextInt();

        switch(detail){
            case 1:
                sc.nextLine();
                System.out.println("Input new street: ");
                String newStreet = sc.nextLine();
                System.out.print("Input new postcode: ");
                int newZip = sc.nextInt();
                sc.nextLine();
                System.out.print("Input new city: ");
                String newCity = sc.nextLine();
                System.out.print("Input new state: ");
                String newState = sc.nextLine();
                
                location.get(locationIndex).setAddress(newStreet, newCity, newState, newZip);
                break;
            case 2:
                //display all contributors name only
                System.out.println("List of contributors:");
                for(int i = 0; i < person.size(); i++){
                    if(person.get(i) instanceof Contributor){
                        System.out.println((count++) + ". " + person.get(i).getFullName());
                        tempP.add(person.get(i));
                    }
                }
                System.out.print("Select a contributor: ");
                int index = sc.nextInt() - 1;
                location.get(locationIndex).setContributor((Contributor) tempP.get(index));
                break;
            case 3:
                if(location.get(locationIndex).getFoodItemCount() == 0){
                    System.out.println("No Food Item Found");
                    pause();
                    break;
                }
                manageFoodItems(locationIndex);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid option");
                pause();
                break;
        }
                 
    }

    /*
        FUNCTION NAME : manageFoodItems
        DESCRIPTION   : Function to manage food items in a location
        SUB-FUNCTION OF : editLocation
        SUB-FUNCTION(s) : -
        AVAILABLE
        AUTHOR : Dzakirin Asyraff Bin Zamsari
    */
    public static void manageFoodItems(int index){
        // all food items are already displayed
        // input selected food item
        System.out.print("\nSelect food item: ");
        int foodItemIndex = sc.nextInt() - 1;
        // display selected food item information
        System.out.println("\nName: " + location.get(index).getFoodItems(foodItemIndex).getName());
        System.out.println("Quantity: " + location.get(index).getFoodItems(foodItemIndex).getQuantity());
        System.out.println("Expiration date: " + location.get(index).getFoodItems(foodItemIndex).getExpiredDate());
        System.out.println("\n[1] Edit");
        System.out.println("[2] Delete");
        System.out.println("[0] Back");
        System.out.print("Option: ");
        int opt = sc.nextInt();

        switch(opt){
            case 1:
                sc.nextLine();
                System.out.print("Input new name: ");
                String newName = sc.nextLine();
                System.out.print("Input new quantity: ");
                int newQuantity = sc.nextInt();
                System.out.print("Input new expiration date: ");
                int newDay = sc.nextInt();
                int newMonth = sc.nextInt();
                int newYear = sc.nextInt();
                location.get(index).getFoodItems(foodItemIndex).setName(newName);
                location.get(index).getFoodItems(foodItemIndex).setQuantity(newQuantity);
                location.get(index).getFoodItems(foodItemIndex).setExpiredDate(newDay, newMonth, newYear);
                break;
            case 2:
                location.get(index).removeFoodItem(foodItemIndex);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid option");
                pause();
                break;
        }
    }

    /*
        FUNCTION NAME : readFile()
        DESCRIPTION   : read person file
        SUB-FUNCTION OF : -
        SUB-FUNCTION(s) : -
        AVAILABLE
        AUTHOR : Muhammad Naim bin Abdul Jalil
    */

    //Read File
    public static void readFile() throws Exception {
        Scanner inFile = new Scanner(new File("Person.txt"));
        String street, city, state, fullName, phoneNumber, email, username, password, temp;
        int postalCode, code;
        String[] str;

        while(inFile.hasNextLine()){
            temp = inFile.nextLine();
            str = temp.split(", ");

            code = Integer.parseInt(str[0]);
            fullName = str[1];
            phoneNumber = str[2];
            email = str[3];
            username = str[4];
            password = str[5];
            street = str[6];
            city = str[7];
            state = str[8];
            postalCode = Integer.parseInt(str[9]);
            

            switch(code){
                case 1:
                    person.add(new Recipient(fullName, phoneNumber, email, username, password, street, city, state, postalCode));
                    break;
                case 2:
                    person.add(new Contributor(fullName, phoneNumber, email, username, password, street, city, state, postalCode));
                    break;
                case 3:
                    person.add(new Volunteer(fullName, phoneNumber, email, username, password, street, city, state, postalCode));
                    break;
            }
        }

    }

    /*
        FUNCTION NAME : clrscr()
        DESCRIPTION   : Clears Screen in java
        SUB-FUNCTION OF : -
        SUB-FUNCTION(s) : -
        AVAILABLE
        AUTHOR : Muhammad Naim bin Abdul Jalil
    */

    //Clear Screen
    public static void clrscr(){
        //Clears Screen in java
        try {
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    /*
        FUNCTION NAME : readFile()
        DESCRIPTION   : read person file
        SUB-FUNCTION OF : -
        SUB-FUNCTION(s) : -
        AVAILABLE
        AUTHOR : Muhammad Naim bin Abdul Jalil
    */

    //pause
    public static void pause(){
        System.out.print("\nPress enter to continue.. ");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}