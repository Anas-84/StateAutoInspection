package ru.yakup.carnumber.controller.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.yakup.carnumber.exception.CarNumbersAreOverException;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class CarNumberControllerAdvice {

    @ExceptionHandler({CarNumbersAreOverException.class})
    public ResponseEntity<String> handleCarNumberAreOver(HttpServletRequest request, CarNumbersAreOverException ex) {
        log.error("For {} car number are over", request.getQueryString(), ex);
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .body(ex.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleIntervalServerError(HttpServletRequest request, Exception ex) {
        log.error("For {} interval server error", request.getQueryString(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }
}