package CarShopProject.email_verification;

import CarShopProject.ConnectionProvider;
import CarShopProject.Menus.AdminMenu;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class TakeEmails {
    protected static final String GET_QUERY_BYID = "SELECT email FROM shop_db.users ";

    public static String formattedString;
    public static String Header;
    public static String Body;

    public static void take_emails() throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {


        Scanner scan = new Scanner(System.in);

        Connection con = null;
        ResultSet rs = null;
        ArrayList<String> emails = new ArrayList<String>();

        try {
            con = ConnectionProvider.getConnection();

            PreparedStatement preparedStatement2 = con.prepareStatement(GET_QUERY_BYID);

            rs = preparedStatement2.executeQuery();

            System.out.println("     ");
            while (rs.next()) {
                emails.add(rs.getString("email"));
            }


            formattedString = emails.toString()
                    .replace("[", "")  //remove the right bracket
                    .replace("]", "")  //remove the left bracket
                    .trim();

            con.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void send_emails() throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {

        take_emails();
        areyousure();
    }

    public static void areyousure() throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to make announcement! ");
        System.out.println(" Enter number    ");

        System.out.println("1.yes" + "\n"+
                "2.no");
        int choice = scan.nextInt();
        if (choice == 1) {
            writing_email();
            System.out.println("Do you want to send this email to all users ?");

            System.out.println("HEADER:  " + Header + "\n" +
                    "BODY:    " + "\n" + Body);

            System.out.println("     ");
            System.out.println(" Enter number    ");
            System.out.println("1.yes" + "\n" +
                    "2.no");
            int choice2 = scan.nextInt();
            if (choice2 == 1) {
                take_emails();
                MakeAnnouncement.sendMail();

            } else if (choice2 == 2) {
                System.out.println("Deleting ");
                areyousure();

            }
        }else if(choice == 2){
            System.out.println("Redirecting to main menu");
            AdminMenu.admin_menu();
        }

    }

    public static void writing_email(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Write Header of your email");
        Header = scan.nextLine();
        System.out.println("Write the body of your email");
        Body = scan.nextLine();
    }

}
