package CarShopProject.email_verification;

import CarShopProject.login.Register;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;



public class SendMail {
    public static String formattedString = null;
    public static String myArrayList;

    public static void runner() {
       code();
        sendMail();
    }
    public static void sendMail() {

        String to = Register.email;
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
            message.setSubject("Your disposable code for creating your account ... ");

            // Now set the actual message
            message.setText("Hello "+Register.userName+"!"+ "\n"+" This is your activation code:  "+ formattedString+"\n" +
                    "Please write this code in your console ..."+"\n"+
                    "If you did not request this code, you can ignore this email. Someone may have entered your email address inadvertently.\n" +
                    "\n" +
                    "Thank you,\n" +
                    "The Ignition Auto Company");

            // Send message
            Transport.send(message);
            System.out.println("Activation code was sent successfully!!.");
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
        myArrayList=Arrays.toString(TOTO);
          formattedString = myArrayList
                .replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "")  //remove the left bracket
                .trim();
    }
}


