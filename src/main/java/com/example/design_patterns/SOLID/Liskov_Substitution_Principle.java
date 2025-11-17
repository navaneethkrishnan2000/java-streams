package com.example.design_patterns.SOLID;

/**
 * A subclass should be replaceable by its parent class without breaking the behavior.
 */
public class Liskov_Substitution_Principle {
    public static void main(String[] args) {

        Notification sms = new SMSNotification();
        sms.send("OTP : 1234");

        Notification email = new EmailNotification();
        email.send("Invoice ready!");

        AttachmentSupport emailAttachment = new EmailNotification();
        emailAttachment.attachFile("invoice.pdf");

        AttachmentSupport whatsappAttachment = new WhatsAppNotification();
        whatsappAttachment.attachFile("image.png");

        // ❌ SMS cannot be used as AttachmentSupport → good design
    }
}

interface Notification {
    void send(String message);
}

interface AttachmentSupport {
    void attachFile(String filePath);
}

// Email supports attachments
class EmailNotification implements Notification, AttachmentSupport {

    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }

    @Override
    public void attachFile(String filePath) {
        System.out.println("Attaching file to email: " + filePath);
    }
}

// SMS does not support attachments, so adding attachment support in SMS is not a good practice
class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// WhatsApp supports attachments
class WhatsAppNotification implements Notification, AttachmentSupport {

    @Override
    public void send(String message) {
        System.out.println("Sending WhatsApp message: " + message);
    }

    @Override
    public void attachFile(String filePath) {
        System.out.println("Sending WhatsApp attachment: " + filePath);
    }
}
