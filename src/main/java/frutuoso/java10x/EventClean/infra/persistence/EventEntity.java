package frutuoso.java10x.EventClean.infra.persistence;

import frutuoso.java10x.EventClean.core.entities.enums.TypeEvent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "event")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String identifier;
    private LocalDateTime dateStart;
    private LocalDateTime dateEnd;
    private String location;
    private  Integer capacity;
    private String organizer;
    @Enumerated(EnumType.STRING)
    private TypeEvent type;

}
