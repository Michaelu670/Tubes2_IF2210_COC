import java.util.ArrayList;
import java.util.List;

import org.app.Inventory.Holder.FixedBill;

class Customer {
    private int id;
    private List<FixedBill> bills;
    
    public Customer(int id, List<FixedBill> bills) {
        this.id = id;
        this.bills = new ArrayList<>();
        for(int i = 0; i < bills.size(); i++) {
            this.bills.add(bills.get(i));
        }
    }
}