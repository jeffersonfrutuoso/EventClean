package frutuoso.java10x.EventClean.core.gateway;
import frutuoso.java10x.EventClean.core.entities.Event;
import java.util.List;
import java.util.Optional;

public interface EventGateway {
     Optional<Event> filterForIdentifier(String identifier);
     Optional<Event> filterForName(String name);
     Optional<Event> filterById(Long id);
     public Event createEvent(Event event);
     public List<Event> listEvents();
     boolean indentifierExists(String identifier);
}
