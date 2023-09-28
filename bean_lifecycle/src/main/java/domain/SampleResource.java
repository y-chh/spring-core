package domain;

public class SampleResource implements Resource{
    private final String resourceName;

    public SampleResource(String resourceName) {
        this.resourceName = resourceName;
    }
    @Override
    public void open() {
        System.out.println("Resource '" +resourceName+ "' opened.");
    }

    @Override
    public void close() {
        System.out.println("Resource '" +resourceName+ "' closed.");
    }
}
