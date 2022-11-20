package CarShopProject.Applicantss;

public class Candidate_Methods {
    public static boolean isQualified_Manager(Employees applicant) {
        if (applicant.getJobposition().equals("manager") && applicant.getEducation().equals("high") && applicant.getJobexp() > 3) {
            System.out.println("Welcome, " + applicant.getFirstname() + " " + applicant.getFamilyname() + "!" + "\n - You are  hired for Job as a [ MANAGER ] !");
            return true;
        } else {
            System.out.println("Not compatible");
            return false;

        }

    }

    public static boolean isQualified_Mechanic(Employees applicant) {
        if (applicant.getJobposition().equals("mechanic") && (applicant.getEducation().equals("secondary") || applicant.getEducation().equals("high")) && applicant.getJobexp() > 1) {
            System.out.println("Welcome, " + applicant.getFirstname() + " " + applicant.getFamilyname() + "!" + "\n - You are  hired for Job as a [ MECHANIC ] !");
            return true;
        } else {
            System.out.println("Not compatible");
            return false;
        }
    }

    public static boolean isQualified_AutoEngineer(Employees applicant) {
        if (applicant.getJobposition().equals("engineer") && applicant.getEducation().equals("high") && applicant.getJobexp() > 4) {
            System.out.println("Welcome, " + applicant.getFirstname() + " " + applicant.getFamilyname() + "!" + "\n - You are  hired for Job as a [ AUTO ENGINEER ] !");
            return true;
        } else {
            System.out.println("Not compatible");
            return false;

        }
    }

    public static boolean isQualified_CarSalesPerson(Employees applicant) {
        if (applicant.getJobposition().equals("salesperson") && applicant.getEducation().equals("secondary") || applicant.getEducation().equals("high") && applicant.getJobexp() > 1) {
            System.out.println("Welcome, " + applicant.getFirstname() + " " + applicant.getFamilyname() + "!" + "\n - You are  hired for Job as a [ CAR SALESPERSON ] !");
            return true;
        } else {
            System.out.println("Not compatible");
            return false;

        }
    }

    public static boolean isQualified_TireTechnician(Employees applicant) {
        if (applicant.getJobposition().equals("technician") && applicant.getEducation().equals("secondary") || applicant.getEducation().equals("high") && applicant.getJobexp() > 2) {
            System.out.println("Welcome, " + applicant.getFirstname() + " " + applicant.getFamilyname() + "!" + "\n - You are  hired for Job as a [TIRE TECHNICIAN ] !");
            return true;
        } else {
            System.out.println("Not compatible");
            return false;

        }
    }

    public static boolean isQualified_VehicleInspector(Employees applicant) {
        if (applicant.getJobposition().equals("inspector") && applicant.getEducation().equals("secondary") || applicant.getEducation().equals("high") && applicant.getJobexp() > 7) {
            System.out.println("Welcome, " + applicant.getFirstname() + " " + applicant.getFamilyname() + "!" + "\n - You are  hired for Job as a [ VEHICLE INSPECTOR ] !");
            return true;
        } else {
            System.out.println("Not compatible");
            return false;

        }
    }

    public static boolean isQualified_TowTruckDriver(Employees applicant) {
        if (applicant.getJobposition().equals("driver") && applicant.getEducation().equals("secondary") || applicant.getEducation().equals("high") && applicant.getJobexp() > 2) {
            System.out.println("Welcome, " + applicant.getFirstname() + " " + applicant.getFamilyname() + "!" + "\n - You are  hired for Job as a [ TOW TRUCK DRIVER ] !");
            return true;
        } else {
            System.out.println("Not compatible");
            return false;
        }
    }
}



