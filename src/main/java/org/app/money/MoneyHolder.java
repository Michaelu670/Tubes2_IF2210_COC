package org.app.money;

import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root
public interface MoneyHolder extends Serializable {
    double getMoney();
    void setMoney(double money);
    String getInitial();
    MoneyHolder cloneMoney();
}
