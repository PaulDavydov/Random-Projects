import java.util.Map;

public class Catalogue {
    private static Map<String,Product> productMap = Map.of(
            "Electric Toothbrush",new Product("Electric Toothbrush", 4000),
            "Baby Alarm", new Product("Baby Alarm",4500)
    );

    public static Product getProduct(String productName) {
        return productMap.get(productName);
    }
}
