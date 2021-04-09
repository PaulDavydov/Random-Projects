public class Product {
    private ProductType type;
    private String productName;
    private int price;
    private int discount;
    private int weight;

    public Product(String name, int price, ProductType type, int weight) {
        this.productName = name;
        this.price=price;
        this.type = type;
        this.weight = weight;
    }

    public int getPrice() {
        int shippingCost = type.getShippingCost(weight);
        return (int)(price * (100 - discount)/100.0) + shippingCost;

    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", weight=" + weight +
                '}';
    }
}
