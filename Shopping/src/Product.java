public class Product {
    private String productName;
    private int price;

    public Product(String name, int price) {
        this.productName = name;
        this.price=price;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                '}' + "\n";
    }
}
