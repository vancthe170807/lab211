package model;

/**
 * Experience candidate (type 0)
 */
public class Experience extends Candidate {

    private int expInYear;
    private String proSkill;

    /**
     * Constructor for Experience candidate
     */
    public Experience (String id, String firstName, String lastName,
                     int birthDate, String address, String phone,
                     String email, int expInYear, String proSkill) {
        super (id, firstName, lastName, birthDate, address, phone, email, 0);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    /**
     * Get years of experience
     */
    public int getExpInYear () {
        return expInYear;
    }

    /**
     * Set years of experience
     */
    public void setExpInYear (int expInYear) {
        this.expInYear = expInYear;
    }

    /**
     * Get professional skills
     */
    public String getProSkill () {
        return proSkill;
    }

    /**
     * Set professional skills
     */
    public void setProSkill (String proSkill) {
        this.proSkill = proSkill;
    }
}
