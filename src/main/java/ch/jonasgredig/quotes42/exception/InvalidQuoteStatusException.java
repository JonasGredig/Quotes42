package ch.jonasgredig.quotes42.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Status is not valid")
public class InvalidQuoteStatusException extends RuntimeException {
}
