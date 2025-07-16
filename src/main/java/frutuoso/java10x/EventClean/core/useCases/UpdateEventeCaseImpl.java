package frutuoso.java10x.EventClean.core.useCases;

import frutuoso.java10x.EventClean.core.entities.Event;
import frutuoso.java10x.EventClean.core.gateway.EventGateway;
import frutuoso.java10x.EventClean.infra.exceptions.NotFoundIdException;

public class UpdateEventeCaseImpl implements UpdateEventCase{

    private final EventGateway eventGateway;

    public UpdateEventeCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event, Long id) {
        if(!eventGateway.filterById(id).isPresent()){
            throw new NotFoundIdException("evento com o ID: " + id + " não existe, tente outro");
        }
        return eventGateway.updatedEvent(event,id);
    }
}
