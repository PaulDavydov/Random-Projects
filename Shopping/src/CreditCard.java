import java.util.Optional;
import java.util.UUID;

public class CreditCard {
    private long ccNumber;

    public CreditCard (long ccNumber) {
        this.ccNumber = ccNumber;
    }

    public Optional<Payment> mkPayment(int value) {
        if (Math.random() > 0.3) {
            return Optional.of(new Payment(this,value, UUID.randomUUID()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "ccNumber=" + ccNumber +
                '}';
    }
}
