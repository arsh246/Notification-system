package factory;

import notification.EmailNotification;
import notification.Notification;
import notification.PushNotification;
import notification.SMSNotification;

public class NotificationFactory {

    public static Notification createNotification(String type){
        switch (type.toLowerCase()){
            case "email":
                return new EmailNotification();
            case "sms":
                    return new SMSNotification();
            case "push":
                return new PushNotification();
            default:
                throw new IllegalArgumentException(
                        "Unknown type: "+ type
                );
        }
    }
}
