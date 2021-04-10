public abstract class Product {
    private String productName;
    private int price;
    private float discount;


    public Product(String name, int price) {
        this.productName = name;
        this.price=price;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getPrice() {
        int shippingCost = calculateShippingCost();
        return Math.round((1-discount)*price) + shippingCost;

    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", discount=" + discount + '}';
    }

    public abstract int calculateShippingCost();
}
