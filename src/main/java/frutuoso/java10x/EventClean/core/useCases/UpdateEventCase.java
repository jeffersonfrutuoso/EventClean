package frutuoso.java10x.EventClean.core.useCases;

import frutuoso.java10x.EventClean.core.entities.Event;

public interface UpdateEventCase {
    public Event execute(Event event, Long id);
}
