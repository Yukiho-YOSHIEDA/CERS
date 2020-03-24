package dev.yukiho.cers.exception.handler;

import dev.yukiho.cers.exception.BadRequestException;
import dev.yukiho.cers.exception.ConflictException;
import dev.yukiho.cers.exception.UnexpectedException;
import dev.yukiho.cers.model.output.ErrorOutputModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    // 400
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorOutputModel handleBadRequestException(BadRequestException e) {
        return new ErrorOutputModel(e.getMessage());
    }

    // 409
    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorOutputModel handleConflictException(ConflictException e) {
        return new ErrorOutputModel(e.getMessage());
    }

    // 500
    @ExceptionHandler(UnexpectedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorOutputModel handleUnexpectedException(UnexpectedException e) {
        return new ErrorOutputModel(e.getMessage());
    }

    // 500
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorOutputModel handleException(Exception e) {
        return new ErrorOutputModel(e.getMessage());
    }
}
