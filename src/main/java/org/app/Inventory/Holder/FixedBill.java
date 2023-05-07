package org.app.Inventory.Holder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.app.Inventory.Item.BillItem;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = true)
@Root
@EqualsAndHashCode
public class FixedBill implements Serializable {
    @Element
    private int user;  // change to Member instance
    @Element
    private int billId;
    @Element
    private double totalPrice;
    @ElementList
    @NotNull private List<BillItem> itemList;

    public FixedBill(@NonNull Bill bill){
        this.user = bill.user();
        this.billId = bill.billId();
        this.totalPrice = bill.totalPrice();
        this.itemList = new ArrayList<>();
        for (BillItem item : bill.itemList()) {
            BillItem copyItem = new BillItem(item);
            this.itemList.add(copyItem);
        }
    }

}
