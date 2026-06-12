package model;

/**
 * Intern candidate (type 2)
 */
public class Intern extends Candidate {

    private String majors;
    private String semester;
    private String universityName;

    /**
     * Constructor for Intern candidate
     */
    public Intern (String id, String firstName, String lastName,
                 int birthDate, String address, String phone,
                 String email, String majors, String semester,
                 String universityName) {
        super (id, firstName, lastName, birthDate, address, phone, email, 2);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    /**
     * Get majors
     */
    public String getMajors () {
        return majors;
    }

    /**
     * Set majors
     */
    public void setMajors (String majors) {
        this.majors = majors;
    }

    /**
     * Get semester
     */
    public String getSemester () {
        return semester;
    }

    /**
     * Set semester
     */
    public void setSemester (String semester) {
        this.semester = semester;
    }

    /**
     * Get university name
     */
    public String getUniversityName () {
        return universityName;
    }

    /**
     * Set university name
     */
    public void setUniversityName (String universityName) {
        this.universityName = universityName;
    }
}
