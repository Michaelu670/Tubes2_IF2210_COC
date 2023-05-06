package org.app.Customer;

import lombok.Getter;
import lombok.Setter;
import org.app.Inventory.Holder.FixedBill;

import java.util.List;
abstract class RegisteredCustomer extends Customer {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String telephoneNumber;
    @Getter @Setter
    private double point;
    @Getter @Setter
    private boolean active;

    public RegisteredCustomer(int id, List<FixedBill> bills, String name, String telephoneNumber, double point, boolean active) {
        super(id, bills);
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.point = point;
        this.active = active;
    }
}