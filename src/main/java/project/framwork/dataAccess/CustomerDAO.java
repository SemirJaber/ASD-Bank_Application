package project.framwork.dataAccess;

import project.framwork.model.Customer;

public interface CustomerDAO {
    void addCustomer(Customer customer);
    boolean findCustomer(Customer customer);
    Customer getCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
}
