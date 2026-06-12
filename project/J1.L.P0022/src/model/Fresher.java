package model;

/**
 * Fresher candidate (type 1)
 */
public class Fresher extends Candidate {

    private String graduationDate;
    private String graduationRank;
    private String education;

    /**
     * Constructor for Fresher candidate
     */
    public Fresher (String id, String firstName, String lastName,
                  int birthDate, String address, String phone,
                  String email, String graduationDate,
                  String graduationRank, String education) {
        super (id, firstName, lastName, birthDate, address, phone, email, 1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    /**
     * Get graduation date
     */
    public String getGraduationDate () {
        return graduationDate;
    }

    /**
     * Set graduation date
     */
    public void setGraduationDate (String graduationDate) {
        this.graduationDate = graduationDate;
    }

    /**
     * Get graduation rank
     */
    public String getGraduationRank () {
        return graduationRank;
    }

    /**
     * Set graduation rank
     */
    public void setGraduationRank (String graduationRank) {
        this.graduationRank = graduationRank;
    }

    /**
     * Get university/education
     */
    public String getEducation () {
        return education;
    }

    /**
     * Set university/education
     */
    public void setEducation (String education) {
        this.education = education;
    }
}
