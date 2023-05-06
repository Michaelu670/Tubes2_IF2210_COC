package org.app.Customer;

import java.util.List;

import lombok.Getter;
import org.app.Inventory.Holder.FixedBill;

class VIP extends Member {
    @Getter
    private final double diskon = 0.1;

    public VIP(int id, List<FixedBill> bills, String name, String telephoneNumber, double point, boolean active) {
        super(id, bills, name, telephoneNumber, point, active);
    }
}