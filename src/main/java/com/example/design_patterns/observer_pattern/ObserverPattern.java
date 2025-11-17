package com.example.design_patterns.observer_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Its behavioral pattern.
 * One object (Subject/Publisher) notifies multiple dependent objects(observers) whenever a change happens.
 * This is called Publish–Subscribe (Pub-Sub) mechanism.
 * Eg: using Kafka to publish notifications is a real-world illustration of the Observer Pattern. Kafka implements the Observer Pattern at a distributed system level — using a message broker instead of in-memory observers.

 Real-Life Example
 Imagine YouTube:
 You (subscriber) click Subscribe.
 When the creator uploads a new video (change), YouTube automatically notifies you.
 | Role             | Meaning                   |
 | ---------------- | ------------------------- |
 | YouTube creator  | Subject / Publisher       |
 | Subscribers      | Observers                 |
 | New video upload | Event                     |
 | Notifications    | Updates sent to observers |

 Why do we need Observer Pattern?
 - To maintain a loose coupling between objects.
 - To notify multiple components automatically.
 - To build event-driven applications.
 - To avoid writing "if-else" for every dependent class.
 */

interface Observer {
    void update(String message);
}
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}
class ProductStock implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) { observers.add(observer); }

    @Override
    public void removeObserver(Observer observer) { observers.remove(observer); }

    @Override
    public void notifyObservers(String message) {
        for (Observer obs : observers) {
            obs.update(message);
        }
    }

    public void newStockArrived() {
        System.out.println("New stock available!");
        notifyObservers("New product stock available!");
    }
}

class EmailNotification implements Observer {
    @Override
    public void update(String message) { System.out.println("Email: " + message); }
}
class SmsNotification implements Observer {
    @Override
    public void update(String message) { System.out.println("SMS: " + message); }
}
public class ObserverPattern {
    public static void main(String[] args) {
        ProductStock stock = new ProductStock();

        Observer email = new EmailNotification();
        Observer sms = new SmsNotification();

        stock.registerObserver(email);
        stock.registerObserver(sms);

        stock.newStockArrived();
    }
}
