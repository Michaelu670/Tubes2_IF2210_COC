package org.app.Customer;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.app.Inventory.Holder.FixedBill;

class Customer {
    private int id;
    private List<FixedBill> bills;
    
    public Customer(int id, List<FixedBill> bills) {
        this.id = id;
        this.bills = new ArrayList<>();
        this.bills.addAll(bills);
    }
    public int getId() {
        return this.id;
    }
    public FixedBill getFixedBillAt(int idx) {
        return this.bills.get(idx);
    }
    public void addFixedBill(FixedBill fixedBill) {
        this.bills.add(fixedBill);
    }
}
