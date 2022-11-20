package CarShopProject.email_verification;

import CarShopProject.Menus.ResetPassword;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;


public class SendForgetPassword {
    public static String formattedString = null;
    public static String myArrayList;

    public static void runner() {
        code();
        send_forget_password();
    }

    public static void send_forget_password() {

        String to = ResetPassword.email_password_reset;

        String from = "vehicleproject528@gmail.com";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("vehicleproject528@gmail.com", "canimorandi33");

            }

        });

        //  session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Reset Your Password");

            // Now set the actual message
            message.setText("Hi " + ResetPassword.username + "," + "\n" +
                    "We got a request to reset your password" + "\n" +
                    " This is your one-time-code:  " + formattedString + "\n" +
                    "Please write this one-time-code in your console ..." + "\n" +
                    "If you did not request this code, you can ignore this email. Someone may have entered your email address inadvertently.\n" +
                    "\n" +
                    "Thank you,\n" +
                    "The Ignition Auto Company");

            // Send message
            Transport.send(message);
            System.out.println("One-time-code to reset password, was sent successfully!!.");
        } catch (MessagingException mex) {
        }

    }

    public static void code() {
        Random rand = new Random();//

        int[] TOTO = new int[3];//създаваме един масив ,където ще генерираме случайни числа

        for (int i = 0; i < 3; i++) { //тук създаваме една променлива където се генерирват случайни числа от 1-49  ,после добавяме към масива TOTO,това се
            //случва докато не спре цикъла.-тоест докато не стигнем края на масива;
            int randomNumber = rand.nextInt(900) + 100;
            TOTO[i] = +randomNumber;

        }
        myArrayList = Arrays.toString(TOTO);
        formattedString = myArrayList
                .replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "")  //remove the left bracket
                .trim();
    }
}


