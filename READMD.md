We will create a simple spring boot application with three classes, each demonstrating a different type of 
dependency injection: Constructor , Setter and Field.
We will discuss pros and cons of each type of injection, and implement best practices.

Questions?
1. Why constructor-based injection has a compiler warning suggesting that field should be final?
> This warning is not specific to spring or dependency injection but is rather a general java best practice
> related to constructors and immutability.
> 1. Immutability: Making fields 'final' ensure that their values cannot be changes once they are assigned.This contributes to the immutability of objects, which can have several benefits, including thread safety, predictability, and easier reasoning about code.
> 2. Constructor-based-initialization: Typically involves assigning values to fields during object creation. By making these fields 'final' , you enforce that their values are set only once and cannot be modified afterward.
> 3. Safety and Avoiding Mistakes: Making fields 'final' helps prevent accidental modification of their values, reducing the risk of introducing bugs related to unintended changes in the state of an object.
> 4. Clarity and Readability:
> 
2. Pros and Cons of different type of DI?
> 1. Constructor injection is recommended for mandatory dependencies, as it enforces that a bean is fully initialized when created. it also helps avoid issues with objects is an inconsistent state.
> 2. Setter injection is suitable for optional or dynamic dependencies, where you need flexibility in changing dependencies at runtime.
> 3. Field injection can be used for simplicity in classes with a single dependency, but it's generally recommended for optional dependencies or when there's no ambiguity.
> 4. Avoid circular dependencies, which can occur when two or more beans depend on each other. They should be carefully managed or refactored to prevent runtime issues.
> 5. Mixing injection types is possible if it makes sense for your use case. For example, constructor injection for mandatory dependencies and setter or field injection for optional dependencies.


**1. What does "object inconsistent state" mean?**

In the context of dependency injection and object-oriented programming, "object inconsistent state" refers to a situation where an object has not been fully initialized or configured to a valid state. It means that some of the object's internal fields or properties may not have been set to their expected or required values.

This can happen when an object is created but hasn't yet received all the necessary dependencies or configuration settings. When an object is in an inconsistent state, it may not behave correctly, and method calls on that object could lead to unexpected behavior or errors.

**2. What does "changing dependencies at runtime" mean with an example?**

"Changing dependencies at runtime" means that you can alter the components or services that a class depends on without modifying its code. This is typically achieved using dependency injection. Here's an example to illustrate this concept:

Suppose you have a `PaymentService` class that depends on a `PaymentGateway` to process payments. Initially, it uses a `CreditCardGateway` for payment processing:

```java
@Service
public class PaymentService {
    private final PaymentGateway paymentGateway;

    @Autowired
    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(Order order) {
        // Process the payment using the injected payment gateway
        paymentGateway.processPayment(order);
    }
}
```

Now, let's say you want to switch to a different payment gateway, such as a `PayPalGateway`, without changing the `PaymentService` class. You can do this by simply configuring Spring to inject a different implementation of `PaymentGateway` at runtime:

```java
@Configuration
public class PaymentConfig {

    @Bean
    public PaymentGateway paymentGateway() {
        // Return the desired implementation (e.g., PayPalGateway)
        return new PayPalGateway();
    }
}
```

By changing the configuration, you can switch between different implementations of `PaymentGateway` without modifying the `PaymentService` class. This is an example of changing dependencies at runtime.

**3. How does field injection pose difficulty in replacing dependencies with mocks during testing, and how to mitigate this?**

Field injection can pose difficulties in testing because dependencies are injected directly into fields, and there are no constructors or setter methods to pass mock dependencies. This makes it challenging to replace real dependencies with mock objects for testing purposes.

Here's an example that illustrates the testing challenge with field injection:

Suppose you have a `UserService` class with field injection:

```java
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String getUsernameById(Long id) {
        return userRepository.findById(id).getUsername();
    }
}
```

In your unit tests, you may want to replace the real `UserRepository` with a mock for isolation and control. However, with field injection, you cannot directly pass a mock `UserRepository` as you would with constructor or setter injection.

To mitigate this challenge, you can use a testing framework like Mockito along with the `@InjectMocks` and `@Mock` annotations to inject mocks into field-injected dependencies during testing. Here's how you can do it:

```java
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testGetUsernameById() {
        // Define the behavior of userRepository mock
        when(userRepository.findById(1L)).thenReturn(new User(1L, "john_doe"));

        // Perform the test
        String username = userService.getUsernameById(1L);

        // Assertions...
    }
}
```

In this example, Mockito is used to create a mock of `UserRepository`, and the `@InjectMocks` annotation is used to inject the `UserService` instance with the mock dependency. This allows you to test `UserService` with a mock repository while still using field injection.

To summarize, while field injection can pose challenges in testing, using testing frameworks like Mockito and following best practices for field injection testing can help mitigate these challenges and ensure effective unit testing of your Spring components.