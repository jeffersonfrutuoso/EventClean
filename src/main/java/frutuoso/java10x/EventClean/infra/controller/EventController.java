package frutuoso.java10x.EventClean.infra.controller;
import frutuoso.java10x.EventClean.core.entities.Event;
import frutuoso.java10x.EventClean.core.useCases.CreateEventCase;
import frutuoso.java10x.EventClean.core.useCases.SearchEventCase;
import frutuoso.java10x.EventClean.infra.dtos.EventDto;
import frutuoso.java10x.EventClean.infra.mapper.EventDtoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("event/")
public class EventController {
    private final CreateEventCase createEventCase;
    private final EventDtoMapper eventDtoMapper;
    private final SearchEventCase searchEventCase;

    public EventController(CreateEventCase createEventCase, EventDtoMapper eventDtoMapper, SearchEventCase searchEventCase) {
        this.createEventCase = createEventCase;
        this.eventDtoMapper = eventDtoMapper;
        this.searchEventCase = searchEventCase;
    }

    @PostMapping("/create")
   public EventDto create (@RequestBody EventDto eventDto){
        Event newEvent = createEventCase.execute(eventDtoMapper.toEventEntity(eventDto));
        return eventDtoMapper.toEventDto(newEvent);
    }

    @GetMapping("/listar")
    public List<EventDto> execute() {
        return searchEventCase.execute()
                .stream()
                .map(eventDtoMapper::toEventDto)
                .collect(Collectors.toList());
    }
}
