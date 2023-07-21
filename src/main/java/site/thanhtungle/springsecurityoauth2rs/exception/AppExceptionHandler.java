package site.thanhtungle.springsecurityoauth2rs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.thanhtungle.springsecurityoauth2rs.model.response.BaseResponseWithoutData;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<BaseResponseWithoutData> notFoundException(NotFoundException exc) {
        BaseResponseWithoutData error = new BaseResponseWithoutData();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<BaseResponseWithoutData> handleException(Exception exc) {
        BaseResponseWithoutData error = new BaseResponseWithoutData();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
