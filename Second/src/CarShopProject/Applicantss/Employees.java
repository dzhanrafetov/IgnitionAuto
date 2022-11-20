package CarShopProject.Applicantss;

public class Employees {


    private int id;
    private String firstname;
    private String familyname;
    private String education;
    private String jobposition;
    private int jobexp;
    private String phonenum;

    public Employees( String firstname, String familyname, String education, String jobposition, int jobexp, String phonenum) {
        this.firstname = firstname;
        this.familyname = familyname;
        this.education = education;
        this.jobposition = jobposition;
        this.jobexp = jobexp;
        this.phonenum = phonenum;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getJobposition() {
        return jobposition;
    }

    public void setJobposition(String jobposition) {
        this.jobposition = jobposition;
    }

    public int getJobexp() {
        return jobexp;
    }

    public void setJobexp(int jobexp) {
        this.jobexp = jobexp;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
}
