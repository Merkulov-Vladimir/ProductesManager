package ru.netology.domain;

public class Book extends Product {
    private String author;

    public Book() {

        super();
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        author = author;
    }
}

