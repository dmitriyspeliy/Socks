package ru.skypro.automationSocks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IFElementExist extends RuntimeException {
    public IFElementExist(String message) {
        super(message);
    }
}
