package com.rjcollege.sendmail;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail extends AsyncTask {
    private Context context;
    private Session session;
    private String senderEmail;
    private String senderPassword;
    private String receiverEmail;
    private String subject;
    private String messageType;
    private String message;
    private ProgressDialog progressDialog;



    public SendMail(Context context, String senderEmail, String senderPassword, String receiverEmail, String subject, String messageType, String message) {
        this.context = context;
        this.senderEmail = senderEmail;
        this.senderPassword = senderPassword;
        this.receiverEmail = receiverEmail;
        this.subject = subject;
        this.messageType = messageType;
        this.message = message;
    }




    @Override
    protected Object doInBackground(Object[] objects) {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        try {
            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress(senderEmail));
            mm.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));
            mm.setSubject(subject);
            if (messageType.equals("html")){
                mm.setContent(message,"text/html");
            }else{
                mm.setText(message);
            }
            Transport.send(mm);
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please Wait.......");
        progressDialog.show();


    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        progressDialog.dismiss();
//        Toast.makeText(context,"Message Sent",Toast.LENGTH_LONG).show();
    }



    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public void setSenderPassword(String senderPassword) {
        this.senderPassword = senderPassword;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
