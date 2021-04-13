public abstract class Product implements Shippable,Comparable<Product>{
    private String productName;
    private int price;
    private int discount;


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

    public int compareTo(Product otherProduct) {
        return productName.compareTo(otherProduct.productName);
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public abstract PriceCalculator createPriceCalculator();

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", discount=" + discount + '}';
    }

    public abstract int calculateShippingCost();
}
