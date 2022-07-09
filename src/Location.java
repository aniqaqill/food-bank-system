import java.util.*;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;

public class Location {
    private Address address;
    private Contributor contributor;
    private ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();

    public Location(String street, String city, String state, int postalCode, Contributor contributor){
        address = new Address(street, city, state, postalCode);
        this.contributor = contributor;
    }

    public void addFoodItem(String name, int quantity, int day, int month, int year){
        foodItems.add(new FoodItem(name, quantity, day, month, year));
    }

    //setters
    public void setAddress(String street, String city, String state, int postalCode){
        address = new Address(street, city, state, postalCode);
    }

    public void setContributor(Contributor contributor){
        this.contributor = contributor;
    }

    //getter
    public String getAddress() {
        return address.toString();
    }

    public Contributor getContributor() {
        return contributor;
    }

    public int getFoodItemCount() {
        return foodItems.size();
    }

    public FoodItem getFoodItems(int i) {
        return foodItems.get(i);
    }

    //remover
    public void removeFoodItem(int i) {
        foodItems.remove(i);
    }
    //toString method
    public String toString(){
        String str = "";
        str += address.toString();
        str += contributor.getFullName() + ",";
        for(FoodItem f : foodItems){
            str += f.toString();
        }
        return str;
    }

}
