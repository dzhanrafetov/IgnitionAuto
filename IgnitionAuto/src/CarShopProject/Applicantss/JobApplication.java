package CarShopProject.Applicantss;

public class JobApplication {
    // class name
    private int id;
    private String name;
    private String familyname;
    private String phoneNum;
    private String education;
    private int experience;
    private String position_want;
    private String more_information;


    public JobApplication(String name, String phoneNum, String education, int experience, String position_want,String more_information) {  //parameterized constructor that accepts values for each of the fields
        this.name = name;
        this.phoneNum = phoneNum;
        this.education = education;
        this.experience = experience;
        this.more_information = more_information;
        this.position_want=position_want;

    }


    public String getName() {  //accessor get method for name field
        return name;
    }

    public String getPhoneNum() {   //accessor get method for phoneNum field
        return phoneNum;
    }

    public String getEducation() {
        return education;
    }

    public String getPosition_want() {
        return position_want;
    }

    public int getExperience() {
        return experience;
    }

    public String getMore_information() {
        return more_information;
    }
}