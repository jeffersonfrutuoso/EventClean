package frutuoso.java10x.EventClean.core.gateway;
import frutuoso.java10x.EventClean.core.entities.Event;
import java.util.List;
import java.util.Optional;

public interface EventGateway {
     public Event createEvent(Event event);

     public List<Event> listEvents();
}
