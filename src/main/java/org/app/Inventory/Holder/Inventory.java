package org.app.Inventory.Holder;

import lombok.*;
import lombok.experimental.Accessors;
import org.app.Inventory.Item.*;
import org.app.Inventory.*;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
public class Inventory implements ItemHolder {

    @Getter @Accessors(fluent = true)
    private List<Item> itemList = new ArrayList<>();

    @Override
    public <T extends ItemDescription> void addItem(T item) {
        itemList.add((Item) item);
    }

    @Override
    public <T extends ItemDescription> void removeItem(T item) {
        itemList.remove((Item) item);
    }

    @Override
    public Item getItem(int index) {
        return itemList.get(index);
    }

    public Item getItem(String itemName){
        for(Item item : itemList){
            if(item.itemName().equals(itemName)){
                return item;
            }
        }
        return null;
    }
}
