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


public class VehicleAddManually {
    protected static final String CREATE_QUERY = "INSERT INTO vehicles( `type`, `brand`, `model`,`color`,`horsepower`,`price`) VALUES( ?, ?, ?, ?, ?, ?)";

    public static String type;
    public static String brand;
    public static String model;
    public static String color;
    public static int horsepower;
    public static int price;

    public static void add_manually_cehixle() throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {


        Scanner scan = new Scanner(System.in);

        Connection con = null;
        ResultSet rs = null;


        try {
            con = ConnectionProvider.getConnection();


            PreparedStatement preparedStatement = con.prepareStatement(CREATE_QUERY);

            System.out.println(" Enter type ");
            type = scan.next().toUpperCase();
            System.out.println(" Enter brand ");
            brand = scan.next().toUpperCase();
            System.out.println(" Enter model ");
            model = scan.next().toUpperCase();
            System.out.println(" Enter color ");
            color = scan.next();
            System.out.println(" Enter horsepower ");
            horsepower = scan.nextInt();
            System.out.println(" Enter price ");
            price = scan.nextInt();

           color = color.substring(0, 1).toUpperCase() + color.substring(1);
String choice_sure;
            System.out.println("Are you sure to add this vehicle with details yes/no : \n" +"\n"+"\n"+
                    "type " + type +"\n"+
                    "brand " + brand +"\n"+
                    "model " + model +"\n"+
                    "color " + color +"\n"+
                    "horse power  " + horsepower +"\n"+
                    "price" + price);
            choice_sure=scan.next().toLowerCase(Locale.ROOT);
            if(choice_sure.equals("yes")  ) {

                preparedStatement.setString(1, type);
                preparedStatement.setString(2, brand);
                preparedStatement.setString(3, model);
                preparedStatement.setString(4, color);
                preparedStatement.setInt(5, horsepower);
                preparedStatement.setInt(6, price);

                preparedStatement.executeUpdate();
                System.out.println("Vehicle  successfully added");

            }else {
                String choice;
                System.out.println("Do you want to add new details"+"  [yes/no]" );
                choice=scan.next().toLowerCase(Locale.ROOT);
                if(choice.equals("yes")) {
                    VehicleAddManually.add_manually_cehixle();
                }else  if(choice.equals("no")){
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


