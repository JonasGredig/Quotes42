package ch.jonasgredig.quotes42.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Quote ID not found, 404")
public class QuoteNotFoundException extends RuntimeException {
}
