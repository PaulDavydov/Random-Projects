import java.util.Optional;
import java.util.UUID;

public class EFTAccount implements PaymentMethod {

    private final String emailAddress;

    public EFTAccount(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public Optional<Payment> mkPayment(int amount) {
        return Optional.of(new Payment(this,amount, UUID.randomUUID()));
    }

    @Override
    public String toString() {
        return "EFTAccount{" +
                "emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
