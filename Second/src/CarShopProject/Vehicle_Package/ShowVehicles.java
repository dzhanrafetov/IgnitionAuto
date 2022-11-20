package CarShopProject.Vehicle_Package;

import CarShopProject.Core_Store;
import CarShopProject.Menu;
import CarShopProject.Menus.AdminMenu;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;
import static CarShopProject.Vehicle_Package.ShowVehicleMethods.*;

public class ShowVehicles {
    public static void showvehiclesmenu(Core_Store coreStore) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);


        totalVehicles(coreStore);
        System.out.println("0. Back to main menu");
        System.out.println("1. Select by type");
        System.out.println("2. Select by name");
        System.out.println("3. Select by price");
        System.out.println("4. Search vehicle");

        int select_choice = scan.nextInt();


        switch (select_choice) {
            case 1 -> {
                System.out.println("Write the type to see the vehicles with this type");
                showtypescount(coreStore);

            }
            case 2 -> {
                System.out.println("Write the brand to see the vehicles with this brand");
                showbrandcount(coreStore);
            }
            case 3 -> {
                System.out.println("Select LOWEST or HIGHEST price or enter YOUR LIMITS PRICE");
                showPrices(coreStore);
            }
            case 4 -> {
                System.out.println("SEARCH VEHICLE");
                searchVehicle(coreStore);
            }
            default -> {
//podobri  admin/client/menu
                AdminMenu.admin_menu();
            }


        }
    }

}
