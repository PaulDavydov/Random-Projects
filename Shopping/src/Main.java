public class Main {

    public static void main(String[] args) {
	// write your code here

        ShoppingCart cart = new ShoppingCart();
//        Product toothbrush = new Product("Electric toothbrush", 3440);
//        Product babyalarm = new Product("Baby Alarm", 4000);

        Product toothbrush = Catalogue.getProduct("Electric Toothbrush");
        cart.addProduct(toothbrush);
        System.out.println(cart);
        System.out.println(cart.getTotalCost());
    }
}
