package dependency.runtime_change.config;

import dependency.runtime_change.domian.PaymentGateway;
import dependency.runtime_change.service.CreditCardGateway;
import dependency.runtime_change.service.PayPalGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    @Bean
    public PaymentGateway paymentGateway() {
        return new CreditCardGateway(); // change this to PayPalGateway to switch implementations.
    }
}
