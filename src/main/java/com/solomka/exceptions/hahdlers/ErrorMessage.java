package com.solomka.exceptions.hahdlers;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorMessage {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;

    private ErrorMessage() {
    }

    public static ErrorMessage createErrorMessage(Exception ex, HttpStatus status) {
        ErrorMessage error = new ErrorMessage();
        error.setTimestamp(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        error.setStatus(status);
        return error;
    }
}


