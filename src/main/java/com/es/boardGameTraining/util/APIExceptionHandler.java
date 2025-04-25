package com.es.boardGameTraining.util;

import com.es.boardGameTraining.util.exception.BadRequestException;
import com.es.boardGameTraining.util.exception.ClientMessageError;
import com.es.boardGameTraining.util.exception.DataBaseException;
import com.es.boardGameTraining.util.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class APIExceptionHandler {
    @ExceptionHandler({BadRequestException.class, IllegalArgumentException.class, NumberFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ClientMessageError handleBadRequest(HttpServletRequest request, Exception exception) {
        return new ClientMessageError(exception.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ClientMessageError handleNotFound(HttpServletRequest request, Exception exception) {
        return new ClientMessageError(exception.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler({DataBaseException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ClientMessageError handleInternalServerError(HttpServletRequest request, Exception exception) {
        return new ClientMessageError(exception.getMessage(), request.getRequestURI());
    }
}
