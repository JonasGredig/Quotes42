package ch.jonasgredig.quotes42.controller;

import ch.jonasgredig.quotes42.model.QuoteRepository;
import ch.jonasgredig.quotes42.business.QuoteBusiness;
import ch.jonasgredig.quotes42.exception.InvalidQuoteStatusException;
import ch.jonasgredig.quotes42.exception.NoQuotesException;
import ch.jonasgredig.quotes42.exception.QuoteNotFoundException;
import ch.jonasgredig.quotes42.exception.QuoteNotValidException;
import ch.jonasgredig.quotes42.model.Quote;
import ch.jonasgredig.quotes42.quoteenum.QuoteStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController()
public class QuoteController {

    private final AtomicLong counter = new AtomicLong();
    private QuoteRepository quoteRepository = new QuoteRepository();

    @GetMapping("/api")
    public Quote quote(@RequestParam(value = "index") int index) {
        try {
            return QuoteBusiness.getApprovedQuotes(quoteRepository.getQuotes()).get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new QuoteNotFoundException();
        } catch (IllegalArgumentException e) {
            throw new NoQuotesException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/api/newQuote")
    public Quote newQuote(@RequestParam(value = "author") String author, @RequestParam(value = "text") String text, @RequestParam(value = "date") String date) {
        try {
            if (author.isEmpty() || text.isEmpty() || date.isEmpty()) {
                throw new QuoteNotValidException();
            } else {
                Quote quote = new Quote((int) counter.getAndIncrement(), text, author, date, QuoteStatus.NEW);
                quoteRepository.add(quote);
                return quote;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/api/getApproved")
    public List<Quote> getApproved() {
        try {
            return QuoteBusiness.getApprovedQuotes(quoteRepository.getQuotes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/api/getRejected")
    public List<Quote> getRejected() {
        try {
            return QuoteBusiness.getRejectedQuotes(quoteRepository.getQuotes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/api/getNew")
    public List<Quote> getNew() {
        try {
            return QuoteBusiness.getNewQuotes(quoteRepository.getQuotes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/api/setStatus")
    public Quote setStatus(@RequestParam(value = "index") int index, @RequestParam(value = "status", defaultValue = "REJECTED") String status) {
        try {
            Quote quote = quoteRepository.get(index);
            if (status.equals(QuoteStatus.APPROVED.toString())) {
                quote.setStatus(QuoteStatus.APPROVED);
            } else if (status.equals(QuoteStatus.REJECTED.toString())) {
                quote.setStatus(QuoteStatus.REJECTED);
            } else {
                throw new InvalidQuoteStatusException();
            }
            quoteRepository.set(index, quote);
            return quote;
        } catch (IndexOutOfBoundsException e) {
            throw new QuoteNotFoundException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
