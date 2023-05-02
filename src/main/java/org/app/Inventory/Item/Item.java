package org.app.Inventory.Item;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Accessors(fluent = true)
public class Item extends ItemDescription {
    // type field can be change
    private int stock;
    private double purchasePrice;       // harga beli barang

}
