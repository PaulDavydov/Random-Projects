import java.util.Map;

public class Catalogue {

    public final static int SHIPPING_RATE = 5;
    private static Map<String,Product> productMap = Map.of(
            "Electric Toothbrush",new Product("Electric Toothbrush", 4000, ProductType.PHYSICAL, 400),
            "Baby Alarm", new Product("Baby Alarm",4500, ProductType.PHYSICAL, 800),
            "War and Peace Book", new Product("War and Peace Book", 7000,ProductType.DIGITAL,-1)
    );

    public static Product getProduct(String productName) {
        return productMap.get(productName);
    }
}
