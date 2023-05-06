package org.app.Customer;

import java.util.List;

import org.app.Inventory.Holder.FixedBill;

class Member extends RegisteredCustomer {
    private final double poin_rate = 0.01;

    public Member(int id, List<FixedBill> bills, String name, String telephoneNumber, double point, boolean active) {
        super(id, bills, name, telephoneNumber, point, active);
    }
    public double getPoin_rate() {
        return this.poin_rate;
    }
}