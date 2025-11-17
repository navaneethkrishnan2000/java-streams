package com.example.design_patterns.factory_pattern;

/**
 * Creates objects without exposing the creation logic to the client.
 * The client just calls the factory method and the factory decides which object to return.
 *
 * Spring uses factories internally: BeanFactory, ApplicationContext, FactoryBean<T>
 */

interface Notification {
    void send();
}

class EmailNotification implements Notification {
    public void send() { System.out.println("Email sent"); }
}

class SmsNotification implements Notification {
    public void send() { System.out.println("SMS sent"); }
}

/**
 * The Factory class is the heart of the FactoryPattern.
 * It is responsible for creating instances of different subclasses based on a provided String identifier(type).
 * The getInstance method uses a switch statement to determine the type of object requested and returns an instance of the corresponding class.
 */
class NotificationFactory {
    public static Notification getInstance(String type) {
        return switch (type) {
            case "EMAIL" -> new EmailNotification();
            case "SMS" -> new SmsNotification();
            default -> throw new IllegalArgumentException("Invalid type");
        };
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.getInstance("EMAIL");
//        Notification notification = NotificationFactory.getInstance("SMS");
//        Notification notification = NotificationFactory.getInstance("CALL");

        notification.send();
    }
}
