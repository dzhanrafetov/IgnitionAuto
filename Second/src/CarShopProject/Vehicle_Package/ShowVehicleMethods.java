package CarShopProject.Vehicle_Package;

import CarShopProject.ConnectionProvider;
import CarShopProject.Core_Store;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.*;

public class ShowVehicleMethods {

    protected static String TOTAL_VEHICLES = "SELECT COUNT(distinct t1.id) AS totalRows FROM shop_db.vehicles t1;";
    protected static String COUNT_QUERY_TYPES = "SELECT  type, COUNT(*) FROM shop_db.vehicles GROUP BY type;";
    protected static String COUNT_QUERY_BRAND = "SELECT  brand, COUNT(*) FROM shop_db.vehicles GROUP BY brand;";
    protected static final String READ_QUERY_DISTINCT_TYPE = "SELECT DISTINCT type FROM vehicles";
    protected static final String READ_QUERY_DISTINCT_BRAND = "SELECT DISTINCT brand FROM vehicles";
    protected static final String GET_QUERY_TYPE = "SELECT * FROM vehicles WHERE type = ?";
    protected static final String GET_QUERY_BRAND = "SELECT * FROM vehicles WHERE brand = ?";
    protected static final String SEARCH_VEHICLE_BY_NAME = "SELECT * FROM shop_db.vehicles WHERE brand = ? AND model = ?; ";

    public static void totalVehicles(Core_Store coreStore) {
        Connection con;
        ResultSet rs;

        try {
            con = ConnectionProvider.getConnection();

            PreparedStatement preparedStatement2 = con.prepareStatement(TOTAL_VEHICLES);

            rs = preparedStatement2.executeQuery();
            System.out.println("     ");
            System.out.println("TOTAL VEHICLES SUMMARY");
            while (rs.next())
                System.out.println("TOTAL [" + rs.getInt("totalRows") + "]  VEHICLES ARE IN STOCK !");
            con.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void showbrandcount(Core_Store coreStore) {
        Connection con = null;
        ResultSet rs = null;
        Scanner scan = new Scanner(System.in);


        try {
            con = ConnectionProvider.getConnection();

            PreparedStatement preparedStatement2 = con.prepareStatement(COUNT_QUERY_BRAND);

            rs = preparedStatement2.executeQuery();

            while (rs.next())
                System.out.println(

                        "Brand: " + rs.getString("brand") + " " +
                                " [" +
                                rs.getInt("COUNT(*)") + "]" +
                                "  available vehicles");

            showBrand(coreStore);
            con.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void showtypescount(Core_Store coreStore) {
        Connection con = null;
        ResultSet rs = null;


        try {
            con = ConnectionProvider.getConnection();

            PreparedStatement preparedStatement2 = con.prepareStatement(COUNT_QUERY_TYPES);

            rs = preparedStatement2.executeQuery();

            while (rs.next())
                System.out.println(

                        "Type: " + rs.getString("type") + " " +
                                " [" +
                                rs.getInt("COUNT(*)") + "]" +
                                "  available vehicles");
            con.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    //=====================================SHOW TYPES=====================================================

    public static void showTypes(Core_Store coreStore) {
        Connection con = null;
        ResultSet rs = null;

        Scanner scan = new Scanner(System.in);
        try {
            con = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement2 = con.prepareStatement(READ_QUERY_DISTINCT_TYPE);
            rs = preparedStatement2.executeQuery();


            PreparedStatement preparedStatement = con.prepareStatement(GET_QUERY_TYPE);


            String type_choice = scan.next().toUpperCase(Locale.ROOT);


            preparedStatement.setString(1, type_choice);


            rs = preparedStatement.executeQuery();
            System.out.println("     ");
            printVehicle(con, rs);
            System.out.println("Would your want see another type");
            int answer = scan.nextInt();
            System.out.println("1. yes");
            System.out.println("2. no");
            if (answer == 1) {
                showTypes(coreStore);
            } else {
                ShowVehicles.showvehiclesmenu(coreStore);

            }

        } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException throwables) {
            throwables.printStackTrace();
        }
    }


    //=====================================SHOW BRAND=====================================================

    public static void showBrand(Core_Store coreStore) {
        Connection con;
        ResultSet rs;

        Scanner scan = new Scanner(System.in);
        try {
            con = ConnectionProvider.getConnection();


            PreparedStatement preparedStatement = con.prepareStatement(GET_QUERY_BRAND);


            String brand_choice = scan.next().toUpperCase(Locale.ROOT);


            preparedStatement.setString(1, brand_choice);


            rs = preparedStatement.executeQuery();
            System.out.println("======== SELECTED BRAND [" + brand_choice.toUpperCase(Locale.ROOT) + "] ===========");
            extracted_method(coreStore, con, rs, scan);

        } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException throwables) {
            throwables.printStackTrace();
        }

    }

    private static void extracted_method(Core_Store coreStore, Connection con, ResultSet rs, Scanner scan) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {
        printVehicle(con, rs);
        System.out.println("Would you want to look for another brand");
        int answer = scan.nextInt();
        System.out.println("1. yes");
        System.out.println("2. no");
        if (answer == 1) {
            showBrand(coreStore);
        } else {
            ShowVehicles.showvehiclesmenu(coreStore);

        }
    }


    public static void showPrices(Core_Store coreStore) {
        Connection con;
        ResultSet rs;
        String READ_QUERY_LOWEST_PRICE = "SELECT * FROM vehicles Where price BETWEEN 0 AND 30000 Order by price asc";
        String READ_QUERY_HIGHEST_PRICE = "SELECT * FROM vehicles Where price BETWEEN 30000 AND 9999999999 Order by price desc";
        String READ_QUERY_YOUR_PRICE = "SELECT * FROM vehicles Where price BETWEEN ? AND ? Order by price asc";

        Scanner scan = new Scanner(System.in);
        try {
            con = ConnectionProvider.getConnection();

            System.out.println("Select what prices want to see in vehicles");
            System.out.println("1.LOWEST PRICES \n" +
                    "2.HIGHEST PRICES \n" +
                    "3.YOUR PRICE LIMITS");
            int price_choice = scan.nextInt();

            if (price_choice == 1) {

                PreparedStatement preparedStatement2 = con.prepareStatement(READ_QUERY_LOWEST_PRICE);
                rs = preparedStatement2.executeQuery();
                printVehicle(con, rs);
            } else if (price_choice == 2) {
                PreparedStatement preparedStatement2 = con.prepareStatement(READ_QUERY_HIGHEST_PRICE);
                rs = preparedStatement2.executeQuery();
                printVehicle(con, rs);

            } else if (price_choice == 3) {
                PreparedStatement preparedStatement2 = con.prepareStatement(READ_QUERY_YOUR_PRICE);
                System.out.println("ENTER MIN PRICE: ");
                int your_min_price = scan.nextInt();

                System.out.println("ENTER MAX PRICE:");
                int your_max_price = scan.nextInt();

                preparedStatement2.setInt(1, your_min_price);
                preparedStatement2.setInt(2, your_max_price);
                rs = preparedStatement2.executeQuery();

                printVehicle(con, rs);

            }
            System.out.println("          ");
            System.out.println("          ");

            System.out.println("Would your want see another prices");
            int answer = scan.nextInt();
            System.out.println("1. yes");
            System.out.println("2. no");
            if (answer == 1) {
                showPrices(coreStore);
            } else {
                ShowVehicles.showvehiclesmenu(coreStore);

            }
        } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException throwables) {
            throwables.printStackTrace();
        }

    }

    private static void printVehicle(Connection con, ResultSet rs) throws SQLException {
        while (rs.next())
            System.out.println(
                    "[ID] : " + rs.getInt("id") + "\n" +
                            "[TYPE] : " + rs.getString("type") + "\n" +
                            "[BRAND] : " + rs.getString("brand") + "\n" +
                            "[MODEL] : " + rs.getString("model") + "\n" +
                            "[HORSEPOWER] : " + rs.getInt("horsepower") + "\n" +
                            "[PRICE] : " + rs.getInt("price") + " $" + "\n"
                            + "   " + "\n");

        con.close();
    }


    public static void sos(Core_Store coreStore) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        Scanner scan = new Scanner(System.in);
        try {
            con = ConnectionProvider.getConnection();
            stmt = con.createStatement();
            PreparedStatement preparedStatement2 = con.prepareStatement(READ_QUERY_DISTINCT_BRAND);
            rs = preparedStatement2.executeQuery();
            while (rs.next())
                System.out.println(
                        "  " + rs.getString("brand"));


            PreparedStatement preparedStatement = con.prepareStatement(GET_QUERY_BRAND);


            String brand_choice = scan.next().toUpperCase(Locale.ROOT);


            preparedStatement.setString(1, brand_choice);


            rs = preparedStatement.executeQuery();
            extracted_method(coreStore, con, rs, scan);

        } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException throwables) {
            throwables.printStackTrace();
        }
    }



    public static void searchVehicle(Core_Store coreStore) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Scanner scan = new Scanner(System.in);


        try {
            con = ConnectionProvider.getConnection();
            stmt = con.createStatement();
            System.out.println("Write Vehicle's brand");
            String brand = scan.next();
            System.out.println("Write Vehicle's model");
            String model = scan.next();
            PreparedStatement preparedStatement2 = con.prepareStatement(SEARCH_VEHICLE_BY_NAME);
            preparedStatement2.setString(1, brand);
            preparedStatement2.setString(2, model);

            rs = preparedStatement2.executeQuery();

            System.out.println("     ");
            System.out.println("SEARCHING VEHICLE WITH NAME:  [" + brand + " " + model + "] ...");
            printVehicle(con, rs);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }



}



