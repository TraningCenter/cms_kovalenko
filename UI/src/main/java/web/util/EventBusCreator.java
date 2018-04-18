package web.util;

import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

import javax.ejb.Stateless;

@Stateless
public class EventBusCreator {

    private EventBus eventBus;

    public EventBus getEventBus() {
        eventBus = EventBusFactory.getDefault().eventBus();
        return eventBus;
    }

    public void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }
}
