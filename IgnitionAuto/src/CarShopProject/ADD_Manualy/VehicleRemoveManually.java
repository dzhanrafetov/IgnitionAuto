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


public class VehicleRemoveManually {
    protected static final String REMOVE_QUERY = "DELETE FROM vehicles  WHERE id =?";
    protected static final String GET_QUERY = "SELECT * FROM shop_db.vehicles Where id =?";

    public static int id;

    public static void remove_manually_vehicle() throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {


        Scanner scan = new Scanner(System.in);

        Connection con = null;
        ResultSet rs = null;


        try {
            con = ConnectionProvider.getConnection();


            PreparedStatement preparedStatement = con.prepareStatement(REMOVE_QUERY);
            System.out.println("Enter id of vehicle to remove ");
            id = scan.nextInt();
            String choice_sure;

            PreparedStatement preparedStatement2 = con.prepareStatement(GET_QUERY);
            preparedStatement2.setInt(1, id);
            rs = preparedStatement2.executeQuery();
            while (rs.next())
                System.out.println(
                        "[ID] : " + rs.getInt("id") + "\n" +
                                "[TYPE] : " + rs.getString("type") + "\n" +
                                "[BRAND] : " + rs.getString("brand") + "\n" +
                                "[MODEL] : " + rs.getString("model") + "\n" +
                                "[HORSEPOWER] : " + rs.getInt("horsepower") + "\n" +
                                "[PRICE] : " + rs.getInt("price") + " $" + "\n"
                                + "   " + "\n");
            System.out.println("  ");
            System.out.println("Are you sure to REMOVE this vehicle  yes/no ");

            choice_sure = scan.next().toLowerCase(Locale.ROOT);//SEARCH BY ID
            if (choice_sure.equals("yes")) {

                preparedStatement.setInt(1, id);


                preparedStatement.executeUpdate();
                System.out.println("Vehicle  successfully removed");

            } else {
                String choice;
                System.out.println("Do you want to remove  user " + "  [yes/no]");
                choice = scan.next().toLowerCase(Locale.ROOT);
                if (choice.equals("yes")) {
                    VehicleRemoveManually.remove_manually_vehicle();
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
}


