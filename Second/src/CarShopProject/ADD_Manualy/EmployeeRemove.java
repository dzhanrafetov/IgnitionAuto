package CarShopProject.ADD_Manualy;


import CarShopProject.Applicantss.ShowEmplMethods;
import CarShopProject.ConnectionProvider;
import CarShopProject.Menus.AdminMenu;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;


public class EmployeeRemove {
    protected static final String REMOVE_QUERY_BYID = "DELETE FROM shop_db.employees  WHERE id =?";
    protected static final String GET_QUERY_BYID = "SELECT * FROM shop_db.employees Where id =?";
    protected static final String GET_QUERY_BYNAME = "SELECT * FROM shop_db.employees  WHERE firstname =? AND  familyname=?";
    ;

    protected static final String REMOVE_QUERY_BYNAME = "DELETE FROM shop_db.employees  WHERE firstname =? AND  familyname=?";

    public static int id;

    public static void remove_manually_employee() throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {


        Scanner scan = new Scanner(System.in);

        Connection con = null;
        ResultSet rs = null;


        try {
            con = ConnectionProvider.getConnection();


            System.out.println("Enter id or name of employee to remove ");
            String firstchoice = scan.next();
            String secondchoice;

            if (firstchoice.matches("[0-9]+")) {

                id = Integer.parseInt(firstchoice);
                //GET ID... OF USER
                PreparedStatement preparedStatement = con.prepareStatement(REMOVE_QUERY_BYID);
                System.out.println("Are you sure to remove  employee with details");
                preparedStatement.setInt(1, id);

                GetQueryById(id);

                areyousure(preparedStatement);


            } else {
                System.out.println("Enter second name");
                secondchoice = scan.next();
                PreparedStatement preparedStatement = con.prepareStatement(REMOVE_QUERY_BYNAME);
                System.out.println("Are you sure to remove  employee with details");
                preparedStatement.setString(1, firstchoice);
                preparedStatement.setString(2, secondchoice);

                GetQueryByName(firstchoice, secondchoice);

                areyousure(preparedStatement);


            }


            con.close();

        } catch (SQLException |
                ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void GetQueryById(int id) {
        Connection con;
        ResultSet rs;
        Scanner scan = new Scanner(System.in);


        try {
            con = ConnectionProvider.getConnection();

            PreparedStatement preparedStatement2 = con.prepareStatement(GET_QUERY_BYID);
            preparedStatement2.setInt(1, id);

            rs = preparedStatement2.executeQuery();

            System.out.println("     ");
            ShowEmplMethods.geting(con, rs);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void GetQueryByName(String firstchoice, String secondchoice) {
        Connection con;
        ResultSet rs;
        Scanner scan = new Scanner(System.in);


        try {
            con = ConnectionProvider.getConnection();

            PreparedStatement preparedStatement2 = con.prepareStatement(GET_QUERY_BYNAME);
            preparedStatement2.setString(1, firstchoice);
            preparedStatement2.setString(2, secondchoice);

            rs = preparedStatement2.executeQuery();

            System.out.println("     ");
            ShowEmplMethods.geting(con, rs);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void areyousure(PreparedStatement preparedStatement) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);

        String choice_sure;

        System.out.println("Are you sure to REMOVE this EMPLOYEE  yes/no ");

        choice_sure = scan.next().toLowerCase(Locale.ROOT);//SEARCH BY ID
        if (choice_sure.equals("yes")) {
            preparedStatement.executeUpdate();


            System.out.println("Employee has  successfully removed");
            AdminMenu.admin_menu();

        } else {
            String choice;
            System.out.println("Do you want to remove  Employee " + "  [yes/no]");
            choice = scan.next().toLowerCase(Locale.ROOT);
            if (choice.equals("yes")) {
                EmployeeRemove.remove_manually_employee();
            } else if (choice.equals("no")) {
                System.out.println("You are redirecting to main menu");
                AdminMenu.admin_menu();
            }
        }

    }
}
