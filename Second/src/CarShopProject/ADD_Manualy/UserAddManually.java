package CarShopProject.ADD_Manualy;

import CarShopProject.ConnectionProvider;
import CarShopProject.Menus.AdminMenu;
import CarShopProject.sha256;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserAddManually {
    //user,
    //role,username,password,email
    //parolata trqbva da se kriptira
    //regex da  ima li da nqma li


    protected static final String CREATE_QUERY = "INSERT INTO shop_db.users (username, password,role, email,registerdate) VALUES (?, ?,?, ?,?)";
    protected static final String READ_QUERY = "select role,username,password from shop_db.users";


    public static String userName;
    public static String password;
    public static String email;
    protected static String role;
    protected static String your_activation_code;


    protected static boolean username_checker;

    public static void add_user_manually() throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {

        Scanner scan = new Scanner(System.in);
        System.out.println("user adding manually Registration");
        System.out.println("Username: ");

        userName = scan.next();
//        Pattern username_p = Pattern.compile("^[a-zA-Z0-9._-]{3,}$");
//        Matcher username_m = username_p.matcher(userName);
//        boolean username_b = username_m.matches();
        if (!(userName.matches("^[a-zA-Z0-9._-]{3,}$"))) {

//            if (!username_b) {
            System.out.println("username  is not valid");
            add_user_manually();
            //after success  ///type somethign
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
//            Pattern pass_p = Pattern.compile("^(?=.*\\d)(?=.*[a-z])[^\\s]{8,}$");
//            Matcher pass_m = pass_p.matcher(password);
//            boolean pass_b = pass_m.matches();
        if (!(password.matches("^(?=.*\\d)(?=.*[a-z])[^\\s]{8,}$"))) {
            System.out.println("your password is not valid");
            add_user_manually();

        } else
            System.out.println("Confirm Your Password");
        String conf_password = scan.next();
        if (!(password.equals(conf_password))) {

            System.out.println("passwords doesn't match");
            add_user_manually();
        }
        System.out.println("Write your Email (We will send you Confirm Code)");
        email = scan.next();
//            Pattern email_p = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

//                Matcher email_m = email_p.matcher(email);
//            boolean email_b = email_m.matches();
//            if (!email_b) {
        if (!(email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))) {

            System.out.println("your email is not valid");
            System.out.println("Your email does not respond the requirements" + "\n" +
                    "1) A-Z characters allowed\n" +
                    "2) a-z characters allowed\n" +
                    "3) 0-9 numbers allowed\n" +
                    "4) Additionally email may contain only dot(.), dash(-) and underscore(_)\n" +
                    "5) Rest all characters are not allowed");
            add_user_manually();

        } else

            System.out.println("Role: ");
        role = scan.next();

//            Pattern role_p = Pattern.compile("^[A-Z][a-z0-9_-]{3,19}$");
//            Matcher role_m = role_p.matcher(role);
//            boolean role_b = role_m.matches();
        if (!(role.matches("^[A-Z][a-z0-9_-]{3,19}$"))) {

//                if (!role_b) {
            System.out.println("Your role is not valid " + "\n"
                    + "The first letter needs to be uppercase");
            add_user_manually();

        } else {
            user_reg_Menu();
            //Here..........
            int choice;
            System.out.println(" You have  successfully added a new user ! ");
            System.out.println("Select action ...");
            System.out.println("0. to Back main menu");
            System.out.println("1. to Add another user ");
            choice = scan.nextInt();

            switch (choice) {
                case 0:
                    AdminMenu.admin_menu();
                    break;

                case 1:
add_user_manually();
                    break;
                default:
                    System.out.println("Wrong input..");
            }

        }
    }


    public static void user_validation() throws SQLException {

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


    public static void user_reg_Menu() throws SQLException {
        user_validation();
        Connection con = null;


        try {
            con = ConnectionProvider.getConnection();
            Scanner scan = new Scanner(System.in);
            if (username_checker && (role.equals("Admin") || role.equals("Client") || role.equals("Employee"))) {
                sha256.start_hashing_usermanually();
                user_datasetter();
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

//    public static void account_proccess() throws SQLException, NoSuchAlgorithmException {
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("Your account is almost created!");
//        System.out.println("We have send you verification in your email " + email);
//        System.out.println(" Please type the code you have received  ");
//        sha256.start_hashing_register();
//
//
////        if (activation_checker) {
//            System.out.println("Your account was successfully created !");
//           user_datasetter();
//
//            System.out.println("Please login: ");
//            LoginDao.login_menu();
//        } else {
//            System.out.print("Operation failed");
//
//            System.out.println("Do you want a new code?? ");
//            System.out.println("[yes/no]");
//            String choice = scan.next().toLowerCase(Locale.ROOT);
//            if (choice.equals("yes")) {
//                register_menu();
//            } else {
//                System.out.println("Registration is unsuccessful !");
//            }
//            scan.reset();
//
//        }
//    }

    public static void user_datasetter() throws SQLException {
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
