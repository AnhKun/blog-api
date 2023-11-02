package com.springboot.blog.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class BlogAPIException extends RuntimeException {
    private HttpStatus httpStatus;
    private String message;

    public BlogAPIException(String message, HttpStatus httpStatus, String message1){
        super(message);
        this.httpStatus = httpStatus;
        this.message = message1;
    }
}
