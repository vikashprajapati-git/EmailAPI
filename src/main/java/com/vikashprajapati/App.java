package com.vikashprajapati;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "sending email...." );
        String message="Hello Madhu! sending message from vikash's java code";
        String subject="JAVA | Email | Automation";
        String subject2="JAVA | Email";
        String to="pikachuvikku@gmail.com";
        String from="testingemail0304@gmail.com";

        //sendEmail(message,subject, to, from);
        sendAttach(message,subject,to,from);
    }

    //this function will send message with attachment
    private static void sendAttach(String message, String subject, String to, String from) {
        //Variable for gmail
        String host="smtp.gmail.com";

        //getting system properties
        Properties properties=System.getProperties();
        System.out.println("System Properties: "+ properties);

        //setting impo info to properties obj

        //set host
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        //Step1: to get session obj
        Session session= Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("testingemail0304@gmail.com","zvjihajptrmgfjkv");
            }
        });
        session.setDebug(true);

        //Step2: compose the message[text, multi, media]

        MimeMessage mimeMessage= new MimeMessage(session);


        try {
            //from email id
            mimeMessage.setFrom(from);

            //add recipient to message
            mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

            //add subject to message
            mimeMessage.setSubject(subject);

            //add attachment to message
            String path="C:\\Users\\vikashprajapati\\OneDrive - Nagarro\\Desktop\\3194734_JALSA 2023 REIMBURSEMENT BILLS AND VOUCHER.zip";
            MimeMultipart mimeMultipart=new MimeMultipart();//text and file

            MimeBodyPart textMime=new MimeBodyPart();

            MimeBodyPart fileMime=new MimeBodyPart();

            try {
                textMime.setText(message);

                File file=new File(path);
                fileMime.attachFile(file);

                mimeMultipart.addBodyPart(textMime);
                mimeMultipart.addBodyPart(fileMime);
            }catch (Exception e){
                e.printStackTrace();
            }

            mimeMessage.setContent(mimeMultipart);

            //send message

            //Step3: send the message using Transport class
            Transport.send(mimeMessage);

            System.out.println("sent successfully.............................");

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //this functinn will send mail
    private static void sendEmail(String message, String subject, String to, String from) {
        //Variable for gmail
        String host="smtp.gmail.com";

        //getting system properties
        Properties properties=System.getProperties();
        System.out.println("System Properties: "+ properties);

        //setting impo info to properties obj

        //set host
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        //Step1: to get session obj
        Session session= Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("testingemail0304@gmail.com","zvjihajptrmgfjkv");
            }
        });
        session.setDebug(true);

        //Step2: compose the message[text, multi, media]

        MimeMessage mimeMessage= new MimeMessage(session);


        try {
            //from email id
            mimeMessage.setFrom(from);

            //add recipient to message
            mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

            //add subject to message
            mimeMessage.setSubject(subject);

            //add text to message
            mimeMessage.setText(message);

            //send message

            //Step3: send the message using Transport class
            Transport.send(mimeMessage);

            System.out.println("sent successfully.............................");

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
