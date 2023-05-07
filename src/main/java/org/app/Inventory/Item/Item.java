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
@EqualsAndHashCode(callSuper = true)
@Accessors(fluent = true)
@NoArgsConstructor
@Root
public class Item extends ItemDescription {
    // type field can be change
    @Element
    @NotNull private int stock;
    @Element
    @NotNull private double purchasePrice;       // harga beli barang

}
