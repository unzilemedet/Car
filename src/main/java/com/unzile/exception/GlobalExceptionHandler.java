package com.unzile.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;


/*
* Bu sınıf uygulama içinde oluşacak tüm istisnaların yakalanması için kullanılacaktır.
* Burada bu sınıfın bizim belirlediğimiz özelleştirilmiş istisnaları yakalayacağız.
* Bunun dışında ek kullandığımız kütüphanelerin istisnalarınıda ayrıca belirleyip yakalayacağız.
*
* */
@ControllerAdvice
public class GlobalExceptionHandler {

    private ErrorMessage createErrorMessage(ErrorType errorType, Exception exception){
        System.out.println("Bu kısımda hata mesajlarının loglama işlemlerini yapmalıyız.");
        return  ErrorMessage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();
    }

    @ExceptionHandler(CarException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handlerJava7MonoException(CarException exception){
        System.out.println("Java7MonoException hatası ...:"+ exception.toString());
        return  new ResponseEntity(createErrorMessage(exception.getErrorType(),exception), exception.getErrorType().getHttpStatus());
    }
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public ResponseEntity<String> handleAritmeticException(ArithmeticException exception) {
        /*Burada oluşan istisna ile ilgili eğer log tutulacak ise bu işlemler yapılır*/
        System.out.println("Aritmetik Hatası...: " + exception.toString());
        return ResponseEntity.ok("Sıfıra bölme işlem hatası");
    }

    //KULLANICIDAN GELEN DATALAR OKUNULMAMASI DURUMU
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handle(HttpMessageNotReadableException exception) {
        ErrorType errorType = ErrorType.BAD_REQUEST;
        return  new ResponseEntity<>(createErrorMessage(errorType,exception),errorType.getHttpStatus());
    }
    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleMissingPathVariableException(MissingPathVariableException exception) {
        ErrorType errorType = ErrorType.BAD_REQUEST;
        return  new ResponseEntity<>(createErrorMessage(errorType,exception),errorType.getHttpStatus());
    }
 /*   @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> handleException(Exception exception){
        return ResponseEntity.badRequest().body("Beklenmeyen bir hata oluştu.Lütfen daha sonra tekrar deneyiniz.");
    }  */

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleException(Exception exception){
        ErrorType errorType = ErrorType.ERROR;
        return  new ResponseEntity<>(createErrorMessage(errorType,exception),errorType.getHttpStatus());
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<ErrorMessage> handleInvalidFormatException(
            InvalidFormatException exception) {
        ErrorType errorType = ErrorType.BAD_REQUEST;
        return new ResponseEntity<>(createErrorMessage(errorType, exception), errorType.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentMisMatchException(
            MethodArgumentTypeMismatchException exception) {

        ErrorType errorType = ErrorType.BAD_REQUEST;
        return new ResponseEntity<>(createErrorMessage(errorType, exception), errorType.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        ErrorType errorType = ErrorType.BAD_REQUEST;
        List<String> fields = new ArrayList<>();
        exception
                .getBindingResult()
                .getFieldErrors()
                .forEach(e -> fields.add(e.getField() + ": " + e.getDefaultMessage()));
        ErrorMessage errorMessage = createErrorMessage(errorType, exception);
        errorMessage.setFields(fields);
        return new ResponseEntity<>(errorMessage, errorType.getHttpStatus());
    }


}












