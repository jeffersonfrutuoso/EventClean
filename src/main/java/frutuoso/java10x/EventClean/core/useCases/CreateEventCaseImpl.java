package frutuoso.java10x.EventClean.core.useCases;

import frutuoso.java10x.EventClean.core.entities.Event;
import frutuoso.java10x.EventClean.core.gateway.EventGateway;

public class CreateEventCaseImpl implements CreateEventCase{

    private final EventGateway eventGateway;

    public CreateEventCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        return eventGateway.createEvent(event);
    }
}
