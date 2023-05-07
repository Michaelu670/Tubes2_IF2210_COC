package org.app.money;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public abstract class MoneyDecorator implements MoneyHolder{
    private @Nullable MoneyHolder wrapee;
    @Override
    public double getMoney() {
        return wrapee.getMoney();
    }

    @Override
    public void setMoney(double money) {
        wrapee.setMoney(money);
    }

}
