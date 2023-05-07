package org.app.Inventory.Item;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Accessors(fluent = true)
@Root
public class BillItem extends ItemDescription implements Serializable {
    @Element
    @NotNull private int quantity;
    @Element
    @NotNull private String orderType;
    @Element(required = false)
    @NotNull private String notes = "";

    public BillItem(Item item){
        super(item);
        this.quantity = 1;
        this.orderType = "Dine In";
        this.notes = "";
    }
}
