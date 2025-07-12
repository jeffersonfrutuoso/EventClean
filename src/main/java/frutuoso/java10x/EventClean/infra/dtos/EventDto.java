package frutuoso.java10x.EventClean.infra.dtos;

import frutuoso.java10x.EventClean.core.entities.enums.TypeEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


public record EventDto(Long id,
                       String name,
                       String description,
                       String identifier,
                       LocalDateTime dateStart,
                       LocalDateTime dateEnd,
                       String location,
                       Integer capacity,
                       String organizer,
                       TypeEvent type) {
}
