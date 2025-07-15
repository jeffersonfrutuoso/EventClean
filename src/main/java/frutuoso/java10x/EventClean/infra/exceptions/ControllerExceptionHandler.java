package frutuoso.java10x.EventClean.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler{

    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String, String>> handlerDuplicateException (DuplicateEventException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("error", exception.getMessage());
        response.put("mensagem", "o identificador ja existe");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, String>> handlerNotFoundException (NotFoundException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("error", exception.getMessage());
        response.put("mensagem", "o identificador não foi encontrado, tente novamente");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundIdException.class)
    public ResponseEntity<Map<String, String>> handlerNotFoundIdException (NotFoundIdException exception) {
        Map<String, String> response = new HashMap<>();
        response.put("error", exception.getMessage());
        response.put("mensagem", "o id não foi encontrado, tente novamente");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }
}
