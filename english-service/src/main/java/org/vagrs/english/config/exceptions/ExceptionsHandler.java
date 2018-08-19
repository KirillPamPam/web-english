package org.vagrs.english.config.exceptions;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by Kirill Zhitelev on 16.05.2018.
 */
@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ExpiredJwtException.class})
    protected ResponseEntity<Object> handleBadCredException(RuntimeException e, WebRequest request) {
        return null;
    }

}
