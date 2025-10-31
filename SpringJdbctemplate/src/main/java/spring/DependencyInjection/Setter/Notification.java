package spring.DependencyInjection.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Notification {
    private MessageService ms;

    @Autowired
    public void setMessageService(MessageService ms) {
        this.ms = ms;
        System.out.println("Setter Injection Applied");
    }

    public void notifyUser(String msg) {
        ms.sendMessage(msg);
    }
}
