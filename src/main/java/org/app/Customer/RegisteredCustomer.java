package org.app.Customer;

import lombok.Getter;
import lombok.Setter;
import org.app.Inventory.Holder.FixedBill;

import java.util.List;

@Getter @Setter
abstract class RegisteredCustomer extends Customer {
    private String name;
    private String telephoneNumber;
    private double point;
    private boolean active;

    public RegisteredCustomer(int id, List<FixedBill> bills, String name, String telephoneNumber, double point, boolean active) {
        super(id, bills);
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.point = point;
        this.active = active;
    }
}