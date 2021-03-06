package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0]; // массив жлементов типа Product

    public void save(Product product) {
        int length = products.length + 1; // длина нового массива
        Product[] tmp = new Product[length];     // создание нового массива типа Product с нужной длиной
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }

        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }

        }
        products = tmp;
    }

    public Product findById(int id) {
        for (Product product : products) {   // пройдем по всему циклу
            if (product.getId() == id) {
                return product;             // если такой айди есть, то возвращаем продукт
            }
        }
        return null;
    }
}
