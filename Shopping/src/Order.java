
public class Order {
    private Person person;
    private ShoppingCart cart;
    private Payment payment;

    public Order(Person customer, ShoppingCart cart, Payment payment) {
        this.person = customer;
        this.cart = cart;
        this.payment = payment;
    }

    public ShoppingCart getCart() {
        return this.cart;
    }

    @Override
    public String toString() {
        return "Order{" +
                "\n person=" + person +
                ",\n cart=" + cart +
                ",\n payment=" + payment +
                "\n}";
    }
}
