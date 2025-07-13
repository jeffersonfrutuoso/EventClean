package frutuoso.java10x.EventClean.infra.persistence;

import frutuoso.java10x.EventClean.core.entities.enums.TypeEvent;
import jakarta.persistence.*;


import java.time.LocalDateTime;
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


    public EventEntity() {
    }

    public EventEntity(Long id, String name, String description, String identifier, LocalDateTime dateStart, LocalDateTime dateEnd, String location, Integer capacity, String organizer, TypeEvent type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.identifier = identifier;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.location = location;
        this.capacity = capacity;
        this.organizer = organizer;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public TypeEvent getType() {
        return type;
    }

    public void setType(TypeEvent type) {
        this.type = type;
    }
}
