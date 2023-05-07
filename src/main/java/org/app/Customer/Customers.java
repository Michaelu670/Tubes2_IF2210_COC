package org.app.Customer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Root
@EqualsAndHashCode
public class Customers {
    @ElementList
    private List<Customer> customerList;
    public Customers() {
        customerList = new ArrayList<>();
    }
    public Customer newCustomer() {
        Customer customer =
                new Customer(customerList.isEmpty() ? 0 : customerList
                        .get(customerList.size() - 1)
                        .getId() + 1
                , new ArrayList<>());

        customerList.add(customer);
        return customer;
    }
    public List<Customer> getNotRegisteredCustomers() {
        return new CustomerSelector(this)
                .addCustomer()
                .get();
    }
    public Customer getCustomerFromID(int id) {
        return customerList.stream()
                .filter(customer -> customer.getId() == id)
                .findAny().get();
    }
    public void turnToMember(int id, String name, String telephoneNumber, double point, boolean status) {
        Customer customer = getCustomerFromID(id);
        customerList.remove(customer);
        customerList.add(customer.getId(), new CustomerBuilder(customer)
                .name(name)
                .telephoneNumber(telephoneNumber)
                .point(point)
                .status(status)
                .setMember()
                .build());
    }

    public void turnToVIP(int id, String name, String telephoneNumber, double point, boolean status) {
        Customer customer = getCustomerFromID(id);
        customerList.remove(customer);
        customerList.add(customer.getId(), new CustomerBuilder(customer)
                .name(name)
                .telephoneNumber(telephoneNumber)
                .point(point)
                .status(status)
                .setVIP()
                .build());
    }

}
