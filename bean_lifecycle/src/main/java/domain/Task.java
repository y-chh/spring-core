package domain;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Task {
    private String name;
    private Resource resource;

    // Instantiate Task Bean
    public Task(String name) {
        this.name = name;
        System.out.println("Task '" +name+"' instantiated !!!");
    }

    public String getName() {return name;}
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @PostConstruct
    public void initialize() {
        System.out.println("Task '" +name+ "' initialized !!!");
        if(resource != null) {
            resource.open();
        }
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Task '" +name+ "' cleaned up.");
        if(resource != null) {
            resource.close();
        }
    }


}
