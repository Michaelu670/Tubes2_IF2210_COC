package org.app.Inventory;

import org.app.Inventory.Item.ItemDescription;

public interface ItemHolder {
    void addItem(ItemDescription item);
    void removeItem(ItemDescription item);
    ItemDescription getItem(int index);
}
