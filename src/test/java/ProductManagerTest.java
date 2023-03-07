import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    Product product1 = new Product(1, "bag", 100);
    Product product2 = new Product(2, "phone", 200);
    Product product3 = new Product(3, "TV", 300);
    Book book = new Book(4, "Guest", 400, "Petrov");
    Smartphone phone = new Smartphone(5, "phone", 600, "Apple");
    ProductRepository repository = new ProductRepository();

    @BeforeEach
    public void start() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
    }

    @Test
    public void shouldAddProduct() {
        ProductManager manager = new ProductManager(repository);
        manager.add(book);

        Product[] expected = {product1, product2, product3, book};
        Product[] actual = repository.get();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByProductID() {
        ProductManager manager = new ProductManager(repository);
        manager.searchBy("bag");

        Product[] expected = {product1};
        Product[] actual = manager.searchBy("bag");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByProductIDNoMatches() {
        ProductManager manager = new ProductManager(repository);
        manager.searchBy("laptop");

        Product[] expected = {};
        Product[] actual = manager.searchBy("laptop");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByProductIDWhenMoreThanOne() {
        ProductManager manager = new ProductManager(repository);
        manager.add(phone);
        manager.searchBy("phone");

        Product[] expected = {product2, phone};
        Product[] actual = manager.searchBy("phone");

        Assertions.assertArrayEquals(expected, actual);
    }
}