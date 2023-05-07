package org.app.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.app.Inventory.Holder.FixedBill;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    @Test
    void builderTest(){
        List<FixedBill> bills = new ArrayList<>();

        Customer initCustomer = new Customer(0, bills);
        CustomerBuilder customerBuilder = new CustomerBuilder(initCustomer);
        Member first = (Member) customerBuilder.
                            name("first").
                            telephoneNumber("123")
                            .setMember()
                            .build();

        assertEquals(first.getName() , "first");
        assertEquals(first.getTelephoneNumber() , "123");
        assertEquals(first.getClass() , Member.class);

        VIP second = (VIP) customerBuilder.
                            name("second").
                            telephoneNumber("321")
                            .setVIP()
                            .build();

        assertEquals(second.getName() , "second");
        assertEquals(second.getTelephoneNumber() , "321");
        assertEquals(second.getClass() , VIP.class);
    }

    @Test
    void editCustomer(){
        List<FixedBill> bills = new ArrayList<>();

        Customer initCustomer = new Customer(0, bills);
        CustomerBuilder customerBuilder = new CustomerBuilder(initCustomer);
        Member first = (Member) customerBuilder.
                            name("first").
                            telephoneNumber("123")
                            .setMember()
                            .build();

        first.setName("test");
        first.setTelephoneNumber("456");

        assertEquals(first.getName() , "test");
        assertEquals(first.getTelephoneNumber() , "456");
    }
}
