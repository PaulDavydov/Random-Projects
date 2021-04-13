public class HighValuePayment implements PaymentIntf{

    private final PaymentIntf payment;

    public HighValuePayment(PaymentIntf payment) {
        this.payment = payment;
    }

    @Override
    public void execute() {
        payment.execute();
    }

    @Override
    public void setValue(int value) {
        payment.setValue(value);
    }

    @Override
    public int getValue() {
        return payment.getValue();
    }
}
