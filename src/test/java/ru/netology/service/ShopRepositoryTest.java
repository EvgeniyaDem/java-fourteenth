package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {
    @Test
    public void ShouldRemoveWhenProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Долгая прогулка", 600);
        Product product2 = new Product(2, "Сияние", 500);
        Product product3 = new Product(3, "Зеленая миля", 650);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(3);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ShouldNotRemoveWhenProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Долгая прогулка", 600);
        Product product2 = new Product(2, "Сияние", 500);
        Product product3 = new Product(3, "Зеленая миля", 650);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        //repo.remove(4);
        //Product[] actual = repo.findAll();
        //Product[] expected = {product1, product2, product3};
        //Assertions.assertArrayEquals(expected, actual);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(4)
        );
    }
}
