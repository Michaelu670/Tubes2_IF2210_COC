package org.app.Inventory;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.app.DataStore.DataHolder;
import org.app.Inventory.Holder.Bill;
import org.app.Inventory.Holder.FixedBill;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = false)
public class Cashier extends DataHolder implements BillHolder {
    private List<Bill> billList = new ArrayList<>();
    @Override
    public void addBill(Bill bill) {
        billList.add(bill);
    }
    @Override
    public void removeBill(Bill bill) {
        billList.remove(bill);
    }

    // get a Bill for a particular user
    public Bill getBill(int user){
        for(Bill bill : billList){
            if(bill.user() == user){
                return bill;
            }
        }
        return null;
    }

    public FixedBill getFixedBill(int user){
        Bill bill = getBill(user);
        FixedBill fixedBill = bill.confirm();
        removeBill(bill);
        return fixedBill;
    }
}
