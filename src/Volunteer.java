import java.util.*;
public class Volunteer extends Person{
    ArrayList<Integer> deliveryPostal = new ArrayList<Integer>();

    public Volunteer(String fullName, String phoneNumber, String email, String username, String password , 
                String street, String city, String state, int postalCode){
        super(fullName, phoneNumber, email, username, password, street, city, state, postalCode);
        deliveryPostal.add(postalCode);
    }

    //add postal in deliveryPostal
    public void addPostal(int postal){
        deliveryPostal.add(postal);
    }
    
    //check postal in array list.. parameter postal return boolean
    public boolean checkPostal(int postal){
        return deliveryPostal.contains(postal);
    }

    //delete postal
    public void deletePostal(int postal){
        deliveryPostal.remove(postal);
    }
}
