import java.util.ArrayList;

public class ShoppingCart {
    public ArrayList<Product> products = new ArrayList<>();

    public void addProduct (Product product) {
        this.products.add(product);
    }

    public int getTotalCost() {
        return products.stream()
                .mapToInt(Product::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "products=\n" + products +
                '}';
    }
}
