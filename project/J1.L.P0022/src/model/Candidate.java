package model;

/**
 * Abstract base class for all candidate types
 * Defines common attributes and behavior for Experience, Fresher, and Intern candidates
 */
public abstract class Candidate {
    protected String id;
    protected String firstName;
    protected String lastName;
    protected int birthDate;
    protected String address;
    protected String phone;
    protected String email;
    protected int type; // 0=Experience, 1=Fresher, 2=Intern

    public Candidate(String id, String firstName, String lastName,
                    int birthDate, String address, String phone,
                    String email, int type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    // Abstract method - must be implemented by subclasses
    public abstract void display();

    // Common display method
    public String getCommonInfo() {
        return firstName + " " + lastName + " | " + birthDate + " | " +
               address + " | " + phone + " | " + email + " | " + type;
    }

    // Getters
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getBirthDate() { return birthDate; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public int getType() { return type; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setBirthDate(int birthDate) { this.birthDate = birthDate; }
    public void setAddress(String address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setType(int type) { this.type = type; }
}
