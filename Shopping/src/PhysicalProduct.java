public class PhysicalProduct extends Product implements Replaceable{
    private int weight;

    public PhysicalProduct(String name, int price,int weight) {
        super(name, price);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int calculateShippingCost() {
        return weight * Catalogue.SHIPPING_RATE;
    }

    @Override
    public void ship() {
        switch(shippingCategory) {
            case STANDARD;
            case BULKY;
            case PREMIUM;
        }
    }

    public void replace() {
        ship();
    }
}
