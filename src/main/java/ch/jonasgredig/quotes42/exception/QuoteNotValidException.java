package ch.jonasgredig.quotes42.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Quote not valid. Author, text and/or date missing.")
public class QuoteNotValidException extends RuntimeException {
}
