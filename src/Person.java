public class Person implements Authentication{
    protected String fullName;
    protected String phoneNumber;
    protected String email;
    protected String username;
    protected String password;
    protected Address address;

    public Person() {}

    public Person(String fullName, String phoneNumber, String email, String username, String password , 
                String street, String city, String state, int postalCode) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.address = new Address(street, city, state, postalCode);
    }

    public String toString(){
        return String.format("%-30s    %-13s    %s", fullName, phoneNumber, email);
    }

    //setter
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //getter
    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
    
}
