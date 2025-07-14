package frutuoso.java10x.EventClean.core.useCases;

import frutuoso.java10x.EventClean.core.entities.Event;
import frutuoso.java10x.EventClean.core.gateway.EventGateway;
import frutuoso.java10x.EventClean.infra.exceptions.NotFoundException;

public class FilterIdentifierCaseImpl implements FilterIdentifierCase{

    private final EventGateway eventGateway;

    public FilterIdentifierCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String identifier) {
        return eventGateway.filterForIdentifier(identifier)
                .orElseThrow(() -> new NotFoundException("Evento com identificador: " + identifier + " não encontrado"));
    }
}
