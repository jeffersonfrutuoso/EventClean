package frutuoso.java10x.EventClean.core.entities;

import frutuoso.java10x.EventClean.core.entities.enums.TypeEvent;

import java.time.LocalDateTime;

public record Event(
        Long id,
        String name,
        String description,
        String identifier,
        LocalDateTime dateStart,
        LocalDateTime dateEnd,
        String location,
        Integer capacity,
        String organizer,
        TypeEvent type
) {

}
