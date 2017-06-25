package up;

public class Product {

    private final String key;

    Product(String key) {
        this.key = key;
    }

    String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "Product - color: " + key;
    }
}
