package dev.yukiho.cers.exception.handler;

import dev.yukiho.cers.exception.BadRequestException;
import dev.yukiho.cers.model.output.ErrorOutputModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorOutputModel handleBadRequestException(BadRequestException e) {
        return new ErrorOutputModel(e.getMessage());
    }
}
