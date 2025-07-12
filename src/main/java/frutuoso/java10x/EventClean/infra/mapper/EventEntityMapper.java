package frutuoso.java10x.EventClean.infra.mapper;
import frutuoso.java10x.EventClean.core.entities.Event;
import frutuoso.java10x.EventClean.infra.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventEntityMapper {

    public EventEntity toEntity (Event event) {
        return new EventEntity(
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

    public Event toEvent(EventEntity eventEntity) {
        return new Event(
                eventEntity.getId(),
                eventEntity.getName(),
                eventEntity.getDescription(),
                eventEntity.getIdentifier(),
                eventEntity.getDateStart(),
                eventEntity.getDateEnd(),
                eventEntity.getLocation(),
                eventEntity.getCapacity(),
                eventEntity.getOrganizer(),
                eventEntity.getType()
        );
    }
}
