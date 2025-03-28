//Aniq
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FoodItem {
    private String name;
    private int quantity;
    private LocalDate registerDate;
    private LocalDate expiredDate;

    public FoodItem(String name, int quantity, int day, int month, int year){
        this.name = name;
        this.quantity = quantity;
        registerDate = LocalDate.now();
        expiredDate = LocalDate.of(year, month, day);
    }

    public FoodItem(FoodItem foodItem, int quantity){
        name = foodItem.name;
        this.quantity = quantity;
        registerDate = foodItem.registerDate;
        expiredDate = foodItem.expiredDate;
    }

    public void display(){
        System.out.printf("%-20s   %-8d   %-13s   %-12s", name, quantity, registerDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy")), expiredDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy")));
    }

    //setter
    public void setName(String name){
        this.name = name;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setRegisterDate(int day, int month, int year) {
        registerDate = LocalDate.of(year, month, day);
    }

    public void setExpiredDate(int day, int month, int year) {
        expiredDate = LocalDate.of(year, month, day);
    }
    
    //getter
    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }
}
