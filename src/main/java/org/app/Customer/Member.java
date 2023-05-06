package org.app.Customer;

import java.util.List;

import org.app.Inventory.Holder.FixedBill;

class Member extends RegisteredCustomer {
    private final double poin_rate = 0.01;

    public Member(int id, List<FixedBill> bills, String name, String telephoneNumber, int point, boolean active) {
        super(id, bills, name, telephoneNumber, point, active);
    }
}