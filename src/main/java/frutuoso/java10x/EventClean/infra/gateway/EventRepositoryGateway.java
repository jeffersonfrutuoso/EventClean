package frutuoso.java10x.EventClean.infra.gateway;
import frutuoso.java10x.EventClean.core.entities.Event;
import frutuoso.java10x.EventClean.core.gateway.EventGateway;
import frutuoso.java10x.EventClean.infra.mapper.EventEntityMapper;
import frutuoso.java10x.EventClean.infra.persistence.EventEntity;
import frutuoso.java10x.EventClean.infra.persistence.EventRepository;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class EventRepositoryGateway implements EventGateway {

    private final EventRepository eventRepository;
    private final EventEntityMapper eventEntityMapper;


    public EventRepositoryGateway(EventRepository eventRepository, EventEntityMapper eventEntityMapper) {
        this.eventRepository = eventRepository;
        this.eventEntityMapper = eventEntityMapper;
    }

    @Override
    public List<Event> listEvents() {
        return eventRepository.findAll().stream().map(eventEntityMapper::toEventCore).toList();
    }

    @Override
    public Event createEvent(Event event) {
        EventEntity eventEntity = eventEntityMapper.toEntityInfra(event);
        EventEntity newEvent = eventRepository.save(eventEntity);
        return eventEntityMapper.toEventCore(newEvent);
    }
}
