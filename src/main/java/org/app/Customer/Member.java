package org.app.Customer;

import java.util.List;

import lombok.Getter;
import org.app.Inventory.Holder.FixedBill;

class Member extends RegisteredCustomer {
    @Getter
    private final double poinRate = 0.01;

    public Member(int id, List<FixedBill> bills, String name, String telephoneNumber, double point, boolean active) {
        super(id, bills, name, telephoneNumber, point, active);
    }
}