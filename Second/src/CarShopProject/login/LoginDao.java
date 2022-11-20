package CarShopProject.login;

import CarShopProject.ConnectionProvider;
import CarShopProject.Menus.AdminMenu;
import CarShopProject.Menus.ClientMenu;
import CarShopProject.sha256;
import ооp.DateUtils;

import javax.mail.MessagingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class LoginDao {
    protected static final String CREATE_QUERY = "INSERT INTO employees VALUES(?, ?, ?)";
    protected static final String READ_QUERY = "select role,username,password from shop_db.users";
    protected static final String GET_QUERY = "SELECT * FROM shop_db.employees WHERE firstname = ?";
    protected static final String UPDATE_QUERY = "UPDATE shop_db.users SET last_login= ?, isloged= ? WHERE username= ?;";

    protected static String DELETE_QUERY = "DELETE FROM vehicles  WHERE id = ? ";
    protected static String COUNT_QUERY = "SELECT  jobposition, COUNT(*) FROM shop_db.employees GROUP BY jobposition;";
    protected static String TOTAL_EMPLOYEES = "SELECT COUNT(distinct t1.id) AS totalRows FROM shop_db.employees t1;";
    protected static final String SEARCH_BY_NAME = "SELECT * FROM shop_db.employees WHERE firstname = ? AND familyname = ?;";
    public static String userNameDB = "";
    public static String passwordDB = "";
    public static String roleDB = "";
    public static String login_password;
    protected static String RESET_PASSWORD = " UPDATE shop_db.users SET password = '' WHERE username= ? ";

   //  UPDATE shop_db.users SET password = '' WHERE username="Azis";
    public static void login_menu() throws SQLException, NoSuchAlgorithmException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Username");
        String userName = scan.next();
        System.out.println("Password");
        login_password = scan.next();
        sha256.start_hashing();
        System.out.println("Role");
        String role = scan.next();

        Connection con = null;
        ResultSet rs = null;


        try {
            con = ConnectionProvider.getConnection();

            PreparedStatement preparedStatement2 = con.prepareStatement(READ_QUERY);

            rs = preparedStatement2.executeQuery();
            while (rs.next()) {
                userNameDB = rs.getString("username");
                passwordDB = rs.getString("password");
                roleDB = rs.getString("role");


                if (userName.equals(userNameDB) && login_password.equals(passwordDB) && role.equals(roleDB)) {
                    if (role.equals("Admin")) {
                        System.out.println("Successful login! " + ооp.DateUtils.getTimeStamp());
                        System.out.println("Welcome, " + userNameDB);
                        login_succeed();
                        AdminMenu.admin_menu();


                    }
                    if (role.equals("Client")) {
                        System.out.println("Successful login! " + ооp.DateUtils.getTimeStamp());
                        System.out.println("Welcome, " + userNameDB);
                        login_succeed();

                        ClientMenu.client_menu();

                    }
                    if (role.equals("Employee")) {
                        System.out.println("Successful login! " + ооp.DateUtils.getTimeStamp());
                        System.out.println("Welcome, " + userNameDB);
                        login_succeed();
                        ClientMenu.client_menu();

                    }
                }

            }
            System.out.println("Invalid Username, Password or Role ");
            System.out.println("Do you forgot your password");
            System.out.println("Do you want to reset your password ");
            //if choice.equals=yes
            //write your username
            //write you email where the reset password wil reset
            //code was sent
            //write the code
            //enter new password
            //enter conf new password
            //password was changed successful
            con.close();
            System.out.println();
        } catch (SQLException | ClassNotFoundException | MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void login_succeed() throws SQLException {
        Connection con = null;
        String last_login = DateUtils.getTimeStamp();

        try {
            con = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement3 = con.prepareStatement(UPDATE_QUERY);

            preparedStatement3.setString(1, last_login);
            preparedStatement3.setString(2, "yes");
            preparedStatement3.setString(3, userNameDB);
            preparedStatement3.executeUpdate();

            con.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}