package org.app.Inventory.Holder;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.app.Inventory.Item.*;
import org.app.Inventory.*;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode
@NoArgsConstructor
@Root
@Accessors(fluent = true)
public class Bill implements PurchaseDescription, ItemHolder, Serializable {

    @Element
    private int user;  // change to Member instance
    @Element
    private int billId;

    @Builder.Default
    @ElementList
    private List<BillItem> itemList = new ArrayList<>();
    
    public Bill(int user, int billSize) {
        this.user = user;
        this.billId = billSize;
        this.itemList = new ArrayList<>();
    }
    @Override
    public void addItem(ItemDescription item) {
        itemList.add((BillItem) item);
    }

    @Override
    public void removeItem(ItemDescription item) {
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
                .mapToDouble(item -> item.sellingPrice().getMoney() * item.quantity())
                .sum();
    }

    public @NonNull FixedBill confirm(Inventory stockList){

        if (stockList.itemList().isEmpty()){
            throw new IndexOutOfBoundsException("Stock is empty");
        }

        if (itemList.isEmpty()){
            throw new IndexOutOfBoundsException("Item is empty");
        }

        if (!checkItemNotNull()){
            throw new NullPointerException("Item is null");
        }

        if (!checkStock(stockList)){
            throw new IllegalArgumentException("Stock is not enough");
        }

        reduceStock(stockList);
        return new FixedBill(this);
    }

    private boolean checkItemNotNull(){
        for(BillItem item : itemList){
            if(item == null){
                return false;
            }
        }
        return true;
    }

    private boolean checkStock(Inventory stockList){
        for(BillItem item : itemList){
            List<Item> stockItem = stockList.searchItemName(item.itemName());
            if (stockItem.isEmpty()){
                throw new IndexOutOfBoundsException("Item is not found");
            }
            if(item.quantity() > stockItem.get(0).stock()){
                return false;
            }
        }
        return true;
    }

    private void reduceStock(Inventory stockList){
        for(BillItem item : itemList){
            List<Item> stockItem = stockList.searchItemName(item.itemName());
            if (stockItem.isEmpty()){
                continue;
            }
            stockItem.get(0).stock(stockList.searchItemName(item.itemName()).get(0).stock() - item.quantity());
        }
    }
}
