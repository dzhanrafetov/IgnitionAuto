package CarShopProject.email_verification;


import CarShopProject.login.Register;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;




public class MakeAnnouncement {

    public static String myArrayList;

    public static void sendMail() {

        String to = "can.33@abv.bg";
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

                return new PasswordAuthentication("vehicleproject528@gmail.com", "urlsjgmscgvveowa");

            }

        });

//          session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));


TakeEmails.take_emails();



            String[] recipientList = TakeEmails.formattedString.split(",");
            System.out.println(Arrays.toString(recipientList));
            InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
            int counter = 0;
            for (String recipient : recipientList) {
                recipientAddress[counter] = new InternetAddress(recipient.trim());
                counter++;
            }
            message.setRecipients(Message.RecipientType.TO, recipientAddress);




            // Set Subject: header field
            message.setSubject(TakeEmails.Header);

            // Now set the actual message
            message.setText(TakeEmails.Body);

            // Send message
            Transport.send(message);
            System.out.println("Activation code was sent successfully!!.");
        } catch (MessagingException | SQLException | NoSuchAlgorithmException | ClassNotFoundException mex) {
        }
    }

}





