package CarShopProject.login;

import CarShopProject.ConnectionProvider;
import CarShopProject.email_verification.SendMail;
import CarShopProject.sha256;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register {
    protected static final String CREATE_QUERY = "INSERT INTO shop_db.users (username, password,role, email,registerdate) VALUES (?, ?,?, ?,?)";
    protected static final String READ_QUERY = "select role,username,password from shop_db.users";


    public static String userName;
    public static String password;
    public static String email;
    protected static String role;
    protected static String your_activation_code;


    protected static boolean username_checker;
    protected static boolean activation_checker;

    public static void getting_register_data() throws SQLException, NoSuchAlgorithmException {

        Scanner scan = new Scanner(System.in);
        System.out.println("Registration");
        System.out.println("Username: ");

        userName = scan.next();
        Pattern username_p = Pattern.compile("^[a-zA-Z0-9._-]{3,}$");
        Matcher username_m = username_p.matcher(userName);
        boolean username_b = username_m.matches();
        if (!username_b) {
            System.out.println("username  is not valid");
            getting_register_data();
        } else
            System.out.println("\n" +
                    "\n" +
                    "Password Requirement :\n" +
                    "\n" +
                    "Password should be at least eight (8) characters in length where the system can support it.\n" +
                    "Passwords must include characters from at least two (2) of these groupings: alpha, numeric, and special characters.  " +
                    "                         \n" + "" +
                    "");

        System.out.println("Password: ");

        password = scan.next();
        Pattern pass_p = Pattern.compile("^(?=.*\\d)(?=.*[a-z])[^\\s]{8,}$");
        Matcher pass_m = pass_p.matcher(password);
        boolean pass_b = pass_m.matches();
        if (!pass_b) {
            System.out.println("your password is not valid");
            getting_register_data();

        } else
            System.out.println("Confirm Your Password");
        String conf_password = scan.next();
        if (!(password.equals(conf_password))) {

            System.out.println("passwords doesn't match");
            getting_register_data();
        }
        System.out.println("Write your Email (We will send you Confirm Code)");
        email = scan.next();
        Pattern email_p = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher email_m = email_p.matcher(email);
        boolean email_b = email_m.matches();
        if (!email_b) {
            System.out.println("your email is not valid");
            System.out.println("Your email does not respond the requirements" + "\n" +
                    "1) A-Z characters allowed\n" +
                    "2) a-z characters allowed\n" +
                    "3) 0-9 numbers allowed\n" +
                    "4) Additionally email may contain only dot(.), dash(-) and underscore(_)\n" +
                    "5) Rest all characters are not allowed");
            getting_register_data();

        } else

            System.out.println("Role: ");
        role = scan.next();

        Pattern role_p = Pattern.compile("^[A-Z][a-z0-9_-]{3,19}$");
        Matcher role_m = role_p.matcher(role);
        boolean role_b = role_m.matches();
        if (!role_b) {
            System.out.println("Your role is not valid " + "\n"
                    + "The first letter needs to be uppercase");
            getting_register_data();

        } else
            register_menu();

    }

    public static void code_validation() throws SQLException {
        Scanner scan = new Scanner(System.in);
        Connection con = null;


        try {
            con = ConnectionProvider.getConnection();
            activation_checker = false;
            SendMail.runner();

            your_activation_code = scan.nextLine();
            if ((your_activation_code.equals(SendMail.formattedString))) {
                activation_checker = true;
            } else {
                System.out.println("The activation code is not valid");
                activation_checker = false;

            }


            con.close();
            System.out.println();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void register_validation() throws SQLException {

        Connection con = null;
        ResultSet rs = null;

        String userNameDB = "";


        try {
            con = ConnectionProvider.getConnection();
            username_checker = true;

            PreparedStatement preparedStatement2 = con.prepareStatement(READ_QUERY);

            rs = preparedStatement2.executeQuery();
            while (rs.next()) {
                userNameDB = rs.getString("username");

                if ((userName.equals(userNameDB))) {
                    username_checker = false;
                }
            }


            con.close();
            System.out.println();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void register_menu() throws SQLException {
        register_validation();
        Connection con = null;


        try {
            con = ConnectionProvider.getConnection();
            Scanner scan = new Scanner(System.in);
            if (username_checker && (role.equals("Admin") || role.equals("Client") || role.equals("Employee"))) {
                account_proccess();
            } else {
                System.out.println("This user is already registered");
                scan.reset();
            }

            con.close();
            System.out.println();
        } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void account_proccess() throws SQLException, NoSuchAlgorithmException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Your account is almost created!");
        System.out.println("We have send you verification in your email " + email);
        System.out.println(" Please type the code you have received  ");
        sha256.start_hashing_register();

        code_validation();

        if (activation_checker) {
            System.out.println("Your account was successfully created !");
            register_datasetter();

            System.out.println("Please login: ");
            LoginDao.login_menu();
        } else {
            System.out.print("Operation failed");

            System.out.println("Do you want a new code?? ");
            System.out.println("[yes/no]");
            String choice = scan.next().toLowerCase(Locale.ROOT);
            if (choice.equals("yes")) {
                register_menu();
            } else {
                System.out.println("Registration is unsuccessful !");
            }
            scan.reset();

        }
    }

    public static void register_datasetter() throws SQLException {
        Connection con = null;
        String registerdate = ооp.DateUtils.getTimeStamp();

        try {
            con = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement3 = con.prepareStatement(CREATE_QUERY);

            preparedStatement3.setString(1, userName);
            preparedStatement3.setString(2, password);
            preparedStatement3.setString(3, role);
            preparedStatement3.setString(4, email);
            preparedStatement3.setString(5, registerdate);

            preparedStatement3.executeUpdate();

            con.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

}
