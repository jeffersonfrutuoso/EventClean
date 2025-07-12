package frutuoso.java10x.EventClean.infra.controller;
import frutuoso.java10x.EventClean.core.entities.Event;
import frutuoso.java10x.EventClean.core.useCases.CreateEventCase;
import frutuoso.java10x.EventClean.infra.dtos.EventDto;
import frutuoso.java10x.EventClean.infra.mapper.EventDtoMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("event/")
public class EventController {
    private final CreateEventCase createEventCase;
    private final EventDtoMapper eventDtoMapper;

    public EventController(CreateEventCase createEventCase, EventDtoMapper eventDtoMapper) {
        this.createEventCase = createEventCase;
        this.eventDtoMapper = eventDtoMapper;
    }

    @PostMapping("/create")
   public EventDto create (@RequestBody EventDto eventDto){
        Event newEvent = createEventCase.execute(eventDtoMapper.toEventEntity(eventDto));
        return eventDtoMapper.toEventDto(newEvent);
    }

    @GetMapping
    public String showEvents() {
        return "eventos";
    }
}
