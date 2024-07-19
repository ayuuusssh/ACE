package IESbank.Exception;

import IESbank.Bindings.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class APP_EXCEPTION_HANDLER extends ResponseEntityExceptionHandler {
@ExceptionHandler(CustomException.class)
    public ResponseEntity<?>ResourceNotFoundException(CustomException e , WebRequest webRequest){
    Error errorDetails=new Error(e.getMessage(),webRequest.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Error> globalExceptionHandler(Exception e, WebRequest webRequest){
    Error error = new Error(e.getMessage(),webRequest.getDescription(false));
    return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
