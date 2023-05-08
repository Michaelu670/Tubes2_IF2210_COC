package org.app.Customer;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.app.Inventory.Holder.FixedBill;
import org.simpleframework.xml.Root;

@Root
@NoArgsConstructor
public class VIP extends Member {
    @Getter
    private final double diskon = 0.1;

    @Override
    public double getFinalPrice(double price) {
        if (isActive()) {
            return price * (1 - diskon);
        }
        return price;
    }

    public VIP(int id, List<FixedBill> bills, String name, String telephoneNumber, double point, boolean active) {
        super(id, bills, name, telephoneNumber, point, active);
    }
}