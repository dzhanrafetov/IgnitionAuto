package CarShopProject.login;

import CarShopProject.ConnectionProvider;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ShowLoggedUsers {
    public static String id = "";
    public static String role = "";
    public static String username = "";
    public static String last_login = "";
    public static String register_date = "";

    protected static final String LOGGED_USERS = "SELECT id,role, username,last_login,registerdate  FROM shop_db.users Where isloged = 'yes'";
    protected static final String ALL_USERS = "SELECT id,role, username,last_login,registerdate  FROM shop_db.users ";
//INSERT INTO employees  VALUES(?, ?, ? , ?, ?, ?, ?);

    public static void logged_users() throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {


        Scanner scan = new Scanner(System.in);

        Connection con = null;
        ResultSet rs = null;


        try {
            con = ConnectionProvider.getConnection();

            PreparedStatement preparedStatement2 = con.prepareStatement(LOGGED_USERS);

            rs = preparedStatement2.executeQuery();
            System.out.println("   ");
            System.out.println("   ");
            System.out.println("All Logged Users ");
            while (rs.next()) {
                id = rs.getString("id");
                role = rs.getString("role");
                username = rs.getString("username");
                last_login = rs.getString("last_login");
                register_date = rs.getString("registerdate");


                System.out.println(
                        "id:  " + id + "\n" +
                                "username: " + username + "\n" +
                                "role: " + role + "\n" +
                                "login date:     " + last_login + "   " +
                                "\n" + "register date:  " + register_date + "\n" + "\n"

                );
                //   con.close();
                System.out.println();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void show_all_users() throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {


        Scanner scan = new Scanner(System.in);

        Connection con = null;
        ResultSet rs = null;


        try {
            con = ConnectionProvider.getConnection();

            PreparedStatement preparedStatement2 = con.prepareStatement(ALL_USERS);

            rs = preparedStatement2.executeQuery();
            System.out.println("   ");
            System.out.println("   ");
            System.out.println("All Registered Users");
            while (rs.next()) {
                id = rs.getString("id");
                role = rs.getString("role");
                username = rs.getString("username");

                register_date = rs.getString("registerdate");

                System.out.println(
                        "id:  " + id + "\n" +
                                "username: " + username + "\n" +
                                "role: " + role + "\n" +
                                "login    date:     " + last_login + "   " +
                                "\n" + "register date:     " + register_date + "\n" + "\n"

                );
                con.close();
                System.out.println();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}