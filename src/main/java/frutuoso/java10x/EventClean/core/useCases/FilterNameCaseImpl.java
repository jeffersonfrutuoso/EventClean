package frutuoso.java10x.EventClean.core.useCases;

import frutuoso.java10x.EventClean.core.entities.Event;
import frutuoso.java10x.EventClean.core.gateway.EventGateway;
import frutuoso.java10x.EventClean.infra.exceptions.NotFoundException;

public class FilterNameCaseImpl implements FilterNameCase{

    private final EventGateway eventGateway;

    public FilterNameCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String name) {
        return eventGateway.filterForName(name)
                .orElseThrow(() -> new NotFoundException("Evento com nome: " + name + " não encontrado"));
    }
}
