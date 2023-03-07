public class ProductRepository {
    protected Product[] product = new Product[0];

    public void save(Product newProduct) {
        Product[] tmp = new Product[product.length + 1];
        for (int i = 0; i < product.length; i++) {
            tmp[i] = product[i];
        }
        tmp[tmp.length - 1] = newProduct;
        product = tmp;
    }

    public Product[] get() {
        return product;
    }

    public void deleteByID(int ID) {
        int copyToIndex = 0;
        Product[] tmp = new Product[product.length - 1];
        for (Product prod : product) {
            if (ID != prod.getID()) {
                tmp[copyToIndex] = prod;
                copyToIndex = copyToIndex + 1;
            }
        }
        product = tmp;
    }
}