package dependency.runtime_change.service;

import dependency.runtime_change.domian.Order;
import dependency.runtime_change.domian.PaymentGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Constructor based injection
@Service
public class PaymentService {
    private final PaymentGateway paymentGateway;

    @Autowired
    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(Order order) {
        paymentGateway.processPayment(order);
    }
}
