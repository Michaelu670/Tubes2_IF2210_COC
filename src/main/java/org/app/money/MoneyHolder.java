package org.app.money;

import java.io.Serializable;

public interface MoneyHolder extends Serializable {
    double getMoney();
    void setMoney(double money);
    String getInitial();
}
