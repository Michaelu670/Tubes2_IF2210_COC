package org.app.DataStore;

import org.app.Customer.Customers;
import org.app.Inventory.Cashier;
import org.app.Inventory.Holder.Inventory;

public interface DataStoreInterface {
    public Inventory inventory();
    public Cashier cashier();
    public Customers customers();

}
