import java.beans.Customizer;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        ShoppingCart cart = new ShoppingCart();
////        Product toothbrush = new Product("Electric toothbrush", 3440);
////        Product babyalarm = new Product("Baby Alarm", 4000);
//
//        Product toothbrush = Catalogue.getProduct("Electric Toothbrush");
//        Product babyAlarm = Catalogue.getProduct("Baby Alarm");
//        Product warAndPeace = Catalogue.getProduct("War and Peace Book");
//
//        cart.addLineItem(new LineItem(babyAlarm,1));
//        cart.addLineItem(new LineItem(warAndPeace,1));
//        LineItem toothbrushes = new LineItem(toothbrush, 2);
//        cart.addLineItem(toothbrushes);
//        System.out.println(cart.getTotalCost());
//
//        Person johnDoe = new Person("John Doe", 5420793515183044L);
//        Optional<Order> order = johnDoe.checkout(cart);
//        System.out.println(order);
//
//        toothbrushes.setQuantity(999);

        Person janeDoe = new Person("Jane Ode", 5420876409877821L);
        Person acme = new BusinessCustomer("ACME Products", 1234567890123456L, BusinessCustomer.BusinessSize.LARGE);
        Person globex = new BusinessCustomer("Globex Corp", 4567812345097654L, BusinessCustomer.BusinessSize.LARGE);
        Person saveTheWorld = new NonprofitCustomer("Save the World",6481298741654001L);

        List<Person> customers = List.of(janeDoe,acme,globex,saveTheWorld);

        //count how many customers are on each discount rate
        Map<Integer,Long> discountMap = customers.stream().
                collect(Collectors.groupingBy(Person::calculateDiscount,Collectors.counting()));

        System.out.println(discountMap);

        //alternative way of doing it, not stream
        discountMap = new HashMap<>();
        for (Person c : customers) {
            discountMap.merge(c.calculateDiscount(), 1l, Long::sum);
        }
        System.out.println(discountMap);

        System.out.println(acme);
    }

//    public static void fulfillOrder(Order o) {
//        ShoppingCart cart = o.getCart();
//        boolean shippingUnfinished;
//        do {
//            shippingUnfinished = false;
//            for(LineItem li : cart.getLineItems()) {
//                boolean fulfilHalf = Math.random() > 0.7;
//                if (fulfilHalf) {
//                    li.setQuantity(li.getPrice()/2);
//                    shippingUnfinished = true;
//                } else {
//                    li.setQuantity(0);
//                }
//                System.out.println(fulfilHalf);
//            }
//        }while(shippingUnfinished);
//    }
}
