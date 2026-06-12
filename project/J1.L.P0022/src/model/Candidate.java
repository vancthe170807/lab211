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

    /**
     * Constructor for Candidate
     */
    public Candidate (String id, String firstName, String lastName,
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

    /**
     * Return string representation of Candidate
     */
    @Override
    public String toString () {
        return getCommonInfo ();
    }

    /**
     * Get common candidate details as formatted string
     */
    public String getCommonInfo () {
        StringBuilder sb;

        sb = new StringBuilder ();
        sb.append (firstName).append (" ").append (lastName)
          .append (" | ").append (birthDate)
          .append (" | ").append (address)
          .append (" | ").append (phone)
          .append (" | ").append (email)
          .append (" | ").append (type);
        return sb.toString ();
    }

    /**
     * Get candidate ID
     */
    public String getId () {
        return id;
    }

    /**
     * Set candidate ID
     */
    public void setId (String id) {
        this.id = id;
    }

    /**
     * Get first name
     */
    public String getFirstName () {
        return firstName;
    }

    /**
     * Set first name
     */
    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get last name
     */
    public String getLastName () {
        return lastName;
    }

    /**
     * Set last name
     */
    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get birth date (year)
     */
    public int getBirthDate () {
        return birthDate;
    }

    /**
     * Set birth date (year)
     */
    public void setBirthDate (int birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Get address
     */
    public String getAddress () {
        return address;
    }

    /**
     * Set address
     */
    public void setAddress (String address) {
        this.address = address;
    }

    /**
     * Get phone number
     */
    public String getPhone () {
        return phone;
    }

    /**
     * Set phone number
     */
    public void setPhone (String phone) {
        this.phone = phone;
    }

    /**
     * Get email address
     */
    public String getEmail () {
        return email;
    }

    /**
     * Set email address
     */
    public void setEmail (String email) {
        this.email = email;
    }

    /**
     * Get candidate type
     */
    public int getType () {
        return type;
    }

    /**
     * Set candidate type
     */
    public void setType (int type) {
        this.type = type;
    }
}
