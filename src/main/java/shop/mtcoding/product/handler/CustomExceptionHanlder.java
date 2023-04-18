package shop.mtcoding.product.handler;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import shop.mtcoding.product.dto.ResponseDto;
import shop.mtcoding.product.handler.ex.CustomApiException;
import shop.mtcoding.product.handler.ex.CustomException;
import shop.mtcoding.product.util.Script;

@RestControllerAdvice
public class CustomExceptionHanlder {

    // NullPointException <- RuntimeException
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> customException(CustomException e) {
        String responseBody = Script.back(e.getMessage());
        return new ResponseEntity<>(responseBody, e.getStatus());
    }

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> customApiException(CustomApiException e) {
        return new ResponseEntity<>(new ResponseDto<>(-1, e.getMessage(), null), e.getStatus());
    }
}
