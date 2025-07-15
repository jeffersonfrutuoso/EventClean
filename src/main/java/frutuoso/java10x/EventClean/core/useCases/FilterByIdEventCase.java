package frutuoso.java10x.EventClean.core.useCases;

import frutuoso.java10x.EventClean.core.entities.Event;

import java.util.Optional;

public interface FilterByIdEventCase {
    public Event execute(Long id);
}
