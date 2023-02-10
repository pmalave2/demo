package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "No Compatible Rack")
public class NoCompatibleRackException extends Exception {

  public NoCompatibleRackException() {}

  public NoCompatibleRackException(String errorMessage) {
    super(errorMessage);
  }
}
