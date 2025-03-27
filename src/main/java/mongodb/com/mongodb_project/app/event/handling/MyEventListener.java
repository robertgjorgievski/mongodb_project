package mongodb.com.mongodb_project.app.event.handling;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener {

    @EventListener
    public void listen(MyEvent event) {
        System.out.println("The message " + event.message + " was received");
    }
}
