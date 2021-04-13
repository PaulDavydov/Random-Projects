import java.util.UUID;

public class Payment {
    private final PaymentMethod paymentMethod;
    private final UUID transactionId;
    private int value;

    public Payment(PaymentMethod paymentMethod, int value, UUID transactionId) {
        this.paymentMethod = paymentMethod;
        this.value = value;
        this.transactionId = transactionId;
    }

    public void execute() {
        System.out.println("executing payement of " + value);
        if (value < 0) {
            reverse();
        }
    }

    public void reverse() {
        System.out.println("reversing payment of " + value);
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentMethod=" + paymentMethod +
                ", transactionId=" + transactionId +
                ", value=" + value +
                '}';
    }
}
