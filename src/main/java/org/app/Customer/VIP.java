package org.app.Customer;

import org.app.Inventory.Holder.FixedBill;

import java.util.List;

class VIP extends Member {
    private final double diskon = 0.1;

    public VIP(int id, List<FixedBill> bills, String name, String telephoneNumber, int point, boolean active) {
        super(id, bills, name, telephoneNumber, point, active);
    }
}