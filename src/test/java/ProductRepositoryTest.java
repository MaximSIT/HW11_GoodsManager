import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    Product product1 = new Product(1, "bag", 100);
    Product product2 = new Product(2, "phone", 200);
    Product product3 = new Product(3, "Tv", 300);

    @Test
    public void shouldAddProduct() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        Product[] expected = {product1};
        Product[] actual = repo.get();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteByID() {
        ProductRepository repo = new ProductRepository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.deleteByID(1);

        Product[] expected = {product2, product3};
        Product[] actual = repo.get();

        Assertions.assertArrayEquals(expected, actual);
    }
}