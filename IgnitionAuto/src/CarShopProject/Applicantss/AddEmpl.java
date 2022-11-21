package CarShopProject.Applicantss;

import CarShopProject.ADD_Manualy.EmployeeAddManually;
import CarShopProject.ConnectionProvider;
import CarShopProject.Core_Store;
import CarShopProject.Menu;

import java.sql.*;
import java.util.Scanner;

public class AddEmpl {
    protected static final String CREATE_QUERY = "INSERT INTO shop_db.employees( `firstname`, `familyname`, `education`,`jobposition`,`jobexp`,`phonenum`) VALUES( ?, ?, ?, ?, ?, ?)";
    protected static final String READ_QUERY = "SELECT * FROM shop_db.employees";
    public static String firstname;
    public static String familyname;
    public static String education;
    public static String jobposition;
    public static int jobexp;
    public static String phonenum;


    public static void addEmpl(Core_Store coreStore) throws SQLException, ClassNotFoundException {

        Scanner scan = new Scanner(System.in);


        System.out.println("Enter your firstname : ");
        firstname = scan.next();
        System.out.println("Enter your familyname : ");
        familyname = scan.next();
        System.out.println("Enter your education : ");
        education = scan.next();
        System.out.println("Enter a position ,you want to candidate : ");
        jobposition = scan.next();
        System.out.println("Enter your experience of this position  : ");
        jobexp = scan.nextInt();
        System.out.println("Enter your phone number to feedback from us  : ");
        phonenum = scan.next();
        Employees applicant = new Employees(firstname, familyname, education, jobposition, jobexp, phonenum);

        if (applicant.getJobposition().contains("manager")) {

            if (Candidate_Methods.isQualified_Manager(applicant)) {

                createQuery(coreStore);

            }
            afterapplication(coreStore);

        }
        if (applicant.getJobposition().contains("mechanic")) {

            if (Candidate_Methods.isQualified_Mechanic(applicant)) {

                createQuery(coreStore);
            }
            afterapplication(coreStore);

        }
        if (applicant.getJobposition().contains("engineer")) {

            if (Candidate_Methods.isQualified_AutoEngineer(applicant)) {

                createQuery(coreStore);

            }
            afterapplication(coreStore);

        }
        if (applicant.getJobposition().contains("salesperson")) {

            if (Candidate_Methods.isQualified_CarSalesPerson(applicant)) {

                createQuery(coreStore);


            }
            afterapplication(coreStore);

        }
        if (applicant.getJobposition().contains("technician")) {

            if (Candidate_Methods.isQualified_TireTechnician(applicant)) {

                createQuery(coreStore);


            }
            afterapplication(coreStore);

        }
        if (applicant.getJobposition().contains("inspector")) {

            if (Candidate_Methods.isQualified_VehicleInspector(applicant)) {

                createQuery(coreStore);

            }
            afterapplication(coreStore);

        }
        if (applicant.getJobposition().contains("driver")) {

            if (Candidate_Methods.isQualified_TowTruckDriver(applicant)) {

                createQuery(coreStore);


            }
            afterapplication(coreStore);
        }


    }

    public static void afterapplication(Core_Store coreStore) throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.print("Would you like to candidate for other job: [yes][no]");
        String choice = scan.next();
        if (choice.equals("yes")) {
            AddEmpl.addEmpl(coreStore);
        } else {
            Menu.menu(coreStore);
        }
    }

    public static void createQuery(Core_Store coreStore) throws SQLException, ClassNotFoundException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionProvider.getConnection();
            Employees applicant = new Employees(firstname, familyname, education, jobposition, jobexp, phonenum);

            PreparedStatement preparedStatement = con.prepareStatement(CREATE_QUERY);

            EmployeeAddManually.detailsSet(preparedStatement, firstname, familyname, education, jobposition, jobexp, phonenum);
            con.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


}