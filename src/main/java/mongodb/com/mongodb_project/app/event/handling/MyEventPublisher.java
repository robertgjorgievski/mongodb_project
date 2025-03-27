package mongodb.com.mongodb_project.app.event.handling;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MyEventPublisher {

    public final ApplicationEventPublisher publisher;

    public MyEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishEventMessage(String message) {
        publisher.publishEvent(new MyEvent(this, message));
    }
}
