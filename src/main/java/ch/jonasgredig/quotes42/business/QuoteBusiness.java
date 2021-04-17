package ch.jonasgredig.quotes42.business;

import ch.jonasgredig.quotes42.model.Quote;
import ch.jonasgredig.quotes42.quoteenum.QuoteStatus;

import java.util.List;
import java.util.stream.Collectors;

public class QuoteBusiness {
    public static List<Quote> getApprovedQuotes(List<Quote> quotes) {
        return filterQuotes(quotes, QuoteStatus.APPROVED);
    }

    public static List<Quote> getNewQuotes(List<Quote> quotes) {
        return filterQuotes(quotes, QuoteStatus.NEW);
    }

    public static List<Quote> getRejectedQuotes(List<Quote> quotes) {
        return filterQuotes(quotes, QuoteStatus.REJECTED);
    }

    private static List<Quote> filterQuotes(List<Quote> quotes, QuoteStatus status) {
        return quotes.stream().filter(c -> c.getStatus().equals(status)).collect(Collectors.toList());
    }
}
