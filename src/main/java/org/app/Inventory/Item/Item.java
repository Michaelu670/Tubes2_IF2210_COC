package org.app.Inventory.Item;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.app.money.MoneyHolder;
import org.app.money.Rupiah;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Accessors(fluent = true)
@NoArgsConstructor
@Root
public class Item extends ItemDescription {
    // type field can be change
    @Element
    @Builder.Default
    @NotNull private int stock = 0;
    @Element
    @Builder.Default
    @NotNull private MoneyHolder purchasePrice = new Rupiah(0);       // harga beli barang
}
