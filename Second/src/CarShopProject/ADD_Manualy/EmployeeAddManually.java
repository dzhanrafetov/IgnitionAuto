package CarShopProject.ADD_Manualy;

import CarShopProject.ConnectionProvider;
import CarShopProject.Menus.AdminMenu;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;


public class EmployeeAddManually {
    protected static final String CREATE_QUERY = "INSERT INTO shop_db.employees( `firstname`, `familyname`, `education`,`jobposition`,`jobexp`,`phonenum`) VALUES( ?, ?, ?, ?, ?, ?)";

    public static String firstname;
    public static String familyname;
    public static String education;
    public static String jobposition;
    public static int jobexp;
    public static String phonenum;

    public static void add_manually_employee() throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {


        Scanner scan = new Scanner(System.in);

        Connection con = null;
        ResultSet rs = null;


        try {
            con = ConnectionProvider.getConnection();


            PreparedStatement preparedStatement = con.prepareStatement(CREATE_QUERY);

            System.out.println(" Enter firstname ");
            firstname = scan.next().toUpperCase();
            System.out.println(" Enter familyname ");
            familyname = scan.next().toUpperCase();
            System.out.println(" Enter education ");
            education = scan.next().toUpperCase();
            System.out.println(" Enter jobposition ");
            jobposition = scan.next().toUpperCase();
            System.out.println(" Enter jobexp ");
            jobexp = scan.nextInt();
            System.out.println(" Enter phonenum ");
            phonenum = scan.next();
            String choice_sure;
            System.out.println("Are you sure to add this employee with details [yes/no] : \n" + "\n" + "\n" +
                    "firstname " + firstname + "\n" +
                    "familyname " + familyname + "\n" +
                    "education " + education + "\n" +
                    "jobposition " + jobposition + "\n" +
                    "jobexperience   " + jobexp + "\n" +
                    "phonenum " + phonenum);
            choice_sure = scan.next().toLowerCase(Locale.ROOT);
            if (choice_sure.equals("yes")) {

                detailsSet(preparedStatement, firstname, familyname, education, jobposition, jobexp, phonenum);
                System.out.println("Employee  successfully added");

            } else {
                String choice;
                System.out.println("Do you want to add new details" + "  [yes/no]");
                choice = scan.next().toLowerCase(Locale.ROOT);
                if (choice.equals("yes")) {
                    EmployeeAddManually.add_manually_employee();
                } else if (choice.equals("no")) {
                    System.out.println("You are redirecting to main menu");
                    AdminMenu.admin_menu();
                }

            }
            con.close();

        } catch (SQLException |
                ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void detailsSet(PreparedStatement preparedStatement, String firstname, String familyname, String education, String jobposition, int jobexp, String phonenum) throws SQLException {
        preparedStatement.setString(1, firstname);
        preparedStatement.setString(2, familyname);
        preparedStatement.setString(3, education);
        preparedStatement.setString(4, jobposition);
        preparedStatement.setInt(5, jobexp);
        preparedStatement.setString(6, phonenum);

        preparedStatement.executeUpdate();
    }
}


