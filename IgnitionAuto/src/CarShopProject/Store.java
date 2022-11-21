package CarShopProject;

import CarShopProject.Date.DateUtils;
import CarShopProject.Menus.ResetPassword;
import CarShopProject.login.LoginDao;
import CarShopProject.login.Register;

import javax.mail.MessagingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Scanner;



public class Store {

static Core_Store Core_Store= new Core_Store("Auto Number 1", "Bulgaria");

    public static void main(String[] args) throws SQLException, ClassNotFoundException, MessagingException, NoSuchAlgorithmException {


        Scanner scan = new Scanner(System.in);
        int choice = -1;
        System.out.println(   DateUtils.getTimeStamp());


        Menu.menu(Core_Store);
        while (choice != 0) {
            choice = scan.nextInt();

            if (choice == 1) {
                LoginDao.login_menu();

//BLOG

            }
            if (choice == 2) {
                Register.getting_register_data();

            }
            if (choice == 3) {
                ResetPassword.resset_password();

            }
        }
        System.out.println("You are exiting");

    
    }
}











//                    Desktop.getDesktop().browse(new URL("http://www.google.com").toURI());