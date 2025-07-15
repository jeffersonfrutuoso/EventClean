package frutuoso.java10x.EventClean.core.useCases;

import frutuoso.java10x.EventClean.core.gateway.EventGateway;

public class DeleteByIdCaseImpl implements DeleteByIdEventCase{

    private final EventGateway eventGateway;

    public DeleteByIdCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public void execute(Long id) {
        eventGateway.deleteById(id);
    }
}
