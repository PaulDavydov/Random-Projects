import java.util.UUID;

public class ReversiblePayment implements PaymentIntf{

    private final Payment payment;

    public ReversiblePayment(Payment payment) {
        this.payment = payment;
    }

    public void execute() {
        payment.execute();
    }

    @Override
    public void setValue(int v) {
        payment.setValue(v);
    }

    public int getValue() {
        return payment.getValue();
    }

    public void reverse() {
        setValue(-getValue());
        execute();
    }
}
