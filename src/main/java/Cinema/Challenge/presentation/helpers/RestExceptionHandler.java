package Cinema.Challenge.presentation.helpers;

import Cinema.Challenge.presentation.Exceptions.MovieAlreadyExist;
import Cinema.Challenge.presentation.Exceptions.MovieNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler  {
    @ExceptionHandler(MovieAlreadyExist.class)
    public ResponseEntity<String> movieAlreadyExistHandler (MovieAlreadyExist ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(MovieNotFound.class)
    public ResponseEntity<String> movieNotFoundHandler (MovieNotFound ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity validationDtoHandler (MethodArgumentNotValidException ex) {
        List<String> errors = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList();
        return ResponseEntity
                .badRequest()
                .body(Map.of("error", "Validation failed", "details", errors));
    }
}
