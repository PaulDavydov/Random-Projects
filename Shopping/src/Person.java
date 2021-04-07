public class Person {
    private final String name;
    private CreditCard creditCard;

    public Person(String name, long ccNumber) {
        this.name = name;
        this.creditCard = new CreditCard(ccNumber);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", creditCard=" + creditCard +
                '}';
    }
}
