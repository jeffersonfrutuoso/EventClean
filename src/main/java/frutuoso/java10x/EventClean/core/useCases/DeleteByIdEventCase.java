package frutuoso.java10x.EventClean.core.useCases;

import frutuoso.java10x.EventClean.core.entities.Event;

public interface DeleteByIdEventCase {
    public void execute(Long id);
}
