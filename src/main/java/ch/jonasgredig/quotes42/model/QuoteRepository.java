package ch.jonasgredig.quotes42.model;

import ch.jonasgredig.quotes42.model.Quote;

import java.util.ArrayList;
import java.util.List;

public class QuoteRepository {

    private List<Quote> quotes = new ArrayList<>();

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void add(Quote quote) {
        quotes.add(quote);
    }

    public Quote get(int index) {
        return quotes.get(index);
    }

    public void set(int index, Quote quote) {
        quotes.set(index, quote);
    }
}
