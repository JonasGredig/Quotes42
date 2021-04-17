package ch.jonasgredig.quotes42.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.I_AM_A_TEAPOT, reason = "No Quotes to get!")
public class NoQuotesException extends RuntimeException {
}
