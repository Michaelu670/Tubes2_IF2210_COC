package org.app.Inventory;

import org.app.Inventory.Item.ItemDescription;

public interface ItemHolder {
    <T extends ItemDescription> void addItem(T item);
    <T extends ItemDescription> void removeItem(T item);
    ItemDescription getItem(int index);
}
