import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Person implements Comparable<Person>{
    private final String name;
    private Map<String, PaymentMethod> paymentMethods = new HashMap<>();

    public Person(String name) {
        this.name = name;
    }

    public void addPaymentMethod(String nickname, PaymentMethod paymentMethod) {
        paymentMethods.put(nickname,paymentMethod);
    }

    public Optional<Order> checkout(ShoppingCart cart, String paymentMethodNickname) {
        Optional<PaymentMethod> paymentMethod = Optional.ofNullable(paymentMethods.get(paymentMethodNickname));
        Optional<Payment> payment = paymentMethod.flatMap(pm -> pm.mkPayment(cart.getTotalCost()));
        return payment.map(value -> new Order(this, cart, value));
    }



    public int calculateDiscount() {
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", paymentMethods=" + paymentMethods +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}
