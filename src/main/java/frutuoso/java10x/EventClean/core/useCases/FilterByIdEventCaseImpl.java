package frutuoso.java10x.EventClean.core.useCases;

import frutuoso.java10x.EventClean.core.entities.Event;
import frutuoso.java10x.EventClean.core.gateway.EventGateway;
import frutuoso.java10x.EventClean.infra.exceptions.NotFoundIdException;

import java.util.Optional;

public class FilterByIdEventCaseImpl implements FilterByIdEventCase{

    private final EventGateway eventGateway;

    public FilterByIdEventCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Long id) {
        return eventGateway.filterById(id)
                .orElseThrow(() -> new NotFoundIdException("Evento com o id " + id + " não encontrado"));
    }
}
