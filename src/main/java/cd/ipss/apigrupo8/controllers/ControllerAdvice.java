package cd.ipss.apigrupo8.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cd.ipss.apigrupo8.responses.VideojuegoResponse;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value=RuntimeException.class)
    public ResponseEntity<Object> RunTimeExceptionHeadler(RuntimeException ex){
    VideojuegoResponse videojuegoResponse = new VideojuegoResponse();

    videojuegoResponse.setStatus(400);
        videojuegoResponse.setMessage(ex.getMessage());

        return ResponseEntity.badRequest()
        .body(videojuegoResponse);
    }

}
