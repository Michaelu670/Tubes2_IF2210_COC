package org.app.Customer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerSelector {
    /**
     * Usage:
     * new CustomerSelector(customers)
     *      .addMember()
     *      .addCustomer()
     *      .addVIP()
     *      .get();
     *
     * Returns: List<Customer>
     *
     *
     * Options:
     * sorted(boolean) -> default true (don't set to false when comparing)
     */

    private Customers customers;
    private List<Customer> customerList;
    private boolean memberadd;
    private boolean customeradd;
    private boolean vipadd;
    private boolean sortLater;

    public CustomerSelector(Customers customers) {
        this.customers = customers;
        customerList = new ArrayList<>();
        memberadd = false;
        customeradd = false;
        vipadd = false;
        sortLater = true;
    }
    public CustomerSelector addMember() {
        if (!memberadd) {
            memberadd = true;
            customerList.addAll(
                    customers.getCustomerList()
                            .stream()
                            .filter(x -> x.getClass().equals(Member.class))
                            .collect(Collectors.toList())
            );
        }
        return this;
    }

    public CustomerSelector addCustomer() {
        if (!customeradd) {
            customeradd = true;
            customerList.addAll(
                    customers.getCustomerList()
                            .stream()
                            .filter(x -> x.getClass().equals(Customer.class))
                            .collect(Collectors.toList())
            );
        }
        return this;
    }

    public CustomerSelector addVIP() {
        if (!vipadd) {
            vipadd = true;
            customerList.addAll(
                    customers.getCustomerList()
                            .stream()
                            .filter(x -> x.getClass().equals(VIP.class))
                            .collect(Collectors.toList())
            );
        }
        return this;
    }

    public CustomerSelector sorted(boolean sortLater) {
        this.sortLater = sortLater;
        return this;
    }

    public List<Customer> get() {
        customerList.sort(Comparator.comparingInt(Customer::getId));
        return customerList;
    }

    public List<Member> getAsMember() {
        customerList.sort(Comparator.comparingInt(Customer::getId));
        return customerList.stream()
                .map(x -> (Member)x)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<VIP> getAsVIP() {
        customerList.sort(Comparator.comparingInt(Customer::getId));
        return customerList.stream()
                .map(x -> (VIP)x)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
