package notification;

import model.Message;
import strategy.SendStrategy;

public abstract class Notification {

    protected SendStrategy sendStrategy;

    public void setStrategy(SendStrategy sendStrategy) {
        this.sendStrategy = sendStrategy;
    }

    public void send(Message message) {
        if(sendStrategy != null) {
            sendStrategy.send(message);
        }
        else  {
            System.out.println("Send strategy not found");
        }
    }
}
