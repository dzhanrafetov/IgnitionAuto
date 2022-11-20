package CarShopProject.Menus;

import CarShopProject.ADD_Manualy.*;
import CarShopProject.Applicantss.ShowEmployee;
import CarShopProject.Core_Store;
import CarShopProject.Vehicle_Package.ShowVehicles;
import CarShopProject.email_verification.TakeEmails;
import CarShopProject.login.ShowLoggedUsers;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminMenu {
    static Core_Store Core_Store = new Core_Store("Auto Number 1", "Bulgaria");


    public static void admin_menu() throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {
        System.out.println("       ADMIN MENU     ");
        System.out.println("Select .....");
        System.out.println("" +
                "1.Show Vehicles    " + "\n" +
                "2.Show Employees" + "\n" +
                "3.Show Logged Users" + "\n" +
                "4.Show All Users" + "\n" +
                "5.Add Employee (Manually) " + "\n" +
                "6.Add Vehicle  (Manually) " + "\n" +
                "7.Add User (Manually)" + "\n" +
                "8.Remove Vehicle" + "\n" +
                "9.Remove Employee" + "\n" +
                "10.Remove User" + "\n" +
                "11.Make Announcement " + "\n" +
                "12.Change Password" + "\n" +

                "" + "\n");


        Scanner scan = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            choice = scan.nextInt();

            switch (choice) {
                case 1 -> ShowVehicles.showvehiclesmenu(Core_Store);
                case 2 -> ShowEmployee.showemployee_menu(Core_Store);
                case 3 -> ShowLoggedUsers.logged_users();
                case 4 -> ShowLoggedUsers.show_all_users();
                case 5 -> {
                    System.out.println("Add Employee (Manually) ");
                    EmployeeAddManually.add_manually_employee();
                }
                case 6 -> {
                    System.out.println("Add Vehicle  (Manually) ");
                    VehicleAddManually.add_manually_cehixle();
                }
                case 7 -> {
                    System.out.println("Add User  (Manually) ");
                    UserAddManually.add_user_manually();
                }
                case 8 -> {
                    System.out.println("Remove Vehicle  (Manually) ");
                    VehicleRemoveManually.remove_manually_vehicle();
                }
                case 9 -> {
                    System.out.println("Remove Employee  (Manually) ");
                    EmployeeRemove.remove_manually_employee();
                }
                case 10 -> {
                    System.out.println("Remove User  (Manually) ");
                    UserRemoveManually.remove_manually_user();
                }
                case 11 -> {
                    System.out.println("Make Announcement ");
                    TakeEmails.send_emails();
                }
                case 12 -> ResetPassword.resset_password();
                default -> System.out.println("Wrong choice , Please enter number between ()");
            }
        }
        System.out.println("You are exiting");


    }
}
