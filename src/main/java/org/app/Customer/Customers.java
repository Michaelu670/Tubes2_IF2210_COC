package org.app.Customer;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.app.DataStore.DataHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customers extends DataHolder {
    private List<Customer> customerList;
    public Customers() {
        customerList = new ArrayList<>();
    }
    public List<Customer> getNotRegisteredCustomers() {
        return customerList.stream().filter(x -> x.getClass()
                .equals(Customer.class)).collect(Collectors.toList());
    }
    public void turnToMember(Customer customer, String name, String telephoneNumber) {
        customerList.remove(customer);
        customerList.add(new CustomerBuilder(customer)
                .name(name)
                .telephoneNumber(telephoneNumber)
                .setMember()
                .build());
    }

    public void turnToVIP(Customer customer, String name, String telephoneNumber) {
        customerList.remove(customer);
        customerList.add(new CustomerBuilder(customer)
                .name(name)
                .telephoneNumber(telephoneNumber)
                .setVIP()
                .build());
    }
}
