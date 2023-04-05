package com.unzile.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    BOOK_NOT_FOUND(2004,"Aradığınız kitap adı bulunamadı", HttpStatus.NOT_FOUND),
    ERROR_INVALID_TOKEN(3000,"Geçersiz token bilgisi", HttpStatus.UNAUTHORIZED),
    ERROR(9000,"Beklenmeyen bir hata oluştu.Lütfen daha sonra tekrar deneyiniz.",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4000,"Geçersiz istek ya da parametre", HttpStatus.BAD_REQUEST);
    int code;
    String message;
    HttpStatus httpStatus;
}
