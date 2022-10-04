package com.example.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice //có tác dụng xen vào quá trình xử lý của các ResController của toàn bộ chương trình
public class APIExeptionHadler {
    /**
     * Tất cả các Exception không được khai báo sẽ được xử lý tại đây
     */
    @ExceptionHandler(Exception.class)//this is place to handler all Exception in program
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)//error 500: server có bug và không làm
    public ResponseEntity<ErrorMessage> handleAllException1(Exception ex, WebRequest request) {
        // quá trình kiểm soat lỗi diễn ra ở đây
        HttpHeaders headers = new HttpHeaders();
        headers.set("log-detail-trace", ex.getLocalizedMessage());
        return ResponseEntity.status(500).headers(headers).body(new ErrorMessage(500, ex.getLocalizedMessage()));
    }


    @ExceptionHandler(IllegalStateException.class)//this is place to handler all IllegalStateException in program
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<NotFoundException> TodoException(IllegalStateException ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("log-detail-trace", ex.getMessage());
//        headers.set("log-detail-trace", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(new NotFoundException(404,"NOT_FOUND DATA",ex.getMessage()));
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler()
    //ResponseEntity<Map<String, String>>
    public ResponseEntity<BadRequestException> handleValidationExceptions (MethodArgumentNotValidException ex) {
        HttpHeaders headers = new HttpHeaders();

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(
                (error) -> {
                    String fieldName = ((FieldError)error).getField();
                    String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                    headers.add("log-detail-trace",errorMessage);
                }
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(new BadRequestException(400,"Bad Request",errors));
    }

}
