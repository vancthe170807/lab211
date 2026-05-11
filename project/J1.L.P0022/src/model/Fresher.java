package model;

/**
 * Fresher candidate (type 1)
 */
public class Fresher extends Candidate {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(String id, String firstName, String lastName,
                  int birthDate, String address, String phone,
                  String email, String graduationDate,
                  String graduationRank, String education) {
        super(id, firstName, lastName, birthDate, address, phone, email, 1);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public void display() {
        System.out.println(getCommonInfo());
    }

    public String getGraduationDate() { return graduationDate; }
    public void setGraduationDate(String graduationDate) { this.graduationDate = graduationDate; }
    public String getGraduationRank() { return graduationRank; }
    public void setGraduationRank(String graduationRank) { this.graduationRank = graduationRank; }
    public String getEducation() { return education; }
    public void setEducation(String education) { this.education = education; }
}
