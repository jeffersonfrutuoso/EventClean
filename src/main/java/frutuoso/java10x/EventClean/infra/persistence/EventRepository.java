package frutuoso.java10x.EventClean.infra.persistence;

import frutuoso.java10x.EventClean.core.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    Optional<Event> findByIdentifier(String identifier);
    Optional<Event> findByName(String name);
}
