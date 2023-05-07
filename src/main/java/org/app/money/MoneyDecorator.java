package org.app.money;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@NoArgsConstructor
@AllArgsConstructor
@Root
public abstract class MoneyDecorator implements MoneyHolder{
    public static MoneyHolder money = new Rupiah(0);
    public static MoneyHolder getCurrentMoney(double val) {
        MoneyHolder moneyHolder = money.cloneMoney();
        moneyHolder.setMoney(val);
        return moneyHolder;
    }


    @Element(required = false)
    protected @Nullable MoneyHolder wrapee;
    @Override
    public double getMoney() {
        return wrapee.getMoney();
    }

    @Override
    public void setMoney(double money) {
        wrapee.setMoney(money);
    }

}
