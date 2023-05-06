package org.app.Customer;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;


import org.app.Inventory.Holder.FixedBill;

class Customer {
    @Getter
    private int id;
    private List<FixedBill> bills;
    
    public Customer(int id, List<FixedBill> bills) {
        this.id = id;
        this.bills = new ArrayList<>();
        this.bills.addAll(bills);
    }
    public FixedBill getFixedBillAt(int idx) {
        return this.bills.get(idx);
    }
    public void addFixedBill(FixedBill fixedBill) {
        this.bills.add(fixedBill);
    }
}
