import java.util.Optional;

public class Person {
    private final String name;
    private CreditCard creditCard;

    public Person(String name, long ccNumber) {
        this.name = name;
        this.creditCard = new CreditCard(ccNumber);
    }

    public Optional<Order> checkout(ShoppingCart cart) {
        Optional<Payment> payment = creditCard.mkPayment(cart.getTotalCost());
        return payment.map(value -> new Order(this, cart, value));
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", creditCard=" + creditCard +
                '}';
    }
}
