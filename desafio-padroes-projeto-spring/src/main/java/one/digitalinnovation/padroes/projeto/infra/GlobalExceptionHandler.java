package one.digitalinnovation.padroes.projeto.infra;
import one.digitalinnovation.padroes.projeto.exceptions.CustomerAlreadyExistsException;
import one.digitalinnovation.padroes.projeto.exceptions.ResourceNotFoundException;
import one.digitalinnovation.padroes.projeto.utils.ApiGlobalResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    private ResponseEntity<ApiGlobalResponseDto> handlerArgumenteNotValid(MethodArgumentNotValidException e){
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiGlobalResponseDto(errors));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<ApiGlobalResponseDto> ResourceNotFoundHandler(ResourceNotFoundException e){
        Map<String, String> error = Map.of("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiGlobalResponseDto(error));
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    private ResponseEntity<ApiGlobalResponseDto> userAlreadyExistsHandler(CustomerAlreadyExistsException e){
        Map<String, String> error = Map.of("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiGlobalResponseDto(error));

    }

}
