package CarShopProject.Applicantss;

import CarShopProject.Core_Store;
import CarShopProject.Menu;
import CarShopProject.Menus.AdminMenu;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

import static CarShopProject.Applicantss.ShowEmplMethods.*;

public class ShowEmployee {


    public static void showemployee_menu(Core_Store coreStore) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        totalEmployees(coreStore);
        showCount(coreStore);
        System.out.println("          ");
        System.out.println(" Please select action  from below and type the number of the action !" +
                "         ");
        System.out.println("    " +
                "      ");

        System.out.println("0.Back to Main");
        System.out.println("1.Search for employee");
        System.out.println("2.See all employees");
        int showempl_menu_choice = scan.nextInt();

        switch (showempl_menu_choice) {
            case 0:
                System.out.println("Redirecting to main menu");
                //Towa go podobri
                //-------------------------------------------------------
                AdminMenu.admin_menu();
                break;
            case 1:
                searchEmployee(coreStore);
                break;
            case 2:
                showEmployees(coreStore);
        }
    }
}
