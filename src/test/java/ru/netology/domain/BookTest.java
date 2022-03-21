package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Book book = new Book(3, "Book", 10, "Ivanov");

    @Test
    void matchesBookTrue() {
        Book book = new Book(3, "Book", 10, "Ivanov");
        manager.addProduct(book);
        boolean expected = book.matches("Ivanov");
        assertTrue(expected);
    }

    @Test
    void matchesBookFalse() {
        manager.addProduct(book);
        boolean expected = book.matches("Petrov");
        assertFalse(expected);
    }
}