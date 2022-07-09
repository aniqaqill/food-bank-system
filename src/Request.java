import java.util.*;
import java.time.LocalDate;
public class Request {
    private ArrayList<FoodItem> requestedItem = new ArrayList<FoodItem>();
    private String requestID;
    private Location location;
    private Recipient recipient;
    private String status;

    public Request(Location location, Recipient recipient, String status, int size) {
        this.location = location;
        this.recipient = recipient;
        this.status = status;
        LocalDate date = LocalDate.now();
        requestID = "R" + size + date.getDayOfMonth() + date.getMonth() + date.getYear();
    }

    //setter
    public void setStatus(String status) {
        this.status = status;
    }

    //getter
    public Recipient getRecipient() {
        return recipient;
    }

    public String getRequestID(){
        return requestID;
    }


    public String getStatus() {
        return status;
    }

    public void addRequestItem(FoodItem f, int quantity){
        requestedItem.add(new FoodItem(f, quantity));
    }

    //display method
    public void displayRequests() {
        System.out.println("Recipient : " + recipient.getFullName());
        System.out.println("Location  : " + location.getAddress());
        System.out.println("Status    : " + status);
        System.out.println("Request ID: " + requestID);

        System.out.printf("%2s   %-20s   %-8s   %-13s   %-12s\n","No","Food/Item Name", "Quantity", "Register Date", "Expired Date");
        for(int i = 0; i < requestedItem.size(); i++){
            System.out.printf("%2d   ", (i+1));
            requestedItem.get(i).display();
            System.out.println();
        }
    }
}
