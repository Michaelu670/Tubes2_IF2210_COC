package org.app.DataStore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.app.Customer.Customer;
import org.app.Customer.Customers;
import org.app.Customer.Member;
import org.app.Customer.VIP;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Root
@Getter
@NoArgsConstructor
public class CustomerTypeAdapter extends DataHolder implements Serializable {
    private transient Customers adaptee;
    @ElementList
    private List<Customer> customerList;
    @ElementList
    private List<Member> memberList;
    @ElementList
    private List<VIP> vipList;

    public CustomerTypeAdapter(Customers adaptee) {
        this.adaptee = adaptee;
        customerList = new ArrayList<>();
        memberList = new ArrayList<>();
        vipList = new ArrayList<>();
    }

    @Override
    public void setData(Loadable data) throws Exception {
        super.setData(data);
        adaptee.getCustomerList().clear();
        adaptee.getCustomerList().addAll(customerList);
        adaptee.getCustomerList().addAll(memberList);
        adaptee.getCustomerList().addAll(vipList);
        adaptee.getCustomerList().sort(Comparator.comparingInt(Customer::getId));


    }

    @Override
    public Loadable getData() {

        customerList = adaptee.getCustomerList()
                .stream()
                .filter(x ->x.getClass() == Customer.class)
                .collect(Collectors.toList());
        memberList = adaptee.getCustomerList()
                .stream()
                .filter(x ->x.getClass() == Member.class)
                .map(x -> (Member) x)
                .collect(Collectors.toList());
        vipList = adaptee.getCustomerList()
                .stream()
                .filter(x ->x.getClass() == VIP.class)
                .map(x -> (VIP) x)
                .collect(Collectors.toList());
        return this;
    }
}
