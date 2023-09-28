package config;
import domain.SampleResource;
import domain.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {
    @Bean(initMethod = "initialize", destroyMethod = "cleanup")
    public Task task1() {
        Task task = new Task("Task 1");
        task.setResource(new SampleResource("Resource 1"));
        return task;
    }

    @Bean(initMethod = "initialize", destroyMethod = "cleanup")
    public Task task2() {
        Task task = new Task("Task 2");
        task.setResource(new SampleResource("Resource 2"));
        return task;
    }
}
