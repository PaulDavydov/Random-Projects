import java.beans.Customizer;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Product toothbrush = Catalogue.getProduct("Electric Toothbrush");
        Product babyAlarm = Catalogue.getProduct("Baby Alarm");
        Product warAndPeace = Catalogue.getProduct("War and Peace Book");

        ShoppingCart cart = new ShoppingCart();
        LineItem toothbrushes = new LineItem(toothbrush,2);
        cart.addLineItem(toothbrushes);
        cart.addLineItem(new LineItem(babyAlarm,2));
        cart.addLineItem(new LineItem(warAndPeace,20));

        Person janeDoe = new Person("Jane Ode");
        janeDoe.addPaymentMethod("Jane's Credit Card", new CreditCard(1234567890123456L));
        janeDoe.addPaymentMethod("Jane's Bank Account", new BankAccount(90_90_90,9012345678901234L));

        Optional<Order> order= janeDoe.checkout(cart, "Jane's Bank Account");
        System.out.println(order);
    }


}
