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

public class UserRemoveManually {
    protected static final String REMOVE_QUERY_BYID = "DELETE FROM shop_db.users  WHERE id =?";
    protected static final String GET_QUERY_BYID = "SELECT id,role,username,email FROM shop_db.users Where id =?";
    protected static final String GET_QUERY_BYNAME = "SELECT email FROM shop_db.users   ";//by role
    protected static final String REMOVE_QUERY_BYNAME = "DELETE FROM shop_db.users  WHERE username =? ";
    public static int id;

    public static void remove_manually_user() throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {


        Scanner scan = new Scanner(System.in);

        Connection con = null;
        ResultSet rs = null;


        try {
            con = ConnectionProvider.getConnection();


            System.out.println("Enter id or username of user to remove ");
            String firstchoice = scan.next();

            if (firstchoice.matches("[0-9]+")) {

                id = Integer.parseInt(firstchoice);
                //GET ID... OF USER
                PreparedStatement preparedStatement = con.prepareStatement(REMOVE_QUERY_BYID);
                System.out.println("Are you sure to remove  user  with details");
                preparedStatement.setInt(1, id);

                GetQueryById(id);

                areyousure(preparedStatement);


            } else {
                PreparedStatement preparedStatement = con.prepareStatement(REMOVE_QUERY_BYNAME);
                System.out.println("Are you sure to remove  user with details");
                preparedStatement.setString(1, firstchoice);

                GetQueryByName(firstchoice);

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
            while (rs.next())
                System.out.println(

                                "      [USER INFORMATION]       " + "\n" +
                                "  [ID]  " + rs.getInt("id") + "\n" +
                                "  [USERNAME]   " + rs.getString("username") + "\n" +
                                "  [ROLE] " + rs.getString("role") + "\n" +
                                "  [EMAIL]   " + rs.getString("email") + "\n" +
                                "       " + "\n" +
                                "       " + "\n");

            con.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void GetQueryByName(String firstchoice) {
        Connection con;
        ResultSet rs;
        Scanner scan = new Scanner(System.in);


        try {
            con = ConnectionProvider.getConnection();

            PreparedStatement preparedStatement2 = con.prepareStatement(GET_QUERY_BYNAME);
            preparedStatement2.setString(1, firstchoice);

            rs = preparedStatement2.executeQuery();

            System.out.println("     ");
            while (rs.next())
                System.out.println(

                        "      [USER INFORMATION]       " + "\n" +
                                "  [ID]  " + rs.getInt("id") + "\n" +
                                "  [USERNAME]   " + rs.getString("username") + "\n" +
                                "  [ROLE] " + rs.getString("role") + "\n" +
                                "  [EMAIL]   " + rs.getString("email") + "\n" +
                                "       " + "\n" +
                                "       " + "\n");
            con.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void areyousure(PreparedStatement preparedStatement) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);

        String choice_sure;

        System.out.println("Are you sure to REMOVE this USER  yes/no ");

        choice_sure = scan.next().toLowerCase(Locale.ROOT);//SEARCH BY ID
        if (choice_sure.equals("yes")) {
            preparedStatement.executeUpdate();


            System.out.println("User has  successfully removed");
            AdminMenu.admin_menu();

        } else {
            String choice;
            System.out.println("Do you want to remove  User " + "  [yes/no]");
            choice = scan.next().toLowerCase(Locale.ROOT);
            if (choice.equals("yes")) {
              UserRemoveManually.remove_manually_user();
            } else if (choice.equals("no")) {
                System.out.println("You are redirecting to main menu");
                AdminMenu.admin_menu();
            }
        }

    }
}


