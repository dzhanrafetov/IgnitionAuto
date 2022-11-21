package CarShopProject.Menus;

import CarShopProject.ConnectionProvider;
import CarShopProject.email_verification.SendForgetPassword;
import CarShopProject.sha256;

import javax.mail.MessagingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResetPassword {
    protected static String RESET_PASSWORD = " UPDATE shop_db.users SET password = ? WHERE username= ? ";
    protected static final String READ_QUERY = "select role,username,password from shop_db.users";
    protected static final String GET_EMAIL = "Select email From shop_db.users  Where username= ? ";
    protected static final String UPDATE_QUERY = "UPDATE shop_db.users SET password= ? WHERE username= ?;";

    protected static boolean username_checker;
    public static String username;
    public static String email_password_reset;
    public static String new_password;
    public static String confirm_new_password;
    public static String roleDB = "";

    protected static String your_reset_code;
    protected static boolean reset_code_checker;

    public static void resset_password() throws SQLException, NoSuchAlgorithmException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Username");
        username = scan.next();

        Connection con = null;
        ResultSet rs = null;


        try {
            con = ConnectionProvider.getConnection();


            username_validation();
            if (username_checker) {
                PreparedStatement preparedStatement = con.prepareStatement(GET_EMAIL);
                preparedStatement.setString(1, username);

                rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    email_password_reset = rs.getString("email");
                }
                System.out.println("We have sent you a one-time-code to reset your password "  + email_password_reset);
                System.out.println("Please type the one-time-code you have received ");

                reset_code_validation();

                if (reset_code_checker) {
                    new_password();
                } else {
                    System.out.println("Your One-time-code is not valid");
                    scan.reset();
                }
            } else {
                System.out.println("This username is not registered in our DataBase");
            }

            con.close();
            System.out.println();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void reset_code_validation() throws SQLException {
        Scanner scan = new Scanner(System.in);
        Connection con = null;

//**TO DO
//     CHECK ROLE FROM THE USERNAME AND REDIRECT TO HIS MENU
//


        try {
            con = ConnectionProvider.getConnection();
            reset_code_checker = false;
            SendForgetPassword.runner();

            your_reset_code = scan.nextLine();
            if ((your_reset_code.equals(SendForgetPassword.formattedString))) {
                reset_code_checker = true;
            } else {
                System.out.println("The one-time-code is not valid");

                reset_code_checker = false;

            }


            con.close();
            System.out.println();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void username_validation() throws SQLException {

        Connection con = null;
        ResultSet rs = null;

        String userNameDB = "";


        try {
            con = ConnectionProvider.getConnection();
            username_checker = false;

            PreparedStatement preparedStatement2 = con.prepareStatement(READ_QUERY);

            rs = preparedStatement2.executeQuery();
            while (rs.next()) {
                userNameDB = rs.getString("username");
                roleDB = rs.getString("role");

                if ((username.equals(userNameDB))) {
                    username_checker = true;
                }
            }


            con.close();
            System.out.println();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void new_password() throws SQLException {

        Connection con = null;

        Scanner scan = new Scanner(System.in);

        try {
            con = ConnectionProvider.getConnection();
            System.out.println("Enter your new password");
            new_password = scan.nextLine();
            Pattern pass_p = Pattern.compile("^(?=.*\\d)(?=.*[a-z])[^\\s]{8,}$");
            Matcher pass_m = pass_p.matcher(new_password);
            boolean pass_b = pass_m.matches();
            if (!pass_b) {
                System.out.println("Your password is not valid");
                new_password();

            } else
                System.out.println("Confirm your new password");
            confirm_new_password = scan.nextLine();

            if (new_password.equals(confirm_new_password)) {
                sha256.start_hashing_newpassword();
                System.out.println("Password has changed successfully!");
                //Redirect To Login menu
                //*** TO DO

                if(roleDB.equals("Admin")){
            AdminMenu.admin_menu();
                }
                if(roleDB.equals("Client")){
            ClientMenu.client_menu();
                }
                if(roleDB.equals("Employee")){

//LOGIN MENU
                }else{

                }

                PreparedStatement preparedStatement2 = con.prepareStatement(UPDATE_QUERY);
                preparedStatement2.setString(1, new_password);
                preparedStatement2.setString(2, username);
                preparedStatement2.executeUpdate();
                con.close();

            } else {

                System.out.println("Confirm password doesn't match New password");
                System.out.println("Please try again");
                new_password();
            }
        } catch (ClassNotFoundException | NoSuchAlgorithmException | MessagingException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }

    }

//    public static void redirecting() throws SQLException, NoSuchAlgorithmException, ClassNotFoundException, MessagingException {
//        if(roleDB.equals("Admin")){
//            AdminMenu.admin_menu();
//        }
//        if(roleDB.equals("Client")){
//            ClientMenu.client_menu();
//        }
//        if(roleDB.equals("Employee")){
//
//
//        }

}

