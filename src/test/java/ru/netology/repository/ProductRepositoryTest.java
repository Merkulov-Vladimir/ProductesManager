package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    Product item1 = new Product(1, "inem 1", 10);
    Product item2 = new Product(2, "inem 2", 15);
    Book book = new Book(3, "Book", 10, "Ivanov");
    Smartphone smartphone = new Smartphone(4, "Samsung Galaxy", 10000, "Samsung");

    @Test
    void removeById() {
        repo.save(item1);
        repo.save(item2);
        repo.save(book);
        repo.save(smartphone);
        repo.removeById(2);
        Product[] expected = {item1, book, smartphone};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        repo.save(item1);
        repo.save(item2);
        Product[] expected = {item1, item2};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }
// такой же как и findAll, но пусть будет
    @Test
    void save() {
        repo.save(item1);
        repo.save(item2);
        Product[] expected = {item1, item2};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }
}