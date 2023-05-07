package org.app.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.app.Inventory.Holder.FixedBill;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Root
abstract class RegisteredCustomer extends Customer {
    @Element
    private String name;
    @Element
    private String telephoneNumber;
    @Element
    private double point;
    @Element
    private boolean active;

    public RegisteredCustomer(int id, List<FixedBill> bills, String name, String telephoneNumber, double point, boolean active) {
        super(id, bills);
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.point = point;
        this.active = active;
    }
}