package org.app.Customer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.app.Inventory.Holder.FixedBill;

import java.util.List;

@AllArgsConstructor
@Accessors
public class Customer {
    private int id;
    private List<FixedBill> bills;
}
