package frutuoso.java10x.EventClean.core.useCases;

import frutuoso.java10x.EventClean.core.entities.Event;
import frutuoso.java10x.EventClean.core.gateway.EventGateway;

public class UpdateEventeCaseImpl implements UpdateEventCase{

    private final EventGateway eventGateway;

    public UpdateEventeCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event, Long id) {
        return eventGateway.updatedEvent(event,id);
    }
}
