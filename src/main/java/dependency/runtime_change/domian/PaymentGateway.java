package dependency.runtime_change.domian;

public interface PaymentGateway {
    void processPayment(Order order);
}
