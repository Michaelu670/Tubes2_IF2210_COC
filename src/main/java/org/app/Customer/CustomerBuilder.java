package org.app.Customer;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerBuilder {
    @NotNull Customer customer;
    @NotNull String name;
    @NotNull String telephoneNumber;

    public CustomerBuilder(Customer customer) {
        this.customer = customer;
        this.name = "";
        this.telephoneNumber = "";
    }

    public Customer build() {
        return customer;
    }
    public CustomerBuilder name(String name) {
        this.name = name;
        return this;
    }
    public CustomerBuilder telephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }
    public CustomerBuilder setMember() {
        this.customer = new Member(customer.getId(), customer.getBills(),
                this.name, this.telephoneNumber, 0, true);
        return this;
    }
    public CustomerBuilder setVIP() {
        this.customer = new VIP(customer.getId(), customer.getBills(),
                this.name, this.telephoneNumber, 0, true);
        return this;
    }
}
