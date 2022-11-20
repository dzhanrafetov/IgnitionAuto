package CarShopProject.Applicantss;

import CarShopProject.ConnectionProvider;
import CarShopProject.Core_Store;
import CarShopProject.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ShowEmplMethods {
    protected static final String READ_QUERY = "SELECT * FROM shop_db.employees ";
    protected static String COUNT_QUERY = "SELECT  jobposition, COUNT(*) FROM shop_db.employees GROUP BY jobposition;";
    protected static String TOTAL_EMPLOYEES = "SELECT COUNT(distinct t1.id) AS totalRows FROM shop_db.employees t1;";
    protected static final String SEARCH_BY_NAME = "SELECT * FROM shop_db.employees WHERE firstname = ? AND familyname = ?; ";


    public static void totalEmployees(Core_Store coreStore) {
        Connection con;
        ResultSet rs;


        try {
            con = ConnectionProvider.getConnection();

            PreparedStatement preparedStatement2 = con.prepareStatement(TOTAL_EMPLOYEES);

            rs = preparedStatement2.executeQuery();
            System.out.println("     ");
            System.out.println("TOTAL EMPLOYEES SUMMARY");
            while (rs.next())
                System.out.println("TOTAL [" + rs.getInt("totalRows") + "]  EMPLOYEES ARE WORKING THERE!");
            con.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void searchEmployee(Core_Store coreStore) {
        Connection con;
        ResultSet rs;
        Scanner scan = new Scanner(System.in);


        try {
            con = ConnectionProvider.getConnection();
            System.out.println("Write Employee's firstname");
            String firstname = scan.next();
            System.out.println("Write Employee's familyname");
            String familyname = scan.next();
            PreparedStatement preparedStatement2 = con.prepareStatement(SEARCH_BY_NAME);
            preparedStatement2.setString(1, firstname);
            preparedStatement2.setString(2, familyname);

            rs = preparedStatement2.executeQuery();

            System.out.println("     ");
            System.out.println("SEARCHING EMPLOYEE WITH NAME:  [" + firstname + " " + familyname + "] ...");
            geting(con, rs);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void geting(Connection con, ResultSet rs) throws SQLException {
        while (rs.next())
            System.out.println(
                    "INFORMATION ABOUT SEARCHED EMPLOYEE" + "\n" +
                            "      [EMPLOYEE INFORMATION]       " + "\n" +
                            "  [ID]  " + rs.getInt("id") + "\n" +
                            "  [NAME]   " + rs.getString("firstname") + "\n" +
                            "  [FAMILY] " + rs.getString("familyname") + "\n" +
                            "  [POSITION]   " + rs.getString("jobposition") + "\n" +
                            "  [EXPERIENCE] " + rs.getString("jobexp") + " years" + "\n" +
                            "  [EDUCATION]  " + rs.getString("education") + "\n" +
                            "  [PHONE NUMBER] " + rs.getString("phonenum") + "\n" +
                            "       " + "\n" +
                            "       " + "\n");

        con.close();
    }


    public static void showCount(Core_Store coreStore) {
        Connection con;
        ResultSet rs;


        try {
            con = ConnectionProvider.getConnection();

            PreparedStatement preparedStatement2 = con.prepareStatement(COUNT_QUERY);

            rs = preparedStatement2.executeQuery();
            System.out.println("             ");
            System.out.println("JOB POSITION SUMMARY");
            System.out.println("            ");
            while (rs.next())
                System.out.println(

                        "(Position: " + rs.getString("jobposition") + ")" +
                                " [" +
                                rs.getInt("COUNT(*)") + "]" +
                                "  employees");
            con.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void showEmployees(Core_Store coreStore) {
        Connection con;
        ResultSet rs;


        try {
            con = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement2 = con.prepareStatement(READ_QUERY);
            rs = preparedStatement2.executeQuery();


            System.out.println("            ");
            System.out.println("            ");
            System.out.println("DETAILED INFORMATION FOR ALL EMPLOYEES");
            while (rs.next())
                System.out.println(
                        "      [EMPLOYEE INFORMATION]       " + "\n" +
                                "  [ID]  " + rs.getInt("id") + "\n" +
                                "  [NAME]   " + rs.getString("firstname") + "\n" +
                                "  [FAMILY] " + rs.getString("familyname") + "\n" +
                                "  [POSITION]   " + rs.getString("jobposition") + "\n" +
                                "  [EXPERIENCE] " + rs.getString("jobexp") + " years" + "\n" +
                                "  [EDUCATION]  " + rs.getString("education") + "\n" +
                                "  [PHONE NUMBER] " + rs.getString("phonenum") + "\n" +
                                "       " + "\n" +
                                "       " + "\n"

                );
            Menu.menu(coreStore);

            con.close();


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}











