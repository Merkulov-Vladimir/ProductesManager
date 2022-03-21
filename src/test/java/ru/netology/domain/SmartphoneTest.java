package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Smartphone smartphone = new Smartphone(4, "Samsung Galaxy", 10000, "Samsung");

    @Test
    void matchesSmartTrue() {
        manager.addProduct(smartphone);
        boolean expected = smartphone.matches("Samsung");
        assertTrue(expected);
    }

    @Test
    void matchesSmartFalse() {
        manager.addProduct(smartphone);
        boolean expected = smartphone.matches("Nokia");
        assertFalse(expected);
    }
}