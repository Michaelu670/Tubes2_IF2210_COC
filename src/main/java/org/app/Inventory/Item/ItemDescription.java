package org.app.Inventory.Item;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter @Setter
@Accessors(fluent = true)

// menginherit Item dan BillItem
public abstract class ItemDescription {
    @NonNull private String itemName;
    private double sellingPrice;        // harga barang
    @NonNull private String category;
    @NonNull private String imagePath;

    protected ItemDescription(Item item){
        this.itemName = item.itemName();
        this.sellingPrice = item.sellingPrice();
        this.category = item.category();
        this.imagePath = item.imagePath();
    }
}
