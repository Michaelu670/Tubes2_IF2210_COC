package org.app.Inventory.Item;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@SuperBuilder
@Getter @Setter
@NoArgsConstructor
@Accessors(fluent = true)
@EqualsAndHashCode
@Root

// menginherit Item dan BillItem
public abstract class ItemDescription implements Serializable {
    @Element
    @NonNull private String itemName;
    @Element
    private double sellingPrice;        // harga
    @Element
    @NonNull private String category;
    @Element
    @NonNull private String imagePath;

    protected ItemDescription(Item item){
        this.itemName = item.itemName();
        this.sellingPrice = item.sellingPrice();
        this.category = item.category();
        this.imagePath = item.imagePath();
    }
}
