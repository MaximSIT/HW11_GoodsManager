import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
//@NoArgsConstructor
public class Product {

    protected int ID;
    protected String name;
    protected int price;

    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
}