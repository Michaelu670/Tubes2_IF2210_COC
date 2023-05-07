package org.app.Customer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.app.DataStore.DataHolder;
import org.app.Inventory.Holder.Bill;
import org.app.Inventory.Holder.FixedBill;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
                new Customer(customerList
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
    public void turnToMember(int id, String name, String telephoneNumber) {
        Customer customer = getCustomerFromID(id);
        customerList.remove(customer);
        customerList.add(customer.getId(), new CustomerBuilder(customer)
                .name(name)
                .telephoneNumber(telephoneNumber)
                .setMember()
                .build());
    }

    public void turnToVIP(int id, String name, String telephoneNumber) {
        Customer customer = getCustomerFromID(id);
        customerList.remove(customer);
        customerList.add(customer.getId(), new CustomerBuilder(customer)
                .name(name)
                .telephoneNumber(telephoneNumber)
                .setVIP()
                .build());
    }

}
