package qualifiers_lazy_initialization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import qualifiers_lazy_initialization.service.DataService;

@SpringBootApplication
public class DataSourceApplication implements CommandLineRunner {
    @Autowired
    private DataService dataService;

    public static void main(String[] args) {
        SpringApplication.run(DataSourceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String localData = dataService.getLocalData();
        System.out.println("Local data: " + localData);

        String remoteData = dataService.getRemoteData();
        System.out.println("Remote data " + remoteData);
    }
}
