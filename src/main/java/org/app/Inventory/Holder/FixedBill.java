package org.app.Inventory.Holder;

import java.util.ArrayList;
import java.util.List;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.app.Inventory.Item.BillItem;

@Data
@SuperBuilder
@Accessors(fluent = true)
public class FixedBill{
    private final int user;  // change to Member instance
    private final double totalPrice;
    private final List<BillItem> itemList;

    public FixedBill(@NonNull Bill bill){
        this.user = bill.user();
        this.totalPrice = bill.totalPrice();
        this.itemList = new ArrayList<>(bill.itemList());
    }

}
