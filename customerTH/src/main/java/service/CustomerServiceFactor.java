package service;

public class CustomerServiceFactor {
    private static CustomerService singleton;

    public static synchronized CustomerService getInstance() {
        if (singleton == null) {
            singleton = new CustomerImpl();
        }
        return singleton;
    }
}
