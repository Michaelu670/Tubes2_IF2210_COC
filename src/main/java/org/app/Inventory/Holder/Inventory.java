package org.app.Inventory.Holder;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;
import lombok.experimental.Accessors;
import org.app.DataStore.DataHolder;
import org.app.Inventory.Item.*;
import org.app.Inventory.*;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
@EqualsAndHashCode
@Root
public class Inventory extends DataHolder implements ItemHolder {

    @Getter @Accessors(fluent = true)
    @ElementList
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

    public List<Item> searchItemName(String name){
        List<Item> items = new ArrayList<>();
        for(Item item : itemList){
            if(item.itemName().contains(name)){
                items.add(item);
            }
        }
        return items;
    }

    public List<Item> searchItemCategory(String categories){
        List<Item> items = new ArrayList<>();
        for(Item item : itemList){
            if(item.category().contains(categories)){
                items.add(item);
            }
        }
        return items;
    }

    public List<Item> sortItemPrice(boolean asc){
        List<Item> items = new ArrayList<>();
        items.addAll(itemList);
        if(asc){
            items.sort((o1, o2) -> (int) (o1.sellingPrice() - o2.sellingPrice()));
        }else{
            items.sort((o1, o2) -> (int) (o2.sellingPrice() - o1.sellingPrice()));
        }
        return items;
    }

    public List<Item> searchItemPrice(double price){
        List<Item> items = new ArrayList<>();
        for(Item item : itemList){
            if(item.sellingPrice() == price){
                items.add(item);
            }
        }
        return items;
    }

    public List<Item> searchItemPriceRange(double min, double max){
        List<Item> items = new ArrayList<>();
        for(Item item : itemList){
            if(item.sellingPrice() >= min && item.sellingPrice() <= max){
                items.add(item);
            }
        }
        return items;
    }
}
