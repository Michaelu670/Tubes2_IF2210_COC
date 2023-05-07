package org.app.Inventory.Holder;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.app.Inventory.Item.*;
import org.app.Inventory.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@SuperBuilder
@RequiredArgsConstructor
@Accessors(fluent = true)
public class Bill implements PurchaseDescription, ItemHolder {

    private final int user;  // change to Member instance
    // private final int billId;

    @Builder.Default
    private List<BillItem> itemList = new ArrayList<>();
    @Override
    public <T extends ItemDescription> void addItem(T item) {
        itemList.add((BillItem) item);
    }

    @Override
    public <T extends ItemDescription> void removeItem(T item) {
        itemList.remove((BillItem) item);
    }

    @Override
    public BillItem getItem(int index) {
        return itemList.get(index);
    }

    public BillItem getItem(String itemName){
        for(BillItem item : itemList){
            if(item.itemName().equals(itemName)){
                return item;
            }
        }
        return null;
    }

    @Override
    public double totalPrice() {
        return itemList.stream()
                .mapToDouble(item -> item.sellingPrice() * item.quantity())                
                .sum();
    }

    public @NonNull FixedBill confirm(){
        return new FixedBill(this);
    }
}
