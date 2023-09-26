package dependency.runtime_change;

import dependency.runtime_change.domian.Order;
import dependency.runtime_change.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentApplication implements CommandLineRunner {
    @Autowired
    private PaymentService paymentService;

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // create an order
        Order order = new Order(12L);
        paymentService.processPayment(order);

    }
}
