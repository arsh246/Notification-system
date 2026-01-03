import decorator.EncryptedMessage;
import decorator.TimestampedMessage;
import factory.NotificationFactory;
import model.Message;
import notification.Notification;
import observer.AnalyticsObserver;
import observer.LoggerObserver;
import singleton.NotificationManager;
import strategy.ImmediateSendStrategy;

public class NotificationSystemApp {

    public static void main(String[] args) {

        //Base message

        Message baseMessage = () -> "Hello user|";
        Message encrypted = new EncryptedMessage(baseMessage);
        Message decorated = new TimestampedMessage(encrypted);

        // Create notification type

        Notification notification
                = NotificationFactory.createNotification("email");

        notification.setStrategy(
                new ImmediateSendStrategy()
        );

        // Singleton manager
        NotificationManager notificationManager = NotificationManager.getInstance();
        notificationManager.registerObserver(new LoggerObserver());
        notificationManager.registerObserver(new AnalyticsObserver());

        //send
        notificationManager.sendNotification(notification, decorated);

    }
}
