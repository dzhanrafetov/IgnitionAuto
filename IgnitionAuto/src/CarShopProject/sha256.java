package CarShopProject;

import CarShopProject.ADD_Manualy.UserAddManually;
import CarShopProject.Menus.ResetPassword;
import CarShopProject.login.LoginDao;
import CarShopProject.login.Register;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class sha256 {
    public static String password;

    public static void start_hashing() throws NoSuchAlgorithmException, SQLException {

        LoginDao.login_password = hash256(LoginDao.login_password);

    }

    public static void start_hashing_register() throws NoSuchAlgorithmException, SQLException {

        Register.password = hash256(Register.password);


    }
    public static void start_hashing_newpassword() throws NoSuchAlgorithmException, SQLException {

        ResetPassword.new_password = hash256( ResetPassword.new_password);


    }
    public static void start_hashing_usermanually() throws NoSuchAlgorithmException, SQLException {

        UserAddManually.password = hash256(UserAddManually.password);

    }
    public static String hash256(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        return bytesToHex(md.digest());
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }
}