package org.app.Inventory;

import org.app.Inventory.Holder.Bill;

public interface BillHolder {
    void addBill(Bill bill);
    void removeBill(Bill bill);
}
