package org.app.money;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@NoArgsConstructor
@AllArgsConstructor
@Root
public class Rupiah extends MoneyDecorator{
    @Element
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

    @Override
    public MoneyHolder cloneMoney() {
        return new Rupiah(value);
    }
}
