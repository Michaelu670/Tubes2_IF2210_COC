package org.app.Customer;

import java.util.List;

import org.app.Inventory.Holder.FixedBill;

class VIP extends Member {
    private final double diskon = 0.1;

    public VIP(int id, List<FixedBill> bills, String name, String telephoneNumber, int point, boolean active) {
        super(id, bills, name, telephoneNumber, point, active);
    }
}