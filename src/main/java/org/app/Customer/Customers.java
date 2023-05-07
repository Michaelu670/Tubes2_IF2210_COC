package org.app.Customer;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
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
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Root
@EqualsAndHashCode
public class Customers extends DataHolder {
    @ElementList
    private List<Customer> customerList;
    public Customers() {
        customerList = new ArrayList<>();
    }
    public Customer newCustomer(FixedBill bill) {
        Customer customer =
                new Customer(customerList
                        .get(customerList.size() - 1)
                        .getId() + 1
                , new ArrayList<>());
        customer.getBills().add(bill);

        customerList.add(customer);
        return customer;
    }
    public List<Customer> getNotRegisteredCustomers() {
        return customerList.stream().filter(x -> x.getClass()
                .equals(Customer.class)).collect(Collectors.toList());
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
