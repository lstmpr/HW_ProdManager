package ru.domain.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductManager manager = new ProductManager(new ProductRepository());

    Product first = new Book(1, "The green miles", 560, "King");
    Product second = new Book(2, "Harry Potter and the Camber of Secrets", 1500, "Rowling");
    Product third = new Book(3, "Dunno on the Moon", 1000, "Nosov");
    Product fourth = new Book(4, "Harry Potter and the Philosopher's Stone", 930, "Rowling");
    Product fifth = new Smartphone(5, "iPhone 6", 400, "Apple");
    Product sixth = new Smartphone(6, "Samsung 9", 1000, "Samsung");
    Product seventh = new Smartphone(7, "iPhone 13", 1100, "Apple");
    Product eighth = new Smartphone(8, "Samsung 7", 1100, "Samsung");

    @Test
    void shouldSetNameOfProduct() {
        Product item = new Product();
        item.setName("Book");
        String actual = item.getName();
        String expected = "Book";

        assertEquals(actual,expected);
    }


    @Test
    void shouldSaveBookAndFilm() {
        manager.save(first);
        manager.save(second);
        manager.save(sixth);
        manager.save(eighth);

        manager.getAll();
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{first, second, sixth, eighth};
        assertArrayEquals(actual, expected);


    }

    @Test
    void shouldSaveOneBookOrFilm() {
        manager.save(fifth);

        manager.getAll();
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{fifth};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSaveEightBookOrFilm() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);


        manager.getAll();
        Product[] actual = manager.getAll();
//        Product[] expected = new Product[]{eighth, seventh, sixth, fifth, fourth, third};
        Product[] expected = new Product[]{first, second, third, fourth, fifth, sixth, seventh, eighth};
        assertArrayEquals(actual, expected);
    }


    @Test
    void removeById() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);
        manager.save(fifth);
        manager.save(sixth);
        manager.save(seventh);
        manager.save(eighth);

        manager.removeById(4);

        manager.getAll();

        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{first, second, third, fifth, sixth, seventh, eighth};
        assertArrayEquals(actual, expected);



    }

    @Test
    void searchBy() {
        manager.save(first);
        manager.save(second);
        manager.save(third);
        manager.save(fourth);


        Product[] actual = manager.searchBy("Harry");
        Product[] expected = new Product[]{second, fourth};
        assertArrayEquals(actual, expected);


    }
    
}