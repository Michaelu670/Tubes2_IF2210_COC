package org.app.Customer;

import org.app.Inventory.Holder.FixedBill;

import java.util.List;
abstract class RegisteredCustomer extends Customer {
    private String name;
    private String telephoneNumber;
    private double point;
    private boolean active;

    public RegisteredCustomer(int id, List<FixedBill> bills, String name, String telephoneNumber, double point, boolean active) {
        super(id, bills);
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.point = point;
        this.active = active;
    }
    public String getName() {
        return this.name;
    }
    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }
    public double getPoint() {
        return this.point;
    }
    public boolean isActive() {
        return this.active;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}