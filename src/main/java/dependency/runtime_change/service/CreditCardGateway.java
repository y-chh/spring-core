package dependency.runtime_change.service;

import dependency.runtime_change.domian.Order;
import dependency.runtime_change.domian.PaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class CreditCardGateway implements PaymentGateway {
    @Override
    public void processPayment(Order order) {
        System.out.println("Processing payment from CreditCardGateway for oder " + order.getId() );
    }
}
