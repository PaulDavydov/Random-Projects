import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    public List<LineItem> lineItemList = new ArrayList<>();

    public void addLineItem (LineItem lineItem) {
        lineItemList.add(lineItem);
    }

    public void addLineItem(Product prod, int quantity) {
        this.addLineItem(new LineItem(prod,quantity));
    }
    public List<LineItem> getLineItems() {
        return lineItemList.stream().map(LineItem::new).collect(Collectors.toList());
    }

    public int getTotalCost() {
        return lineItemList.stream()
                .mapToInt(LineItem::getPrice)
                .sum();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "products=\n" + lineItemList +
                '}';
    }
}
