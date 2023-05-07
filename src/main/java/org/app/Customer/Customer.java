package org.app.Customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.app.Inventory.Holder.FixedBill;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Getter
@Root
@EqualsAndHashCode
@NoArgsConstructor
public class Customer implements Serializable {
    @Attribute
    private int id;
    @ElementList
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
