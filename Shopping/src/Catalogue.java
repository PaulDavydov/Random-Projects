import java.util.Map;

public class Catalogue {

    public final static int SHIPPING_RATE = 5;
    private static Map<String,Product> productMap = Map.of(
            "Electric Toothbrush",new PhysicalProduct("Electric Toothbrush", 4000, 400),
            "Baby Alarm", new PhysicalProduct("Baby Alarm",4500,800),
            "War and Peace Book", new DigitalProduct("War and Peace Book", 7000)
    );

    public static Product getProduct(String productName) {
        return productMap.get(productName);
    }
}
