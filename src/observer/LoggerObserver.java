package observer;

import notification.Notification;

public class LoggerObserver implements NotificationObserver {

    public void update(String messageContent) {
        System.out.println("[Logger] Sent: "+messageContent);
    }
}
