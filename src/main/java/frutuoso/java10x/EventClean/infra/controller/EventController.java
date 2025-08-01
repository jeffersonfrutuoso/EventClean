package frutuoso.java10x.EventClean.infra.controller;
import frutuoso.java10x.EventClean.core.entities.Event;
import frutuoso.java10x.EventClean.core.useCases.*;
import frutuoso.java10x.EventClean.infra.dtos.EventDto;
import frutuoso.java10x.EventClean.infra.exceptions.NotFoundIdException;
import frutuoso.java10x.EventClean.infra.mapper.EventDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("event/")
public class EventController {
    private final CreateEventCase createEventCase;
    private final EventDtoMapper eventDtoMapper;
    private final SearchEventCase searchEventCase;
    private final FilterNameCase filterNameCase;
    private final FilterIdentifierCase filterIdentifierCase;
    private final FilterByIdEventCase filterByIdEventCase;
    private final DeleteByIdEventCase deleteByIdEventCase;
    private final UpdateEventCase updateEventCase;

    public EventController(CreateEventCase createEventCase, EventDtoMapper eventDtoMapper, SearchEventCase searchEventCase, FilterNameCase filterNameCase, FilterIdentifierCase filterIdentifierCase, FilterByIdEventCase filterByIdEventCase, DeleteByIdEventCase deleteByIdEventCase, UpdateEventCase updateEventCase) {
        this.createEventCase = createEventCase;
        this.eventDtoMapper = eventDtoMapper;
        this.searchEventCase = searchEventCase;
        this.filterNameCase = filterNameCase;
        this.filterIdentifierCase = filterIdentifierCase;
        this.filterByIdEventCase = filterByIdEventCase;
        this.deleteByIdEventCase = deleteByIdEventCase;
        this.updateEventCase = updateEventCase;
    }

    @PostMapping("/create")
   public ResponseEntity<Map<String, Object>> create (@RequestBody EventDto eventDto){
        Event newEvent = createEventCase.execute(eventDtoMapper.toEventEntity(eventDto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message: ", "Evento cadastrado com sucesso");
        response.put("Dados: ", eventDtoMapper.toEventDto(newEvent));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Map<String, Object>> UpdateEvent(@RequestBody EventDto eventDto, @PathVariable Long id){
            Event newEvent = updateEventCase.execute(eventDtoMapper.toEventEntity(eventDto),id);
            Map<String, Object> response = new HashMap<>();
            response.put("Message: ", "Evento Atualizado com sucesso");
            response.put("Dados: ", eventDtoMapper.toEventDto(newEvent));
            if (newEvent != null){
                return ResponseEntity.ok(response);
            } else {
                return null;
            }
    }

    @GetMapping("/listar")
    public List<EventDto> execute() {
        return searchEventCase.execute()
                .stream()
                .map(eventDtoMapper::toEventDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/identifier/{identifier}")
    public ResponseEntity<Event> searchForIdentifier(@PathVariable String identifier){
        Event event = filterIdentifierCase.execute(identifier);
        return ResponseEntity.ok(event);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Event> searchForName(@PathVariable String name){
        Event event = filterNameCase.execute(name);
        return ResponseEntity.ok(event);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Event> searchForId(@PathVariable Long id){
        Event event = filterByIdEventCase.execute(id);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        if (filterByIdEventCase.execute(id) != null){
            deleteByIdEventCase.execute(id);
            return ResponseEntity.ok("O evento com id: " + id + " foi deletado com sucesso");
        }
       return null;
    }
}
