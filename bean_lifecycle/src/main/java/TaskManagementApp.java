import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TaskManagementApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TaskManagementApp.class, args);
        context.close();
    }
}
