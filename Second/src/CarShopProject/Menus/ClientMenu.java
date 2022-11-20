package CarShopProject.Menus;

import CarShopProject.Applicantss.AddEmpl;
import CarShopProject.Core_Store;
import CarShopProject.Jobs.Jobs;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.util.Scanner;

public class ClientMenu {
    private static CarShopProject.Core_Store Core_Store;

    public static void client_menu() throws SQLException, ClassNotFoundException, MessagingException {

        Scanner scan = new Scanner(System.in);
        int choice = -1;
        menu();
        while (choice != 0) {
            choice = scan.nextInt();

            if (choice == 1) {
                // Car_ADD.addCars(Core_Store);

            }
            if (choice == 2) {
                //  AddEmpl.addEmpl(Core_Store);

            }
            if (choice == 3) {

                AddEmpl.addEmpl(Core_Store);
            }
            if (choice == 4) {

                //   ShowVehicles.showvehiclesmenu(Core_Store);
            }

            if (choice == 5) {
               Jobs.jobsInfo(Core_Store);

            }
            if (choice == 6) {
                //   LoginDao.loinguser();

            }

        }
        System.out.println("You are exiting");


    }

    public static void menu() {
        System.out.println("                       ");
        System.out.println("                       ");
        System.out.println("                       ");
        System.out.println("       CLIENT MENU     ");
        System.out.println("Select .....");
        System.out.println("                       ");

        System.out.println("" +
                "1.See our Vehicles    " + "\n" +
                "2.Search for a Vehicle" + "\n" +
                "3.Candidate for a job" + "\n" +
                "4.Jobs Info" + "\n" +
                "5.Vehicle info" + "\n" +
                "6.Buy a Vehicle" + "\n" +
                "7.Guarantee" + "\n" +
                "8.Send Feedback" + "\n" +
                "9.Deposit money {SOON}" + "\n" +

                "" + "\n");
    }

}
