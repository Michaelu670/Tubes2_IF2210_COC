package org.app.Customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerSelectorTest {
    Customers getTestInstance() {
        Customers customers = new Customers();
        customers.getCustomerList().add(new Customer(2, new ArrayList<>()));
        customers.getCustomerList().add(new Customer(0, new ArrayList<>()));
        customers.getCustomerList().add(new Customer(1, new ArrayList<>()));
        customers.turnToMember(1, "member", "08member");
        customers.turnToVIP(2, "vip", "08vip");
        return customers;
    }
    @Test
    void customer_select_all_sorted() {
        Customers customers = getTestInstance();
        List<Customer> customerList =
                new CustomerSelector(customers)
                    .addCustomer()
                    .addMember()
                    .addCustomer()
                    .addVIP()
                    .sorted(true)
                    .get();

        assertThat(customerList.size()).isEqualTo(3);
        for (int i = 0; i < 3; i++)
            assertThat(customerList.get(i).getId()).isEqualTo(i);

    }

    @Test
    void customer_only_member_and_vip_unsorted() {
        Customers customers = getTestInstance();
        List<Customer> customerList =
                new CustomerSelector(customers)
                        .addMember()
                        .addVIP()
                        .sorted(false)
                        .get();

        assertThat(customerList.size()).isEqualTo(2);
    }
}
