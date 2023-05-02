package org.app.Inventory.Item;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Accessors(fluent = true)
public class BillItem extends ItemDescription {
    private int quantity;
    private String orderType;
    private String notes;

    public BillItem(Item item){
        super(item);
        this.quantity = 1;
        this.orderType = "Dine In";
        this.notes = "";
    }
}
