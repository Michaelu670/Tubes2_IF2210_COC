package org.app.Customer;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.app.Inventory.Holder.FixedBill;

@NoArgsConstructor
public class Member extends RegisteredCustomer {
    @Getter
    private final double poinRate = 0.01;

    @Override
    public void getPoints(double price) {
        if (isActive()) {
            this.setPoint(this.getPoint() + price * poinRate);
        }
    }

    @Override
    public double usePoints(double price) {
        if (!isActive()) {
            return price;
        }
        double usedPoints = Math.min(price, getPoint());
        setPoint(getPoint() - usedPoints);
        return price - usedPoints;
    }

    public Member(int id, List<FixedBill> bills, String name, String telephoneNumber, double point, boolean active) {
        super(id, bills, name, telephoneNumber, point, active);
    }
}