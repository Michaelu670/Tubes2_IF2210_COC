package org.app.Inventory.Item;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.app.money.MoneyHolder;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@SuperBuilder
@Getter @Setter
@NoArgsConstructor(force = true)
@Accessors(fluent = true)
@EqualsAndHashCode
@Root

// menginherit Item dan BillItem
public abstract class ItemDescription implements Serializable {
    @Element
    @NonNull private String itemName;
    @Element
    private MoneyHolder sellingPrice;        // harga
    @Element
    @NonNull private String category;
    @Element
    @Builder.Default
    @NonNull private String imagePath = "";

    protected ItemDescription(BillItem item){
        this.itemName = new String(item.itemName());
        this.sellingPrice = item.sellingPrice();
        this.category = new String( item.category());
        this.imagePath = new String(item.imagePath());
    }

    protected ItemDescription(Item item){
        this.itemName = (item.itemName());
        this.sellingPrice = item.sellingPrice();
        this.category = (item.category());
        this.imagePath =(item.imagePath());
    }
    
}
