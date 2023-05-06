package org.app.Customer;

import org.app.Inventory.Holder.FixedBill;

import java.util.List;
abstract class RegisteredCustomer extends Customer {
    private String name;
    private String telephoneNumber;
    private int point;
    private boolean active;

    public RegisteredCustomer(int id, List<FixedBill> bills, String name, String telephoneNumber, int point, boolean active) {
        super(id, bills);
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.point = point;
        this.active = active;
    }
}