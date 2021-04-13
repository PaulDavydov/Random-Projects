public class NonprofitCustomer extends Person{

    public NonprofitCustomer(String name) {
        super(name);
    }

    @Override
    public int calculateDiscount() {
        return 15;
    }
}
