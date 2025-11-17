package com.example.design_patterns.SOLID;

/**
 * A class should have only one reason to change (one responsibility).
 *  -- UserService handles: user registration, sending email, generating PDF, validating data, This makes it large, hard to modify, and untestable.

    BAD EXAMPLE
     class Notification { // Parent class (Wrong design)
         void send(String message) {
            System.out.println("Sending notification: " + message);
         }

         void attachFile(String filePath) {
            System.out.println("Attaching file: " + filePath);
         }
     }

     class SMSNotification extends Notification { // Subclass — SMS Notification (Cannot attach files)
        @Override
        void attachFile(String filePath) {
            throw new UnSupportedOperationException("SMS cannot have attachments!");
        }
     }

     public class LSPBadExampleNotification {
         public static void main(String[] args) {

         Notification notification = new SMSNotification();
         notification.send("Hello!");

         notification.attachFile("invoice.pdf"); // ❌ CRASHES
         }
     }

 */
public class Single_Responsibility_Principle {
    public static void main(String[] args) {

        ValidationService validation = new ValidationService();
        EmailService emailService = new EmailService();
        PdfService pdfService = new PdfService();

        UserService userService = new UserService(validation, emailService, pdfService);

        User user = new User("Navaneeth", "navaneeth@test.com");
        userService.registerUser(user);
    }
}

class ValidationService {
    public void validate(User user) {
        System.out.println("Validating user...");
    }
}

class EmailService {
    public void sendWelcomeEmail(User user) {
        System.out.println("Sending welcome email to: " + user.getEmail());
    }
}

class PdfService {
    public void generateWelcomePDF(User user) {
        System.out.println("Generating welcome PDF for: " + user.getName());
    }
}

class UserService {
    private final ValidationService validationService;
    private final EmailService emailService;
    private final PdfService pdfService;

    public UserService(ValidationService validationService,
                       EmailService emailService,
                       PdfService pdfService) {
        this.validationService = validationService;
        this.emailService = emailService;
        this.pdfService = pdfService;
    }

    public void registerUser(User user) {
        validationService.validate(user);
        // Save user to DB
        emailService.sendWelcomeEmail(user);
        pdfService.generateWelcomePDF(user);
    }
}


class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}


