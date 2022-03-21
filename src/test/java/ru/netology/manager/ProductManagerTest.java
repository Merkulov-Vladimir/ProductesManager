package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product item1 = new Product(1, "item 1", 10);
    Product item2 = new Product(2, "item 1", 15);
    Book book = new Book(3, "Book", 10, "Ivanov");
    Smartphone smartphone = new Smartphone(4, "Samsung Galaxy", 10000, "Samsung");
    Product item3 = new Product(5, "Book", 10);
    Book book2 = new Book(6, "Book", 10, "Kozlov");
    Book book3 = new Book(7, "Book3", 10, "Ivanov");
    Smartphone smartphone2 = new Smartphone(4, "Xiaomi Mi 10", 10000, "Xiaomi");
    Smartphone smartphone3 = new Smartphone(4, "Xiaomi Mi 11", 10000, "Xiaomi");


    @Test
    void addProduct() {
        manager.addProduct(item1);
        manager.addProduct(item2);
        manager.addProduct(book);
        manager.addProduct(smartphone);
        Product[] expected = {item1, item2, book, smartphone};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy() {
        manager.addProduct(item1);
        manager.addProduct(item2);
        manager.addProduct(book);
        manager.addProduct(smartphone);
        manager.addProduct(item3);
        manager.addProduct(book2);
        Product[] expected = {book, item3, book2};
        Product[] actual = manager.searchBy("Book");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAuthor() {
        manager.addProduct(item1);
        manager.addProduct(item2);
        manager.addProduct(book);
        manager.addProduct(smartphone);
        manager.addProduct(item3);
        manager.addProduct(book2);
        manager.addProduct(book3);
        Product[] expected = {book, book3};
        Product[] actual = manager.searchBy("Ivanov");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByManufacturer() {
        manager.addProduct(item1);
        manager.addProduct(item2);
        manager.addProduct(book);
        manager.addProduct(smartphone);
        manager.addProduct(item3);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);
        Product[] expected = {smartphone2, smartphone3};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByWhenThereNoMatches() {
        manager.addProduct(item1);
        manager.addProduct(item2);
        manager.addProduct(book);
        manager.addProduct(smartphone);
        manager.addProduct(item3);
        manager.addProduct(book2);
        Product[] expected = {};
        Product[] actual = manager.searchBy("King");
        assertArrayEquals(expected, actual);
    }

}