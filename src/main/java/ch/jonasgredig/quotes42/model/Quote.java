package ch.jonasgredig.quotes42.model;

import ch.jonasgredig.quotes42.quoteenum.QuoteStatus;

public class Quote {

    private int id;
    private String text;
    private String author;
    private String date;
    private QuoteStatus status;

    public Quote(int id, String text, String author, String date, QuoteStatus status) {
        this.status = status;
        this.id = id;
        this.text = text;
        this.author = author;
        this.date = date;
    }

    public QuoteStatus getStatus() {
        return status;
    }

    public void setStatus(QuoteStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
