package frutuoso.java10x.EventClean.infra.mapper;

import frutuoso.java10x.EventClean.core.entities.Event;
import frutuoso.java10x.EventClean.infra.dtos.EventDto;
import frutuoso.java10x.EventClean.infra.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventDtoMapper {
    public EventDto toEventDto(Event event){
        return new EventDto(
                event.id(),
                event.name(),
                event.description(),
                event.identifier(),
                event.dateStart(),
                event.dateEnd(),
                event.location(),
                event.capacity(),
                event.organizer(),
                event.type()
        );
    }

    public Event toEventEntity(EventDto eventDto){
        return new Event(
                eventDto.id(),
                eventDto.name(),
                eventDto.description(),
                eventDto.identifier(),
                eventDto.dateStart(),
                eventDto.dateEnd(),
                eventDto.location(),
                eventDto.capacity(),
                eventDto.organizer(),
                eventDto.type()
        );
    }
}
