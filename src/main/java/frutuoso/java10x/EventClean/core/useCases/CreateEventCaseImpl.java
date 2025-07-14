package frutuoso.java10x.EventClean.core.useCases;

import frutuoso.java10x.EventClean.core.entities.Event;
import frutuoso.java10x.EventClean.core.gateway.EventGateway;
import frutuoso.java10x.EventClean.infra.exceptions.DuplicateEventException;

public class CreateEventCaseImpl implements CreateEventCase{

    private final EventGateway eventGateway;

    public CreateEventCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        if (eventGateway.indentifierExists(event.identifier())){
            throw new DuplicateEventException("O evento com o identificador: " + event.identifier() + " ja existe");
        }
        return eventGateway.createEvent(event);
    }
}
