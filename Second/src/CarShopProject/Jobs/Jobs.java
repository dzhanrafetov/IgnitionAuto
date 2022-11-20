package CarShopProject.Jobs;

import CarShopProject.Core_Store;
import CarShopProject.Menu;

import java.util.Scanner;

public class Jobs {


    public static void jobsInfo(Core_Store coreStore) {
        Scanner scan = new Scanner(System.in);
        System.out.println("=======YOU HAVE SELECTED JOB HELP========");

        int choice2 = -1;
        String choice = "yes";
        while (!choice.equals("no")) {
            System.out.println();
            System.out.println("Choose about what position you need information");
            System.out.println();
            System.out.println("""
                    1. Manager \s
                    2. Auto Mechanic\s
                    3. Car Salesperson\s
                    4. Vehicle Inspector\s
                    5. Tow truck driver\s
                    6. Auto engineer\s
                    7. Tire technician\s
                    0. Go to Main Menu\s
                    """
            );
            System.out.print("Enter number: ");
            choice2 = scan.nextInt();
            switch (choice2) {


                case 1:
                    System.out.println("Needed things for Manager position:");
                    System.out.println("Education: Must be high");
                    System.out.println("Experience: At least 4 years");

                    break;
                case 2:
                    System.out.println("Needed things for Mechanic position:");
                    System.out.println("Education: At least secondary");
                    System.out.println("Experience: At least 2 years");
                    break;
                case 3:
                    System.out.println("Needed things for Salesperson position:");
                    System.out.println("Education: At least secondary");
                    System.out.println("Experience: At least 2 years");

                    break;

                case 4:
                    System.out.println("Needed things for Inspector position:");
                    System.out.println("Education: At least secondary");
                    System.out.println("Experience: At least 8 years");
                    break;

                case 5:
                    System.out.println("Needed things for Driver position:");
                    System.out.println("Education: At least secondary");
                    System.out.println("Experience: At least 3 years");

                    break;
                case 6:
                    System.out.println("Needed things for Engineer position:");
                    System.out.println("Education: Must be high");
                    System.out.println("Experience: At least 5 years");
                    break;


                case 7:
                    System.out.println("Needed things for Technician position:");
                    System.out.println("Education: At least secondary");
                    System.out.println("Experience: At least 3 years");
                    break;
                case 0:
                    Menu.menu(coreStore);
                    break;

            }
            System.out.println();
            System.out.print("Would you like to take new delivery: [yes][no]");
            choice = scan.next();
            if (choice.equals("no")) {
                choice = "no";
            }
        }
        Menu.menu(coreStore);
    }
}