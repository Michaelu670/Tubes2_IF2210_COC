package org.app.money;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Rupiah extends MoneyDecorator{
    private double value;

    @Override
    public double getMoney() {
        return value;
    }

    @Override
    public void setMoney(double money) {
        this.value = money;
    }

    @Override
    public String getInitial() {
        return "IDR";
    }
}
