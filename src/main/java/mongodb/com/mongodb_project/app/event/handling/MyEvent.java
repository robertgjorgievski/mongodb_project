package mongodb.com.mongodb_project.app.event.handling;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

    public final String message;

    public MyEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}
