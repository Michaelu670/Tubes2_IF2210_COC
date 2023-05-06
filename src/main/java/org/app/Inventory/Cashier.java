package org.app.Inventory;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.app.DataStore.DataHolder;
import org.app.Inventory.Holder.Bill;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Accessors(fluent = true)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
}
