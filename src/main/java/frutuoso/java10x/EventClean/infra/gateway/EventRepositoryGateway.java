package frutuoso.java10x.EventClean.infra.gateway;
import frutuoso.java10x.EventClean.core.entities.Event;
import frutuoso.java10x.EventClean.core.gateway.EventGateway;
import frutuoso.java10x.EventClean.infra.mapper.EventEntityMapper;
import frutuoso.java10x.EventClean.infra.persistence.EventEntity;
import frutuoso.java10x.EventClean.infra.persistence.EventRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


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

    @Override
    public boolean indentifierExists(String identifier) {
        return eventRepository.findAll().stream()
                .anyMatch(event -> event.getIdentifier().equalsIgnoreCase(identifier));
    }

    @Override
    public Optional<Event> filterForIdentifier(String identifier) {
        return eventRepository.findByIdentifier(identifier);
    }

    @Override
    public Optional<Event> filterForName(String name) {
        return eventRepository.findByName(name);
    }



    @Override
    public Optional<Event> filterById(Long id) {
        Optional<EventEntity> eventForId =  eventRepository.findById(id);
        return eventForId.map(eventEntityMapper::toEventCore);
    }

    @Override
    public void deleteById(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public Event updatedEvent(Event event, Long id) {
        Optional<EventEntity> eventExist = eventRepository.findById(id);
        if (eventExist.isPresent()){
            EventEntity eventUpdated = eventEntityMapper.toEntityInfra(event);
            eventUpdated.setId(id);
            EventEntity newEvent = eventRepository.save(eventUpdated);
            return eventEntityMapper.toEventCore(newEvent);
        }
        return null;
    }
}
