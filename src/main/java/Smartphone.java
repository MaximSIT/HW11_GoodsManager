public class Smartphone extends Product {
    private String supplier;
    public Smartphone(int ID, String name, int price, String supplier) {
        super(ID, name, price);
        this.supplier = supplier;
    }
}