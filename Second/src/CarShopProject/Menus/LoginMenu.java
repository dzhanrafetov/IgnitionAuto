package CarShopProject.Menus;

import CarShopProject.login.LoginDao;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginMenu {
    public static void loginmenu() throws SQLException, NoSuchAlgorithmException {
        System.out.println("Select Role to login ");
        System.out.println("1.Admin");
        System.out.println("2.Client");
        System.out.println("3.Employee");
        System.out.println("4.Guest");
        Scanner scan=new Scanner(System.in);

        int choice = -1;

        while(choice == 0){
            switch (choice){
                case 1:
                    LoginDao.login_menu();
            }
        }
    }
}
